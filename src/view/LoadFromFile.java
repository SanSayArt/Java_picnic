package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadFromFile {
    List<String> fruits;

    public LoadFromFile(String fileName) {
        try (FileReader file = new FileReader(fileName)){
            fruits = new ArrayList<>();
            BufferedReader reader = new BufferedReader(file);
            String line;
            while ((line = reader.readLine()) != null){
                fruits.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public List<String> getRawFruits(){
        return fruits;
    }
}
