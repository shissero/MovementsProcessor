package com.example.vamojossa.models.movement.getdatastratagies;

import com.example.vamojossa.models.movement.MovementBuilder;
import com.example.vamojossa.utils.FileHandling;
import com.example.vamojossa.utils.LoggerManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

/**
 * This class provides an abstraction for getting data from files
 * It implements the Strategy pattern
 * It wasn't implemented as an interface because I wanted
 * a standard implementation for all subclasses but also
 * specific implementations for each one
 */
public abstract class GetFromFileStrategy {

        protected GetFromFileStrategy() {}


        /**
         *
         * This method tests if {@code path} corresponds to a directory or a file
         * and then pass the job to the appropriate function ({@code getDirectory} or {@code getFromFile})
         *
         * @param path: path to search for files with movement data
         * @return an observable list of MovementBuilder objects containing read data
         */
        public ObservableList<MovementBuilder> getMovements(String path){

                if(FileHandling.isDirectory(path)){

                        return this.getFromDirectory(path);
                }
                else return this.getFromFile(path);
        }

        /**
         *
         *
         * @param path: directory to search for files with movement data
         * @return observable list of MovementBuilder objects containing read data
         */
        protected ObservableList<MovementBuilder> getFromDirectory(String path){

                ObservableList<MovementBuilder> all_movements = FXCollections.observableArrayList();

                // We get the file names in the specified directory
                try {
                        List<String> all_files = FileHandling.getFilesDir(path);

                        for (String f : all_files) {

                                all_movements.addAll(this.getFromFile(f));

                        }
                } catch (IOException e) {

                        LoggerManager.error(e.getMessage());
                }

                return all_movements;
        }

        protected abstract ObservableList<MovementBuilder> getFromFile(String path);
}
