package jfacerefactored.ui;

import org.eclipse.jface.action.MenuManager;

import jfacerefactored.actionsMethods.menuEditActions.CancelAction;
import jfacerefactored.actionsMethods.menuFileActions.ExitAction;
import jfacerefactored.actionsMethods.menuFileActions.NewFileAction;
import jfacerefactored.actionsMethods.menuFileActions.OpenFileAction;
import jfacerefactored.actionsMethods.menuFileActions.SaveAsFileAction;
import jfacerefactored.actionsMethods.menuFileActions.SaveFileAction;
import jfacerefactored.actionsMethods.menuHelpActions.AboutAction;
import jfacerefactored.actionsMethods.menuHelpActions.HelpAction;

public class MenuBuilder {
	public static MenuManager create(MyAppWindow parent) {
		MenuManager mainMenu = new MenuManager();
		MenuManager menuFile = new MenuManager("&File", "1");
		mainMenu.add(menuFile);
// File Menu
		menuFile.add(new NewFileAction(parent));
		menuFile.add(new OpenFileAction(parent));
		menuFile.add(new SaveAsFileAction(parent));
		menuFile.add(new SaveFileAction(parent));
		menuFile.add(new ExitAction(parent));

// Edit Menu
		MenuManager menuEdit = new MenuManager("&Edit", "2");
		mainMenu.add(menuEdit);
		menuEdit.add(parent.newRowAction);
		menuEdit.add(parent.newSaveRowAction);
		menuEdit.add(parent.newDeleteAction);
		menuEdit.add(new CancelAction(parent));
//Help Menu
		MenuManager menuHelp = new MenuManager("&About", "3");
		mainMenu.add(menuHelp);
		menuHelp.add(new HelpAction(parent));
		menuHelp.add(new AboutAction(parent));

		return mainMenu;
	}
}
