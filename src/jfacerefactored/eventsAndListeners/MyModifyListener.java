package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;

public class MyModifyListener implements ModifyListener, Listener {

	@Override
	public void modifyText(ModifyEvent e) {
		modifyMethod();
	}

	@Override
	public void handleEvent(Event event) {
		modifyMethod();
	}

	private void modifyMethod() {
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		String name = appInstance.getFormComposite().getName();
		String group = appInstance.getFormComposite().getGroup();
		if (session.activeRecord != null || session.unsavedRecords.size() == 0) {
			if (name.length() > 0 && group.length() > 0) {
				appInstance.changeMenuAndButtonsStatus(true, true, true);
			} else if (name.length() == 0 || group.length() == 0) {
				appInstance.changeMenuAndButtonsStatus(false, false, false);
			}
		}
	}

}
