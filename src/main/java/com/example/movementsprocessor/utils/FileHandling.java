package com.example.movementsprocessor.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandling {

    /**
     *
     * @param path:
     * @return list of absolute paths for all files in the directory specified by @path
     * @throws IOException
     */
    public static List<String> getFilesDir(String path) throws IOException {


        // Using Files.list() is better for handling large directories
        try (Stream<Path> stream = Files.list(Paths.get(path))) {

            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(p -> path + "/" + p.getFileName().toString())
                    .collect(Collectors.toList());
        }
    }

    public static boolean isDirectory(String path) {

        return Files.isDirectory(Paths.get(path));
    }

    public static List<String> openFile(String path) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(path));

        List<String> aux = reader.lines().collect(Collectors.toList());

        reader.close();

        return aux;
    }
}
