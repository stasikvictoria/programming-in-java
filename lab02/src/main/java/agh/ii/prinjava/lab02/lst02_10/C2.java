package agh.ii.prinjava.lab02.lst02_10;

/**
 * A functional interface can be implemented by named (non-anonymous) classes
 */
class C2 implements I2 {
    @Override
    public void m1() {
        System.out.println("C2.m1()");
    }
}

// Not a functional interface (no abstract method)}
//@FunctionalInterface interface I01 {}

// Not a functional interface (more than one abstract method)}
//@FunctionalInterface
//interface I02 {
//    void m1();
//    void m2();
//}
