package tacho.work;

import java.io.IOException;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tacho.model.Driver;
import tacho.util.ReadFile;
import tacho.view.AddDateController;
import tacho.view.CreateDriverController;
import tacho.view.MainController;

/**
 * Hello world!
 *
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Driver> drivers = ReadFile.getListDriver();

	public static void main(String[] args) throws IOException {
		launch(args);
		

	}

	@Override
	public void start(Stage stage) throws Exception {
		this.primaryStage = stage;
		initRootLayout();
		showMain();
	}

	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/tacho/view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public void showMain() {

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/tacho/view/Main.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(personOverview);
			
			MainController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public boolean showCreateDriverDialog(Driver driver) {
	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/tacho/view/CreateDriver.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Add Driver");
		dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        CreateDriverController controller = loader.getController();
        System.out.println(controller);
        controller.setDialogStage(dialogStage);
        controller.setDriver(driver);
        
        dialogStage.showAndWait();
        
		return controller.isOkClicked();
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}
	
	public boolean showAddDate() {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("/tacho/view/AddDate.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Add Driver");
		dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        AddDateController controller = loader.getController();
        dialogStage.showAndWait();
        
        return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public ObservableList<Driver> getDrivers() {
		return drivers;
	}

	
	
	

}
