package tacho.view;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tacho.model.Driver;

public class AddDateController {

	@FXML
	private static Label nameDriverLabel;

	@FXML
	private static MainController controller;

	@FXML
	private TextField dateDriver;

	private boolean isOkClicked;

	@FXML
	public void initialize() {
		
	}

	@FXML
	public void handleOk() {
		
	}

	public static boolean showAddDate(Driver driver) {
		System.out.println(driver.getName());
		return true;
		
	}

	public boolean isOkClicked() {
		return isOkClicked;
	}
}
