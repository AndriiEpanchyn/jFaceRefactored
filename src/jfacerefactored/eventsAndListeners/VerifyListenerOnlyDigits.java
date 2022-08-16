package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class VerifyListenerOnlyDigits implements VerifyListener{

	@Override
	public void verifyText(VerifyEvent e) {
		String string = e.text;
		e.doit = (string.matches("\\d*"));
	}

}
