package com.isoul.old;

import java.io.*;

public class FileRead {
    public static void main(String[] args) throws Exception {
        File f = new File("D:/test.txt");
        InputStream is = null;
        OutputStream os = null;
        os = new FileOutputStream(f);
        is = new FileInputStream(f);
        byte[] data = new byte[1024];
        is.read(data);
        data[0] = 0b01111111;
        System.out.println();
        os.write(data);
        data[0]--;
        System.out.println("文件内容：" + new String(data));
        is.close();
        os.close();
    }
}
