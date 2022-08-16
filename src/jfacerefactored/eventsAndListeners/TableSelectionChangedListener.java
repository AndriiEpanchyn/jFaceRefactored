package jfacerefactored.eventsAndListeners;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;

import jfacerefactored.model.Entity;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;

public class TableSelectionChangedListener implements ISelectionChangedListener {

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		TableViewer viewer = (TableViewer)event.getSource();
		
		IStructuredSelection selection = viewer.getStructuredSelection();
		session.activeRecord = (Entity) selection.getFirstElement();
		if (session.activeRecord == null) {
			appInstance.clearFields();
		} else {
			session.name = session.activeRecord.getName();
			session.group = session.activeRecord.getGroup();
			session.swtDone = session.activeRecord.getSwtDone();
		}
		appInstance.getFormComposite().getFormFieldsFromSession();
		appInstance.getTableComposite().deselectAll();
		appInstance.changeMenuAndButtonsStatus(false, false, true);
	}

}
