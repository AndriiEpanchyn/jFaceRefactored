package jfacerefactored.actionsMethods.menuEditActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.actionsMethods.ActionMethods;
import jfacerefactored.ui.MyAppWindow;


public class DeleteAction extends Action {
    MyAppWindow _window;
    boolean isActive = true;

    public DeleteAction(MyAppWindow window, boolean status) {
	_window = window;
	setText("Delete record \tCtrl+D");
	setToolTipText("Delete record");
	isActive = status;
	this.setEnabled(isActive);
    }

    public void run() {
    	ActionMethods.deleteRecordAction();
    }
}
