package agh.ii.prinjava.lab02.lst02_07;

/*
 * An interface is a mechanism for specifying a contract between two parties:
 *   the supplier of a service and the classes that want their objects to be usable with the service.
 */

/**
 * <ul>
 *     <li>Modifier 'abstract' is redundant for interfaces</li>
 *     <li>Modifier 'abstract' is redundant for interface methods</li>
 *     <li>Modifier 'public' is redundant for interface methods</li>
 * </ul>
 */
abstract interface I1 {
    public abstract void m1();
}

interface I2 { // it is still abstract
    void m21(); // it is still public abstract

    void m22(); // as above
}
