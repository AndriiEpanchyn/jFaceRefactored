package jfacerefactored.actionsMethods.menuFileActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.savers.FileSaveManager;
import jfacerefactored.ui.MyAppWindow;

public class SaveAsFileAction extends Action {
    MyAppWindow _window;

    public SaveAsFileAction(MyAppWindow parent) {
	_window = parent;
	setText("File save as \tCtrl+F");
	setToolTipText("File save as");
    }

    public void run() {
	FileSaveManager.execute(_window, true);
	_window.getShell().setText("JFace application:  " + _window.getSession().fileName);
	_window.getTableComposite().reassignTableInput();
	_window.redrawAll();
    }
}
