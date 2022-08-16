package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import jfacerefactored.actionsMethods.ActionMethods;

public class SelectionEventCancelActionListener implements SelectionListener{

	@Override
	public void widgetSelected(SelectionEvent e) {
		ActionMethods.cancelAction();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		
	}

}
