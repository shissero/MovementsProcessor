package com.example.vamojossa.views;

import com.example.vamojossa.presenters.TableDataPresenter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

import java.time.LocalDateTime;

public class MovementTableView implements TableDataPresenter.TableDataDisplayer {

        @FXML
        private GridPane view_parent;

        @FXML
        private TableView<TableDataPresenter.TableDataAdapter> tableView;

        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, String> colDescription;

        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, Float> colAmount;

        @FXML
        private TableColumn<TableDataPresenter.TableDataAdapter, LocalDateTime> colDate;

        private static TableDataPresenter presenter;

        @FXML
        public void initialize(){

                colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

                colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

                colDate.setCellValueFactory(new PropertyValueFactory<>("date_info") {


                });
        }

        @Override
        public void setData(ObservableList<TableDataPresenter.TableDataAdapter> data) {

                tableView.setItems(data);
        }

        public GridPane getView_parent() {
                return view_parent;
        }
}
