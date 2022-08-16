package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import jfacerefactored.actionsMethods.ActionMethods;

public class SelectionEventDeleteRecordListener implements SelectionListener {

	@Override
	public void widgetSelected(SelectionEvent e) {
		ActionMethods.deleteRecordAction();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
