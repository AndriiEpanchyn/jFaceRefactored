package jfacerefactored.actionsMethods.menuEditActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.actionsMethods.ActionMethods;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;


public class NewRowAction extends Action {    
    public NewRowAction(MyAppWindow window, boolean status) {
	setText("New row \tCtrl+R");
	setToolTipText("New row");
	this.setEnabled(status);
    }

    public void run() {
    	MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		ActionMethods.saveOrAddRecord(()->session.saveFieldsToNewRecord());
	
    }
}
