package jfacerefactored.model;

import java.util.ArrayList;

public class Session {
	public ArrayList<Entity> unsavedRecords;

	public String name;
	public String group;
	public boolean swtDone;
	public Entity activeRecord;
	public String fileName;
	public boolean isNewFile;

	public Session() {
		this.unsavedRecords = new ArrayList<>();
		this.name = "";
		this.group = "";
		this.swtDone = false;
		this.activeRecord = null;
		this.isNewFile = true;
	}

	public void addEntity(String tmpName, String tmpGroup, boolean swtDone) {
		this.unsavedRecords.add(new Entity(tmpName, tmpGroup, swtDone));
	}

	public void addEntity(Entity e) {
		this.unsavedRecords.add(e);
	}

	public ArrayList<Entity> getAllRecords() {
		return unsavedRecords;
	}

// Others
	public void clear() {
		this.unsavedRecords.clear();
		this.name = "";
		this.group = "";
		this.swtDone = false;
		this.activeRecord = null;
		this.fileName = "";
		this.isNewFile = true;
	}

	public void removeCurrentObject() {
		if (activeRecord != null && unsavedRecords.size() > 0) {
			unsavedRecords.remove(activeRecord);
			activeRecord = null;
			name = "";
			group = "";
			swtDone = false;
		}
	}

	@Override
	public String toString() {
		StringBuilder answer = new StringBuilder();
		for (Entity s : unsavedRecords) {
			answer.append(
					"(Name: " + s.getName() + ", group: " + s.getGroup() + ", SWT Done: " + s.getSwtDone() + ")\n");
		}
		return answer.toString();
	}

	public void saveFieldsToCurrentRecord() {
		activeRecord.setName(name);
		activeRecord.setGroup(group);
		activeRecord.setSwtDone(swtDone);
	}

	public void saveFieldsToNewRecord() {
		addEntity(name, group, swtDone);
	}

	public Session createDummyRecords() {
		this.addEntity("first user", "1", true);
		this.addEntity("second user", "1", true);
		this.addEntity("third user", "1", true);
		this.addEntity("fourth user", "1", true);
		this.addEntity("fifth user", "1", false);
//		this.addEntity("sixth user", "2", true);
//		this.addEntity("seventh user", "2", true);
//		this.addEntity("eigth user", "2", true);
//		this.addEntity("ninth user", "2", true);
//		this.addEntity("tenth user", "3", false);
//		this.addEntity("eleventh user", "3", false);
		return this;
	}
}
