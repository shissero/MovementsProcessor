package com.example.vamojossa.utils;

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

    public static List<String> openFile(String path) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(path));

        List<String> aux = reader.lines().collect(Collectors.toList());

        reader.close();

        return aux;
    }

    // Returns null if any error occurs
    public static List<String> getFilesDir(String path) throws IOException {

        try (Stream<Path> stream = Files.list(Paths.get(path))) {

            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(p -> path + "/" + p.getFileName().toString())
                    .collect(Collectors.toList());
        }
    }
}
