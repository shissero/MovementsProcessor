package com.example.vamojossa.presenters;

import javafx.collections.ObservableList;

import java.util.List;

public class TableDataPresenter {

        private final ObservableList<TableDataAdapter> model;

        private final TableDataDisplayer view;


        public TableDataPresenter(ObservableList<TableDataAdapter> data, TableDataDisplayer displayer){

                model = data;

                this.view = displayer;

                this.view.setData(model);
        }

        /**
         * This interface is the contract of a model with this presenter
         */
        public interface TableDataAdapter {

                String[] asRow();

                List<String> getTableHeaders();
        }


        /**
         * This interface is the contract of a tableview with this presenter
         */
        public interface TableDataDisplayer {

                void setData(ObservableList<TableDataAdapter> data);
        }
}

