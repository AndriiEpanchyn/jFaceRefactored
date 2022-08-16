package jfacerefactored.eventsAndListeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

public class VerifyListenerTwoWordsWithSpaceBeetween implements VerifyListener {

	@Override
	public void verifyText(VerifyEvent e) {
		String currentChar = e.text;
		String text = ((Text) e.widget).getText() + currentChar;
		e.doit = (text.matches("[a-zA-Zà-ÿÀ-ß³²¿¯ºª']+[ ]{0,1}[a-zA-Zà-ÿÀ-ß³²¿¯ºª']*") && text.length() > 0);
	}

}
