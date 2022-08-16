package jfacerefactored.actionsMethods.menuHelpActions;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import jfacerefactored.ui.MyAppWindow;

public class HelpAction extends Action {
	MyAppWindow _window;

	public HelpAction(MyAppWindow window) {
		_window = window;
		setText("Help \tF1");
		setToolTipText("Help");
	}

	public void run() {
		String helpString = "Are you really need help to take care about application which contains 4 buttons?";
		MessageBox helpMessageBox = new MessageBox(_window.getShell(), SWT.OK);
		helpMessageBox.setMessage(helpString);
		helpMessageBox.setText("Help dialog");
		helpMessageBox.open();
	}
}
