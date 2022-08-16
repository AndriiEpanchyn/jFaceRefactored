package jfacerefactored.actionsMethods.menuFileActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.savers.FileReadManager;
import jfacerefactored.ui.MyAppWindow;

public class OpenFileAction extends Action {
    MyAppWindow _window;

    public OpenFileAction(MyAppWindow window) {
	_window = window;
	setText("Open file \tCtrl+O");
	setToolTipText("Open file");
    }

    public void run() {
	_window.clearFields();
	FileReadManager.execute(_window);
	_window.getShell().setText("JFace application:  " + _window.getSession().fileName);
	_window.getTableComposite().reassignTableInput();
	_window.redrawAll();
    }
}
