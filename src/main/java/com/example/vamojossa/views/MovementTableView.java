package com.example.vamojossa.views;

import com.example.vamojossa.presenters.TableDataPresenter;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.List;

import static com.example.vamojossa.presenters.TableDataPresenter.*;

public class MovementTableView implements TableDataDisplayer {

        @FXML
        private GridPane view_parent;

        @FXML
        private TableView<TableDataAdapter> tableView;
/*
        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, String> colDescription;

        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, Float> colAmount;

        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, LocalDateTime> colDate;

        private static TableDataPresenter presenter;
*/
        @FXML
        public void initialize(){

                /*colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

                colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

                colDate.setCellValueFactory(new PropertyValueFactory<>("date_info") {


                });*/


        }

        @Override
        public void setData(ObservableList<TableDataAdapter> data) {

                tableView.setItems(data);
        }

        @Override
        public void addColumns(List<String> headers) {

                for(String header : headers) {


                        TableColumn<TableDataAdapter, String> column = new TableColumn<>(header);

                        column.setCellValueFactory(

                                new Callback<TableColumn.CellDataFeatures<TableDataAdapter, String>, ObservableValue<String>>() {


                                        @Override
                                        public ObservableValue<String> call(TableColumn.CellDataFeatures<TableDataAdapter, String> p) {

                                                return new SimpleStringProperty(p.getValue().asRow()[headers.indexOf(header)]);
                                        }
                                }
                        );

                        tableView.getColumns().add(column);
                }
        }

        public GridPane getView_parent() {
                return view_parent;
        }
}
