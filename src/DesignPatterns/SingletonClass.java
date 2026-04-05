package DesignPatterns;


/**
It will Return the same instance every time it is called.
**/

public class SingletonClass {
    private SingletonClass() {
    }
    public static  SingletonClass createNewInstance() {
        return SingletonHelper.singletonClass;
    }
    public static class SingletonHelper{
        public static final SingletonClass singletonClass = new SingletonClass();
    }
}