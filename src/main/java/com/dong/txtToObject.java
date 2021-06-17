package com.dong;

import java.io.*;

public class txtToObject {

    public static void main(String[] args) throws IOException {
        a();
    }

    static b[] a() throws IOException {
        File f = new File("D:/radwtmp");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s;
        String[] strings;
        b[] bs = new b[70000];
        int i = 0;
        while ((s = br.readLine()) != null) {
            strings = s.split("\\|");
            b b1 = new b(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5], strings[6], strings[7], strings[8]);
            bs[i] = b1;
            System.out.println(b1);
            i++;
        }
        return bs;
    }

    static class b {
        String a,b,c,d,e,f,g,h,i;

        public b() {
        }

        public b(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
            this.i = i;
        }

        @Override
        public String toString() {
            return "b{" +
                    "a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    ", c='" + c + '\'' +
                    ", d='" + d + '\'' +
                    ", e='" + e + '\'' +
                    ", f='" + f + '\'' +
                    ", g='" + g + '\'' +
                    ", h='" + h + '\'' +
                    ", i='" + i + '\'' +
                    '}';
        }
    }

}
