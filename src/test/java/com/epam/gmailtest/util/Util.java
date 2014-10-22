package com.epam.gmailtest.util;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Kanstantsin_Makarau on 10/9/2014.
 */
public class Util {
    static Logger logger = Logger.getLogger(Util.class);
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();

    public static String getRandomString(int len)
    {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
        {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static String getFile(int fileSize){

        FileWriter fileWriter = null;
        File file = null;
        try {
            file = new File("file.txt");
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            while (file.length() < fileSize){
                bufferedWriter.write("01234567890123456789");
            }
            logger.info("File was created with size = " + file.length());
        } catch (IOException e) {
            logger.error("File exception!!!");
        }
        return file.getAbsolutePath();
    }
}
