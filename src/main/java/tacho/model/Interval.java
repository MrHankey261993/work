package tacho.model;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class Interval {
	@FXML
	private StringProperty start;
	
	public String getStart() {
		return start.get();
	}
	public void setStart(String start) {
		this.start.set(start);
	}
	
	
	public StringProperty start() {
		return start;
	}
}
