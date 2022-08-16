package jfacerefactored.ui.tableviewer;

import java.lang.reflect.Method;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import jfacerefactored.eventsAndListeners.TableSelectionChangedListener;
import jfacerefactored.model.Entity;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;


public class TableComposite extends Composite {
	private MyAppWindow appInstance;	
	private Session session;
	private TableViewer viewer;
	
	public TableComposite(Composite parent, int style) {
		super(parent, style);
		appInstance = MyAppWindow.getInstance();
		session = appInstance.getSession();
		createContent();
	}
	
	public void createContent() {
		viewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		viewer.setContentProvider(ArrayContentProvider.getInstance());

		String[] columnNames = Entity.getFieldsNames();
		for (String colName : columnNames) {
			createColumnName(viewer, colName);
		}

		viewer.getTable().getColumn(2).setWidth(80);
		viewer.setInput(session.getAllRecords());
		viewer.getTable().setSelection(0);
		viewer.getTable().setLinesVisible(true);
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setHeaderBackground(new Color(181, 181, 181));
		viewer.addSelectionChangedListener(new TableSelectionChangedListener()); 
	}
	
	private void createColumnName(TableViewer viewer, String columnName) {
		TableViewerColumn column = new TableViewerColumn(viewer, SWT.CHECK);
		column.getColumn().setText(columnName.toUpperCase());
		column.getColumn().setWidth(180);
		column.getColumn().setAlignment(SWT.CENTER);
		column.getColumn().setMoveable(false);
		column.getColumn().setResizable(false);
		column.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return getElementValue(columnName, element);
			}
		});
		ColumnViewerComparator cSorter = new ColumnViewerComparator(viewer, column) {
			@Override
			protected int doCompare(Viewer viewer, Object e1, Object e2) {
				String p1 = getElementValue(columnName, e1);
				String p2 = getElementValue(columnName, e2);
				return p1.compareToIgnoreCase(p2);
			}
		};
	}
	
	private String getElementValue(String columnName, Object element) {
		String answerString = "";
		try {
			Method tmpMethod = Entity.getRefferedMethods().get(columnName);
			answerString = String.valueOf(tmpMethod.invoke((Entity) element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return answerString;
	}

	public void reassignTableInput() {
		viewer.setInput(session.unsavedRecords);
		viewer.getTable().deselectAll();
	}
	
	public void deselectAll() {
		viewer.getTable().deselectAll();
	}
	
	public void refreshTable() {
		viewer.refresh();
	}	
}
