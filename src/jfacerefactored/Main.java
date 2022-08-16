package jfacerefactored;

import org.eclipse.swt.widgets.Display;

import jfacerefactored.ui.MyAppWindow;

public class Main {
    public static void main(String[] args) {
	MyAppWindow win = MyAppWindow.getInstance();
	win.setBlockOnOpen(true);
	win.open();
	Display.getCurrent().dispose();
    }
}
