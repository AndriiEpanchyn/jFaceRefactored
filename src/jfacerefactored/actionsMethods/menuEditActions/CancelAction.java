package jfacerefactored.actionsMethods.menuEditActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.actionsMethods.ActionMethods;
import jfacerefactored.ui.MyAppWindow;

public class CancelAction extends Action {
    MyAppWindow _window;

    public CancelAction(MyAppWindow parent) {
	_window = parent;
	setText("Cancel \tCtrl+Q");
	setToolTipText("Cancel");
    }

    public void run() {
    	ActionMethods.cancelAction();
    }
}
