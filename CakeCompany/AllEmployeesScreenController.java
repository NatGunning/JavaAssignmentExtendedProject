package CakeCompany;


import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;



public class AllEmployeesScreenController {
    private final Stage thisStage;
    private Team team;

    @FXML
    private TableView<Employee> tblEmployees;
    @FXML
    Label lblTotalCakesCovered, lblTotalWages;

    public AllEmployeesScreenController() throws SQLException {
        thisStage = new Stage();
        this.team = new Team();

        //Load the FXML file into the loader
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AllEmployeesScreen.fxml"));
            loader.setController(this);
            thisStage.setScene(new Scene(loader.load()));
            thisStage.setTitle("All Employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }

    @FXML
    private void initialize() {

        TableColumn<Employee, String> colName = new TableColumn<>("Name");
        colName.setMinWidth(200);
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employee, Double> colCakes = new TableColumn<>("Cakes Covered");
        colCakes.setMinWidth(200);
        colCakes.setCellValueFactory(new PropertyValueFactory<>("cakes"));

        TableColumn<Employee, String> colWages = new TableColumn<>("Wages");
        colWages.setMinWidth(100);

        colWages.setCellValueFactory(cellData -> {
            Employee employee = cellData.getValue();
            return new SimpleStringProperty(employee.formatWages(employee.getWages()));
        });

        TableColumn<Employee, String> colAddCakes = new TableColumn<>("+ Cakes");
        colAddCakes.setMinWidth(100);
        colAddCakes.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Employee, String> colMinusCakes = new TableColumn<>("- Cakes");
        colMinusCakes.setMinWidth(100);
        colMinusCakes.setCellFactory(TextFieldTableCell.forTableColumn());

        this.tblEmployees.setEditable(true);
        this.tblEmployees.setItems(team.getTeamAsOAL());
        this.tblEmployees.getColumns().addAll(colName, colCakes, colWages, colAddCakes, colMinusCakes);

        this.lblTotalCakesCovered.setText(String.valueOf(team.getTotalCakes()));
        this.lblTotalWages.setText("£"+String.valueOf(team.getTotalWages()));
    }
}

