package controller;

import application.MainFXApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class patientViewController {

	Stage stage;
	Scene scene;
	Parent root;
	// always reference main method, and build constructor
	private MainFXApp main;

	public void setMain(MainFXApp mainIn) {
		main = mainIn;
	}

	@FXML
	private Button addButton;
	@FXML
	private Button updateButton;
	@FXML
	private Button historyButton;
	@FXML
	private Button searchPatientButton;
	//Button added to fxml by TigerWooos
	@FXML
	private Button patientListButton;


	@FXML
	void ClickButton(ActionEvent event) throws Exception {
		try {
			// finds what stage the button is in
			stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
			// this gets the name of button
			String temp = ((Node) event.getSource()).getId().toString();
			// debugging
			System.out.println("(Node) event.getSource()).getId().toString() = " + temp);
			// this will allow for all buttons to go through one method, loading
			// the
			// right fxml file

			switch (temp) {
			case "addButton":
				root = FXMLLoader.load(getClass().getResource("/view/AddPatient.fxml"));
				AddPatientController con1 = new AddPatientController();
				con1.setMain(main);
				break;
			case "updateButton":
				root = FXMLLoader.load(getClass().getResource("/view/UpdatePatient.fxml"));
				UpdatePatientController con2 = new UpdatePatientController();
				con2.setMain(main);
				break;
			case "historyButton":
				root = FXMLLoader.load(getClass().getResource("/view/InformationHistory.fxml"));
				InformationHistoryController con3 = new InformationHistoryController();
				con3.setMain(main);
				break;
			case "searchPatientButton":
				//Currently searches as if the person using is a doctor.
				//Add code here to call search for a receptionist or search for a doc based on
				//who is logged in
				SearchPatientController.searchPatientDoc(stage);
				break;
				//CKS button loads patient list created by TigerWoods
			case "patientListButton":
				root = FXMLLoader.load(getClass().getResource("/view/PatientListView.fxml"));
				InformationHistoryController con4 = new InformationHistoryController();
				con4.setMain(main);
				break;
			default:
				root = FXMLLoader.load(getClass().getResource("/view/mainView.fxml"));
				mainViewController con5 = new mainViewController();
				con5.setMain(main);
				break;
			}
			// sets fxml file as a scene
			scene = new Scene(root);
			// loads the scene on top of whatever stage the button is in
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
