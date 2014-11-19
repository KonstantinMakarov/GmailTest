package com.epam.gmailtest.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static String getFile(long fileSize){

        File file = null;
        RandomAccessFile randomAccessFile = null;
        try {
            file = new File("file.txt");
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.setLength(fileSize);
            logger.info("File was created with size = " + file.length());
        } catch (IOException e) {
            logger.error("File exception!!!");
        }
        finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                logger.error("File exception!!!");
            }
        }
        return file.getAbsolutePath();
    }

    public static void deleteFile(String filePath) {
        File file = null;
        try{
            file = new File(filePath);
            if(file.delete()){
                logger.info("File was deleted");
            }
        }
        catch(Exception e){
            logger.info("deletion is failed");
        }
    }

    public static String hexColorCode(String styleAttribute) {
        String backgroundColor = styleAttribute.split(";")[0];
        StringBuilder hexColor = new StringBuilder("#");
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(backgroundColor);
        while(matcher.find()){
            int a = Integer.parseInt(matcher.group());
            hexColor.append(Integer.toHexString(a));
        }
        return hexColor.toString();
    }
}
