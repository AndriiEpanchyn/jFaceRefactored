package jfacerefactored.actionsMethods;

import jfacerefactored.model.Entity;
import jfacerefactored.model.Session;
import jfacerefactored.ui.MyAppWindow;

public class ActionMethods {

	public static void cancelAction() {
		MyAppWindow.getInstance().clearFields();
	}
	
	public static void saveOrAddRecord(Runnable run) {
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		ifNewTableStarted();
		if (session.activeRecord == null) {
			return;
		}
		appInstance.getFormComposite().saveFieldsToSession();

		boolean isFieldsChanged = setFieldsIsChangedParameter(session);
		if (isFieldsChanged) {
			run.run();
		}
		appInstance.redrawAll();
		appInstance.getTableComposite().deselectAll();
		appInstance.clearFields();
		appInstance.changeMenuAndButtonsStatus(false, false, false);
	}

	public static void deleteRecordAction(){
		MyAppWindow appInstance = MyAppWindow.getInstance();
		Session session = appInstance.getSession();
		session.removeCurrentObject();
		appInstance.getFormComposite().getFormFieldsFromSession();
		appInstance.redrawAll();
		appInstance.changeMenuAndButtonsStatus(false, false, false);		
	}
	
	private static void ifNewTableStarted() {
		MyAppWindow window = MyAppWindow.getInstance();
		Session session = window.getSession();

		if (session.unsavedRecords.size() == 0) {
			Entity newEntity = new Entity(window.getFormComposite().getName(), window.getFormComposite().getGroup(),
					window.getFormComposite().isSWTDone());
			session.addEntity(newEntity);
			session.activeRecord = session.unsavedRecords.get(0);
			newEntity = null;
		}
	}

	private static boolean setFieldsIsChangedParameter(Session session) {
		boolean fieldsEqual = (session.activeRecord.getName().equals(session.name)
				&& session.activeRecord.getGroup().equals(session.group)
				&& session.activeRecord.getSwtDone() == session.swtDone);
		return !fieldsEqual;
	}
	
}