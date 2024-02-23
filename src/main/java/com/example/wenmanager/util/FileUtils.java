package com.example.wenmanager.util;

public class FileUtils {

    public static String getFileSuffix(String fileName){
        String fileExtension = "";
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex > 0) {
            fileExtension = fileName.substring(lastIndex);
        }
        return fileExtension;
    }

}
