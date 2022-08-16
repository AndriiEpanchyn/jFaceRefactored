package jfacerefactored.actionsMethods.menuHelpActions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import jfacerefactored.ui.MyAppWindow;

public class AboutAction extends Action {
    MyAppWindow _window;

    public AboutAction(MyAppWindow window) {
	_window = window;
	setText("About program \tCtrl+F10");
	setToolTipText("About program");
    }

    public void run() {
	String helpString = "This is a simple Jface application intended to store information about the interns which have been passed this task. \n"
		+ "Application is made by _Alien_ \nVersion 1.00. \nDistributed on general GNU license or some similar way  ;-)";
	MessageBox aboutMessageBox = new MessageBox(_window.getShell(), SWT.OK);
	aboutMessageBox.setMessage(helpString);
	aboutMessageBox.setText("About program");
	aboutMessageBox.open();
    }
}
