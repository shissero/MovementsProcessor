package com.example.vamojossa.presenters;

import javafx.collections.ObservableList;

import java.util.List;

public class TableDataPresenter {

        private final ObservableList<TableDataAdapter> model;

        private final TableDataDisplayer view;


        public TableDataPresenter(ObservableList<? extends TableDataAdapter> data, TableDataDisplayer displayer){

                model = (ObservableList<TableDataAdapter>) data;

                this.view = displayer;

                view.addColumns(model.get(0).getTableHeaders());

                this.view.setData(model);
        }




        /**
         * This interface is the contract of a model with this presenter
         *
         * The model must have a static final
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
                void addColumns(List<String> headers);
        }
}

