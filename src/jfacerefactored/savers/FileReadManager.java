package jfacerefactored.savers;


import java.io.File;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import jfacerefactored.model.Entity;
import jfacerefactored.ui.MyAppWindow;

public class FileReadManager {
	ArrayList<Entity> recordsToLoadArrayList = new ArrayList<>();
	StringBuilder inputString = new StringBuilder();
	private static final String[] FILTER_NAMES = { "JSON Files (*.json)", "Plain text (*.txt)", "All Files (*.*)" };
	// These filter extensions are used to filter which files are displayed.
	private static final String[] FILTER_EXTS = { "*.json", "*.txt", "*.*" };

	private static MyAppWindow window;

	public static void execute(MyAppWindow _window) {
		window = _window;
		String tempFileName = chooseFile();
		if (tempFileName != null && !tempFileName.equals("")) {
			Savable fileData = selectSaver(tempFileName);
			_window.getSession().unsavedRecords = fileData.readFromFile(tempFileName);
			_window.getSession().fileName = tempFileName;
			_window.getSession().isNewFile = false;
		}
	}

	private static String chooseFile() {
		String fileName = "";
		FileDialog dlg = new FileDialog(window.getShell(), SWT.OPEN);
		dlg.setFilterNames(FILTER_NAMES);
		dlg.setFilterExtensions(FILTER_EXTS);
		fileName = dlg.open();
		if (fileName != null && !fileName.equals("")) {
			File inputFile = new File(fileName);
			if (!inputFile.exists() || !inputFile.canRead()) {
				fileName = "";
			}
		}
		return fileName;
	}

	private static Savable selectSaver(String filename) {
		// System.out.println("file" + filename);
		int start = filename.lastIndexOf(".");
		String extenstion = filename.substring(start + 1).toUpperCase();
		switch (extenstion) {
		case "JSON":
			return new JsonSaver();
		case "TXT":
			return new TxtSaver();
		default:
			System.out.println("Incorrect file type");
			return null;
		}
	}

}
