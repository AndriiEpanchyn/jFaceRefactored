package jfacerefactored.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import jfacerefactored.eventsAndListeners.MyModifyListener;
import jfacerefactored.eventsAndListeners.SelectionEventCancelActionListener;
import jfacerefactored.eventsAndListeners.SelectionEventDeleteRecordListener;
import jfacerefactored.eventsAndListeners.SelectionEventNewRecordListener;
import jfacerefactored.eventsAndListeners.SelectionEventSaveRecordListener;
import jfacerefactored.model.Session;

public class FormComposite extends Composite {
	private Text textName, textGroup;
	private Label labelName, labelGroup, labelSWTisDone;
	private Button buttonSWTisDone;
	public Button buttonNew, buttonSave, buttonDelete, buttonCancel;
	private MyAppWindow appInstance;	
	private Session session;

	public FormComposite(Composite parent, int style) {
		super(parent, style);
		appInstance = MyAppWindow.getInstance();
		session = appInstance.getSession();
		createContent(this);
	}

	private void createContent(FormComposite formComposite) {	
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.marginHeight = 5;
		gridLayout.marginWidth = 5;
		gridLayout.horizontalSpacing = 10;
		gridLayout.verticalSpacing = 10;
		gridLayout.marginBottom = 10;
				
		formComposite.setLayout(gridLayout);
		
		//Create Labels
		labelName = ElementsBuilder.createCommonLabel("Name", formComposite);
		textName = ElementsBuilder.createText(formComposite, true);
		
		labelGroup = ElementsBuilder.createCommonLabel("Group", formComposite);
		textGroup = ElementsBuilder.createText(formComposite, false);
		
		labelSWTisDone = ElementsBuilder.createCommonLabel("SWT task is done?", formComposite);
		buttonSWTisDone = new Button(formComposite, SWT.CHECK |SWT.NONE);
		buttonSWTisDone.setSelection(false);
		buttonSWTisDone.setLayoutData(GridDataBuilder.createGridForText());
		buttonSWTisDone.addListener(SWT.Selection, new MyModifyListener());
		
		//Buttons
		buttonNew = ElementsBuilder.createButton(formComposite, "New", 
				GridDataBuilder.createGridForButtonNew());
		buttonNew.addSelectionListener(new SelectionEventNewRecordListener());
		
		buttonSave = ElementsBuilder.createButton(formComposite, "Save",
				GridDataBuilder.createGridWithCammonProperties());
		buttonSave.addSelectionListener(new SelectionEventSaveRecordListener());

		buttonDelete = ElementsBuilder.createButton(formComposite, "Delete",
				GridDataBuilder.createGridWithCammonProperties());
		buttonDelete.addSelectionListener(new SelectionEventDeleteRecordListener());
	
		buttonCancel = ElementsBuilder.createButton(formComposite, "Cancel",
				GridDataBuilder.createGridWithCammonProperties());
		buttonCancel.setEnabled(true);
		buttonCancel.addSelectionListener(new SelectionEventCancelActionListener());

	}
		
		public String getName() {
			return textName.getText()==null? "":textName.getText();
		}
		
		public String getGroup() {
			return textGroup.getText()== null? "": textGroup.getText();
		}
		
		public boolean isSWTDone() {
			return buttonSWTisDone.getSelection();
		}

		public void getFormFieldsFromSession(){
			textName.setText("");
			textName.setText(session.name);
			textGroup.setText(session.group);
			buttonSWTisDone.setSelection(session.swtDone);
		}
		
		public void saveFieldsToSession(){
			session.name = getName();
			session.group =getGroup();
			session.swtDone =isSWTDone();
		}

		public void clearFields(){
			textName.setText("");
			textGroup.setText("");
			buttonSWTisDone.setSelection(false);
		}
		
		public void changeButtonsStatus(boolean buttonNewStatus, boolean buttonSaveStatus,
				boolean buttonDeleteStatus) {
			buttonNew.setEnabled(buttonNewStatus);
			buttonSave.setEnabled(buttonSaveStatus);
			buttonDelete.setEnabled(buttonDeleteStatus);
		}
	
}
