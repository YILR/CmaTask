package com.example.cmatask.filework;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file = new File(args[1]);
        getFileTree(args[0]).forEach(x -> {
            try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(x)));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file, true))) {
                byte[] buffer = new byte[1024];
                int lengthRead;
                while ((lengthRead = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, lengthRead);
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }


    public static List<String> getFileTree(String root)  {

        List<String> result = new ArrayList<>();
        try {
            Files.walk(Paths.get(root))
                    .filter(Files::isRegularFile)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(x -> result.add(x.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(result);
        return result;
    }


}
