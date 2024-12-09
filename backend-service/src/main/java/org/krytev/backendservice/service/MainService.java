package org.krytev.backendservice.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@Service
public class MainService {

    public void writeData(String data) throws IOException {
        FileWriter writer = new FileWriter("data/data.txt");
        writer.write(data);
        writer.flush();
    }

    public String readData() throws IOException{
        Scanner scanner = new Scanner(new File("data/data.txt"));
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()){
            result.append(scanner.nextLine() + "\n");
        }
        return result.toString();
    }

}
