package jfacerefactored.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import jfacerefactored.eventsAndListeners.MyModifyListener;
import jfacerefactored.eventsAndListeners.VerifyListenerOnlyDigits;
import jfacerefactored.eventsAndListeners.VerifyListenerTwoWordsWithSpaceBeetween;

public class ElementsBuilder {	
	public static Label createCommonLabel(String labelName, Composite parent) {
		Label newLabel = new Label(parent, SWT.NONE);
		newLabel.setText(labelName);
		newLabel.setLayoutData(GridDataBuilder.createGridWithCammonProperties());
		return newLabel;
	}
	
	public static Button createButton(Composite parent, String text, GridData buttonGridData) {
		Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(buttonGridData);
		button.setText(text);
		button.setEnabled(false);		   
		return button;
	}
	
	public static Text createText(Composite parent, boolean isTextField) {
		Text newText = new Text(parent, SWT.BORDER);
		newText.setLayoutData(GridDataBuilder.createGridForText());
		newText.addModifyListener(new MyModifyListener());
		if(isTextField) {
			newText.addVerifyListener(new VerifyListenerTwoWordsWithSpaceBeetween());
		} else {
			newText.addVerifyListener(new VerifyListenerOnlyDigits());
		}		
		return newText;
	}
}
