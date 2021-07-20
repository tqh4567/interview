package com;

public class Demo {
    public static class A{
        public A(){
            System.out.println("A够着器");
        }
        {
            System.out.println("A代码块");
        }
        static {
            System.out.println("A静态代码块");
        }
    }
    public static class B extends A{
        public B(){
            System.out.println("B够着器");
        }
        {
            System.out.println("B代码块");
        }
        static {
            System.out.println("B静态代码块");
        }
        public static void main(String[] args) {
            System.out.println("B====== start");
            B b = new B();
//            A a = new B();
            System.out.println("B====== end");
        }
    }
}
