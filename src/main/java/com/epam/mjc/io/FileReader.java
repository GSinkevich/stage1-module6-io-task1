package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            int ch;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = fileInputStream.read()) != -1) {
                stringBuilder.append((char) ch);
            }

           String line = stringBuilder.toString();
           String[] keyValuePair = line.split("\r\n");

            for (int i = 0; i < keyValuePair.length; i++) {
                keyValuePair[i] = keyValuePair[i].replaceAll("\\s", "");
                String[] mas = keyValuePair[i].split(":", 2);
                if (mas.length >= 1) {
                    keyValuePair[i] = mas[1];
                }
            }
            int age = Integer.parseInt(keyValuePair[1]);
            long phone = Long.parseLong(keyValuePair[3]);

            profile = new Profile(keyValuePair[0],age,keyValuePair[2],phone);

        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
        return profile;
    }
}

