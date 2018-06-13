package com.riccio.access_modifiers;

interface Accessible { // interface is visible to package level
    int SOME_CONTSTANT=100; // every class in the same package
    public void methodA();
    void methodB();
    boolean methodC();
}
