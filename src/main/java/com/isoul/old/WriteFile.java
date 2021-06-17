package com.isoul.old;

import java.io.FileWriter;

public class WriteFile {
    public static void main(String[] args) throws Exception {
        String fileName = "D:\\Hello.txt";
        FileWriter writer = new FileWriter(fileName);
        writer.write("Hello!\n");
        writer.write("This is my first text file,\n");
        writer.write("You can see how this is done.\n");
        writer.write("输入一段中文！\n");
        writer.close();
    }
}
