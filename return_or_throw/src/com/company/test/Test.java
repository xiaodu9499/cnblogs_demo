package com.company.test;

import com.company.exception.MyException;

public class Test {

    public static void main(String[] args) {
        Integer size10000 = 10000;

        returns(size10000);
        myExceptions(size10000);
        throwRunTime(size10000);

        Integer size100000 = 100000;

        returns(size100000);
        myExceptions(size100000);
        throwRunTime(size100000);

        Integer size1000000 = 1000000;

        returns(size1000000);
        myExceptions(size1000000);
        throwRunTime(size1000000);
    }


    public static void returns(Integer size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            testReturn();
        }
        System.out.println("return " + size + "条耗时" + (System.currentTimeMillis() - start));
    }

    public static void myExceptions(Integer size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            try {
                testThrowMyException();
            } catch (Exception e) {

            }
        }
        System.out.println("myException " + size + "条耗时" + (System.currentTimeMillis() - start));
    }

    public static void throwRunTime(Integer size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            try {
                testThrowRunTime();
            } catch (Exception e) {

            }
        }
        System.out.println("RunTime " + size + "条耗时" + (System.currentTimeMillis() - start));
    }

    public static Integer testReturn() {
        if (1 == 1) {
            return 1;
        }
        return 2;
    }

    public static void testThrowMyException() {
        if (1 == 1) {
            throw new MyException("test MyException");
        }
    }

    public static void testThrowRunTime() {
        if (1 == 1) {
            throw new RuntimeException("test MyException");
        }
    }

}
