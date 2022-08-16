package jfacerefactored.actionsMethods.menuEditActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.actionsMethods.ActionMethods;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;

public class SaveRowAction extends Action {

    public SaveRowAction(MyAppWindow window, boolean status) {
	this.setText("Save record \tCtrl+M");
	this.setToolTipText("Save record");
	this.setEnabled(status);
    }

    public void run() {
    	MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		ActionMethods.saveOrAddRecord(()->session.saveFieldsToCurrentRecord());
    }
}
