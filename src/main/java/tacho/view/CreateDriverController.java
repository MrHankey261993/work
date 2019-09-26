package tacho.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import tacho.model.Driver;
import tacho.util.ReadFile;


public class CreateDriverController {
@FXML
private TextField nameField;

private Stage dialogStage;
private Driver driver;
private boolean okClicked = false;


@FXML
private void initialize() {

}

public void setDialogStage(Stage dialogStage) {
	this.dialogStage = dialogStage;
}

public void setDriver(Driver driver) {
	this.driver = driver;

	nameField.setText(driver.getName());
	

}



public boolean isOkClicked() {
	return okClicked;
}

@FXML
private void handleOk() throws IOException {
	if(isInputValid()) {
		driver.setName(nameField.getText());
	//	okClicked = true;
		
		ReadFile.addDriver(nameField.getText());

		dialogStage.close();
		
	}
}

private boolean isInputValid() {
	String errorMessage = "";
	if(nameField.getText()==null || nameField.getText().length() == 0) {
		errorMessage += "Поле не может быть пустым";
	}
	if(errorMessage.length() == 0) {
		return true;
	} else {
		Alert alert = new Alert(AlertType.ERROR);
		alert.initOwner(dialogStage);
		alert.setTitle("Invalid Fields");
		alert.setHeaderText("Please correct invalid fields");
		alert.setContentText(errorMessage);

		alert.showAndWait();

		return false;
	}
}

}
