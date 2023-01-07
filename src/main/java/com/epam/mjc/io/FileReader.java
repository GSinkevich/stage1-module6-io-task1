package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    public Profile getDataFromFile(File file) {

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
            int Age = Integer.parseInt(keyValuePair[1]);
            long Phone = Long.parseLong(keyValuePair[3]);

            var profile = new Profile(keyValuePair[0],Age,keyValuePair[2],Phone);
            return profile;

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }

        return null;
    }
}

