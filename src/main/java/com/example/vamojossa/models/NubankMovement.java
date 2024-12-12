package com.example.vamojossa.models;

import com.example.vamojossa.utils.FileHandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NubankMovement {

    private NubankMovement(){}

    // TODO: Shouldn't be responsibility of this class to get data
    public static ArrayList<Movement> fromCSV() {

        String csv_path = "src/main/resources/com/example/vamojossa/test_ignore";

        ArrayList<Movement> all_movements = new ArrayList<>();

        // We get the file names in the Nubank CSV directory
        // Using Files.list() is better for handling large directories
            List<String> all_files;
            try {
                    all_files = FileHandling.getFilesDir(csv_path);
            } catch (IOException e) {
                    throw new RuntimeException(e);
            }

            if(all_files != null) {

            for (String f : all_files) {
                
                    try {

                        List<String> all_lines = FileHandling.openFile(f);

                        // As per Nov 13 th, 2024, NubankMovement CSV was:
                        // field separator:","
                        // 1 st line -table headers(Data, Valor, Identificador, Descrição)
                        // 2 nd to last lines -movement information(one movement per line)

                        for(String line : all_lines) {

                            if(Movement.validateNubankCSVLine(line)) all_movements.add(Movement.fromNubankCSV(line));
                        }
                    } catch (IOException e) {
                            throw new RuntimeException(e);
                    }
            }
        }

        return all_movements;
    }
}
