package DesignPatterns;


/**
It will Return the same instance every time it is called.
**/

public class SingletonClass {


    private SingletonClass() {
    }

    private static SingletonClass singletonObject = null;


    public static  SingletonClass createNewInstance() {

            if(singletonObject == null){
                singletonObject =  new SingletonClass();
            }

        return singletonObject;
    }

}