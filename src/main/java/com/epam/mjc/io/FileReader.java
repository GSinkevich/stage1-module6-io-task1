package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try(FileInputStream fileInputStream = new FileInputStream(file.getPath())) {
            int ch;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = fileInputStream.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            String line = stringBuilder.toString();
            String[] keyValuePair = line.split("[\r\n: ]");

            profile.setName(keyValuePair[2]);
            profile.setAge(Integer.parseInt(keyValuePair[6]));
            profile.setEmail(keyValuePair[10]);
            profile.setPhone(Long.parseLong(keyValuePair[14]));

        } catch (NumberFormatException ex) {
            throw new NumberFormatException(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return  profile;
    }
}
