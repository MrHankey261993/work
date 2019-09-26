package tacho.model;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Driver {
	private StringProperty name;
	private ObservableList<String> intervals  = FXCollections.observableArrayList();
	
	

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}
	
	public StringProperty getNameProperty() {
		return name;
	}
	public void setNameProperty(StringProperty name) {
		this.name = name;
	}
	

	public ObservableList<String> getIntervals() {
		return intervals;
	}

	public void setIntervals(ObservableList<String> intervals) {
		this.intervals = intervals;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name.get());
		builder.append(" ");
		builder.append(intervals);
		return builder.toString();
	}
}
