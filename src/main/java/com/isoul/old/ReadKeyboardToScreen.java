package com.isoul.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadKeyboardToScreen {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = in.readLine()).length() != 0) {
            System.out.println(s);
        }
    }
}
