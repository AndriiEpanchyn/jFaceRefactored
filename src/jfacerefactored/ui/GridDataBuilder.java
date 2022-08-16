package jfacerefactored.ui;

import org.eclipse.swt.layout.GridData;

public class GridDataBuilder {
	
	public static GridData createGridForText() {
		GridData gridForText = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
		gridForText.grabExcessHorizontalSpace = true; 
		gridForText.horizontalSpan = 3;
		gridForText.widthHint = 120;
		gridForText.heightHint = 30; 
		return gridForText;
	}
	
	public static GridData createGridForButtonNew() {
		GridData gridForButtonNew = createGridWithCammonProperties();
		gridForButtonNew.horizontalIndent = 20;
		return gridForButtonNew;
	}
	
	public static GridData createGridWithCammonProperties() {
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL);  
		gridData.grabExcessHorizontalSpace = true; 
		gridData.horizontalSpan = 1; 
		gridData.widthHint = 60; 
		gridData.heightHint = 30;
		return gridData;
	}
}
