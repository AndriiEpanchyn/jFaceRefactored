package jfacerefactored.actionsMethods.menuFileActions;

import org.eclipse.jface.action.Action;

import jfacerefactored.savers.FileSaveManager;
import jfacerefactored.ui.MyAppWindow;

public class SaveFileAction extends Action {
    MyAppWindow _window;

    public SaveFileAction(MyAppWindow parent) {
	_window = parent;
	setText("Save file \tCtrl+S");
	setToolTipText("Save File");
    }

    public void run() {
	FileSaveManager.execute(_window, false);
	_window.getShell().setText("JFace application:  " + _window.getSession().fileName);
	_window.getTableComposite().reassignTableInput();
	_window.redrawAll();
    }
}
