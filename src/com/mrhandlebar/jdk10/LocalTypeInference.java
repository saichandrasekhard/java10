package com.mrhandlebar.jdk10;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates how Local Type Inference in Java 10 works
 */
public class LocalTypeInference {

    public static void main(String args[]) {
        demoLocalTypeInference();
    }

    private static void demoLocalTypeInference() {
        var iAmAString = "Hello World";
        System.out.println(iAmAString + " is a String - " + (iAmAString instanceof String));

        var iAmAnInt = returnInteger();
        System.out.println(iAmAnInt + " is an Integer  - " + (iAmAnInt instanceof Integer));

        // Note that this doesn't make Java dynamically typed language.
        // The following still gives compilation error as it has been inferred as Integer on first assignment
        // and it stays that way
        //iAmAnInt = "Hello";

        // var also works with collections
        var iAmAMap = new HashMap<String, String>();
        iAmAMap.put("A", "B");
        iAmAMap.put("B", "C");
        System.out.println(iAmAMap +" is a Map - "+ (iAmAMap instanceof Map));
    }

    private static Integer returnInteger() {
        return 5;
    }

}
