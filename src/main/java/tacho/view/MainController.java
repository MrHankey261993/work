package tacho.view;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.text.TabableView;

import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tacho.model.Driver;
import tacho.util.ReadFile;
import tacho.work.MainApp;

public class MainController {
	@FXML
	private TableView<Driver> tableDriver;
	@FXML
	private TableColumn<Driver, String> nameColumn;
	@FXML
	private Label nameLabel; 
	@FXML
	private TableView<String> tableDate;
	@FXML
	private TableColumn<Driver, String> intervalColumn;

	
	
	
	private MainApp mainApp;

	public MainController() {

	}

	@FXML
	public void initialize() {
		
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		showDriverName(null);
	//	intervalColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		tableDriver.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) ->showDriverName(newValue)
				);
		tableDriver.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) ->showDriverDetails(newValue)
				);
		intervalColumn.setCellValueFactory(new PropertyValueFactory<Driver, String>("intervalColumn"));
		
	}

	public void setMainApp(MainApp mainApp) throws IOException {
		this.mainApp = mainApp;
		tableDriver.setItems(mainApp.getDrivers());
	}

	public void showDriverDetails(Driver driver) {
		tableDate.setItems(tableDriver.getSelectionModel().getSelectedItem().getIntervals());
		System.out.println(tableDate.getItems());
		
		
		
	}
	
	public void showDriverName(Driver driver) {
		if(driver != null) {
			nameLabel.setText(driver.getName());
		} else {
			nameLabel.setText("Выбирите водителя");
		}
	}

	@FXML
	private void handleNewDriver() throws IOException {
		Driver tempPerson = new Driver();
		boolean okClicked = mainApp.showCreateDriverDialog(tempPerson);
		if (okClicked) {

		}
	}

	@FXML
	private void handleNewDate() {
	//	Driver driver = listDriver.getSelectionModel().getSelectedItem();
		boolean okClicked = mainApp.showAddDate();
		
	}
	
	

	

	
}
