package com.gupaoedu.aqs;

public class TestString {

    public static void main(String[] args) {
        String value  ="AAA";
        synchronized (value) {
            System.out.println(value.hashCode());
        }
    }

}
