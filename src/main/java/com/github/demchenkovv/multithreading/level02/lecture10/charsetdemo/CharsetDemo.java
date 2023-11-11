package com.github.demchenkovv.multithreading.level02.lecture10.charsetdemo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CharsetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "Hello world";
        byte[] b = str.getBytes();
        System.out.println(Arrays.toString(b));

        Charset charset = Charset.forName("UTF-8");
        String string = new String(b, charset);
        System.out.println(string);
    }
}
