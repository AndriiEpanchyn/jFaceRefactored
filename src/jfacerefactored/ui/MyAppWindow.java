package jfacerefactored.ui;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import jfacerefactored.actionsMethods.menuEditActions.DeleteAction;
import jfacerefactored.actionsMethods.menuEditActions.NewRowAction;
import jfacerefactored.actionsMethods.menuEditActions.SaveRowAction;
import jfacerefactored.model.Session;
import jfacerefactored.ui.tableviewer.TableComposite;

public class MyAppWindow extends ApplicationWindow {
	private static MyAppWindow appInstance;
	private Session session;

	private Shell mainWindow;
	private SashForm form;
	private TableComposite tableComposite;
	private FormComposite formComposite;

	public boolean buttonNewStatus, buttonSaveStatus, buttonDeleteStatus;

	public NewRowAction newRowAction = new NewRowAction(this, buttonNewStatus);
	public SaveRowAction newSaveRowAction = new SaveRowAction(this, buttonSaveStatus);
	public DeleteAction newDeleteAction = new DeleteAction(this, buttonDeleteStatus);

	private MyAppWindow() {
		super(null);
		session = new Session().createDummyRecords();
		addMenuBar();
	}

	public static MyAppWindow getInstance() {
		if (appInstance == null) {
			appInstance = new MyAppWindow();
		}
		return appInstance;
	}

	public MyAppWindow(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void initializeBounds() {
		WindowConfigurer.start(getShell());
	}

	@Override
	protected Control createContents(Composite parent) {
		mainWindow = this.getShell();
		Group generalComposite = new Group(mainWindow, SWT.V_SCROLL);
		generalComposite.setLayout(new FillLayout());

		form = new SashForm(generalComposite, SWT.BORDER);
		form.setLayout(new FillLayout());
		form.SASH_WIDTH = 1;

		Composite leftComposite = new Composite(form, SWT.NONE);
		leftComposite.setLayout(new FillLayout());

		Composite rightComposite = new Composite(form, SWT.NONE);
		FillLayout fillLayoutRight = new FillLayout(SWT.VERTICAL);
		rightComposite.setLayout(fillLayoutRight);

		tableComposite = new TableComposite(leftComposite, SWT.BORDER);
		tableComposite.setLayout(new FillLayout());

		formComposite = new FormComposite(rightComposite, SWT.BORDER);

		form.setWeights(new int[] { 54, 46 });
		parent.pack();
		return parent;
	}

	@Override
	protected MenuManager createMenuManager() {
		return MenuBuilder.create(this);
	}

	public Session getSession() {
		return session;
	}

	public void clearFields(){
		session.name = "";
		session.group = "";
		session.swtDone = false;
		session.activeRecord = null;
		getFormComposite().getFormFieldsFromSession();
		redrawAll();
	}

	public FormComposite getFormComposite() {
		return formComposite;
	}

	public TableComposite getTableComposite() {
		return tableComposite;
	}
	
	public void changeMenuAndButtonsStatus(boolean buttonNewStatus, boolean buttonSaveStatus,
			boolean buttonDeleteStatus) {
		getFormComposite().changeButtonsStatus(buttonNewStatus, buttonSaveStatus, buttonDeleteStatus);
		newRowAction.setEnabled(buttonNewStatus);
		newSaveRowAction.setEnabled(buttonSaveStatus);
		newDeleteAction.setEnabled(buttonDeleteStatus);
		redrawAll();
	}

	public void redrawAll() {
		getFormComposite().redraw();
		getTableComposite().refreshTable();
		getTableComposite().redraw();
	}

}
