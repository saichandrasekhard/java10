package com.mrhandlebar.jdk10;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

/**
 * Demonstration of the following features
 * List.copyOf()
 * Set.copyOf()
 * Map.copyOf()
 * Collectors.toUnmodifiableList()
 * Collectors.toUnmodifiableSet()
 * Collectors.toUnmodifiableMap()
 */
public class UnmodifiableCollections {

    public static void main(String args[]) {
        demoCopyOfList();
        demoCopyOfSet();
        demoCopyOfMap();

        demoToUnmodifiableList();
        demoToUnmodifiableSet();
        demoToUnmodifiableMap();
    }

    private static void demoCopyOfList() {
        List<String> names = Arrays.asList("Sai", "Chandra", "Sekhar");
        List<String> copyNames = List.copyOf(names);
        try {
            copyNames.add("Sateesh");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

    private static void demoCopyOfSet() {
        Set<String> names = new HashSet<>(Arrays.asList("Sai", "Chandra", "Sekhar"));
        Set<String> copyNames = Set.copyOf(names);
        try {
            copyNames.add("Sateesh");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

    private static void demoCopyOfMap() {
        Map<Integer, String> employees = Map.ofEntries(
                entry(1469, "Chandrasekhar"),
                entry(1339, "Sateesh")
        );
        Map<Integer, String> copyEmployees = Map.copyOf(employees);
        try {
            copyEmployees.put(1401, "Gandhi");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

    private static void demoToUnmodifiableList() {
        List<String> copyNames = Arrays.asList("Sai", "Chandra", "Sekhar").stream().collect(Collectors.toUnmodifiableList());
        try {
            copyNames.add("Sateesh");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

    private static void demoToUnmodifiableSet() {
        Set<String> copyNames = new HashSet<>(Arrays.asList("Sai", "Chandra", "Sekhar")).stream().collect(Collectors.toUnmodifiableSet());
        try {
            copyNames.add("Sateesh");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

    private static void demoToUnmodifiableMap() {
        Map<Integer, String> copyEmployees = Map.ofEntries(
                entry(1469, "Chandrasekhar"),
                entry(1339, "Sateesh")
        ).entrySet().stream().collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue, Objects::toString));
        try {
            copyEmployees.put(1401, "Gandhi");
        } catch (Exception e) {
            System.out.println("UnsupportedOperationException - " + (e instanceof UnsupportedOperationException));
        }
    }

}
