package org.example.database2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs;
        // Подключение к БД
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "Пользователь", "1234");
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM postgres.\"Metro\".\"Типы_проездных\"");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        ObservableList<FareTypes> fareTypesList = FXCollections.observableArrayList();
        FareTypes fareTypes2;
        // И если что то было получено, то цикл while сработает
        while (rs.next()) {
            fareTypes2 = new FareTypes();
            fareTypes2 = new FareTypes();
            fareTypes2.setNumber_of_journeys(rs.getString("Количество_поездок"));
            fareTypes2.setCost(rs.getString("Стоимость"));
            fareTypes2.setName(rs.getString("Название"));
            fareTypes2.setRequirements(rs.getString("Требования"));
            fareTypesList.add(fareTypes2);
        }
        // определяем таблицу и устанавливаем данные
        TableView<FareTypes> table = new TableView<FareTypes>(fareTypesList);
        table.setPrefWidth(750);
        table.setPrefHeight(300);
        // столбец для вывода имени
        TableColumn<FareTypes, String> nameColumn = new TableColumn<FareTypes, String>("Название");
        // определяем фабрику для столбца с привязкой к свойству Name
        nameColumn.setCellValueFactory(new PropertyValueFactory<FareTypes, String>("Name"));
        // добавляем столбец
        table.getColumns().add(nameColumn);
        // столбец для вывода стоимости
        TableColumn<FareTypes, String> costColumn = new TableColumn<FareTypes, String>("Стоимость");
        // определяем фабрику для столбца с привязкой к свойству Cost
        costColumn.setCellValueFactory(new PropertyValueFactory<FareTypes, String>("Cost"));
        // добавляем столбец
        table.getColumns().add(costColumn);
        // столбец для вывода Количества поездок
        TableColumn<FareTypes, String> countColumn = new TableColumn<FareTypes, String>("Количество поездок");
        // определяем фабрику для столбца с привязкой к свойству number_of_journeys
        countColumn.setCellValueFactory(new PropertyValueFactory<FareTypes, String>("number_of_journeys"));
        // добавляем столбец
        table.getColumns().add(countColumn);
        // столбец для вывода Требований
        TableColumn<FareTypes, String> requirementsColumn = new TableColumn<FareTypes, String>("Требования");
        // определяем фабрику для столбца с привязкой к свойству number_of_journeys
        requirementsColumn.setCellValueFactory(new PropertyValueFactory<FareTypes, String>("requirements"));
        // добавляем столбец
        table.getColumns().add(requirementsColumn);
        FlowPane root = new FlowPane(10, 10, table);
        Scene scene = new Scene(root, 750, 350);
        stage.setScene(scene);
        stage.setTitle("Metro");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}