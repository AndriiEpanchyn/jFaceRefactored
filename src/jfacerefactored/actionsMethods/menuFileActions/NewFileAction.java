package jfacerefactored.actionsMethods.menuFileActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.ui.MyAppWindow;

public class NewFileAction extends Action {
    MyAppWindow _window;

    public NewFileAction(MyAppWindow window) {
	_window = window;
	setText("New File \tCtrl+N");
	setToolTipText("New File");
    }

    public void run() {
	_window.getSession().clear();
	_window.clearFields();
	_window.getShell().setText("JFace application:  " + _window.getSession().fileName);
	_window.getTableComposite().reassignTableInput();
	_window.redrawAll();
    }
}
