package jfacerefactored.ui;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

import jfacerefactored.model.Session;

public class WindowConfigurer {
	public static void start(Shell shell) {
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		int xSize = 865;
		int ySize = 270;
		Rectangle sizes = shell.getBounds();
		int x = sizes.width;
		int y = sizes.height;
		Rectangle mSize = new Rectangle((x - xSize) / 2, (y - ySize) / 2, xSize, ySize);
		shell.setBounds(mSize);
		shell.setMinimumSize(xSize, ySize);
		shell.setMaximumSize(xSize + 400, ySize + 400);
		shell.setText("JFace application:" + session.fileName);
	}
}
