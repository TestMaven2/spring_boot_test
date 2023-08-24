package com.telran.spring_boot_test.test;

public class Main {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        a.setB(b);
        a.setC(c);
        a.setD(d);
    }
}
