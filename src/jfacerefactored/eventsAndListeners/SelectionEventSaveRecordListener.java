package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import jfacerefactored.actionsMethods.ActionMethods;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;

public class SelectionEventSaveRecordListener implements SelectionListener{

	@Override
	public void widgetSelected(SelectionEvent e) {
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		ActionMethods.saveOrAddRecord(()->session.saveFieldsToCurrentRecord());
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {		
	}

}
