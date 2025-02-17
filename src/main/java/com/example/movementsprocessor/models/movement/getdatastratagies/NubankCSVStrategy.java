package com.example.movementsprocessor.models.movement.getdatastratagies;

import com.example.movementsprocessor.models.movement.MovementBuilder;
import com.example.movementsprocessor.utils.FileHandling;
import com.example.movementsprocessor.utils.LoggerManager;
import com.example.movementsprocessor.utils.RegexUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NubankCSVStrategy extends GetFromFileStrategy{

        private static final String separator = ",";

        public NubankCSVStrategy(){}

        @Override
        protected ObservableList<MovementBuilder> getFromFile(String path) {

                ObservableList<MovementBuilder> all_movements = FXCollections.observableArrayList();

                try {
                        List<String> all_lines = FileHandling.openFile(path);

                        // As per Nov 13 th, 2024, NubankMovement CSV was:
                        // field separator:","
                        // 1 st line -table headers(Data, Valor, Identificador, Descrição)
                        // 2 nd to last lines -movement information(one movement per line)

                        for(String line : all_lines) {

                                if(validateNubankCSVLine(line)){

                                        MovementBuilder movementBuilder = new MovementBuilder();

                                        String[] entries = line.split(separator);


                                        // Nubank CSV movements dates are already in the standard format
                                        movementBuilder.addDateInfo(entries[NubankCSVColumns.DATE]);

                                        movementBuilder.addAmountInfo(Float.parseFloat(entries[NubankCSVColumns.AMOUNT]));

                                        movementBuilder.addDescription(entries[NubankCSVColumns.DESCRIPTION]);

                                        all_movements.add(movementBuilder);
                                }
                        }
                } catch (IOException e) {

                        LoggerManager.error(e.getMessage());
                }

                return all_movements;
        }

        public static boolean validateNubankCSVLine(String str){

                Pattern p = Pattern.compile(String.join(",", RegexUtils.date_pattern_str, RegexUtils.float_pattern_str, "[a-z0-9-]*", ".*"));

                Matcher m = p.matcher(str);

                return m.matches();
        }

        private static class NubankCSVColumns {

                public static final int DATE = 0;
                public static final int AMOUNT = 1;
                public static final int DESCRIPTION = 3;
        }
}
