/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skaleapps.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author 32863
 */
public class FilterTest {

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }

    public FilterTest() {
        List<String> friends = new ArrayList<>();
        friends.add("Alice");
        friends.add("Alexa");
        friends.add("Scarlet");
        friends.add("Amelia");
        friends.add("Amy");
        friends.add("Susan");
        friends.add("Samntha");

        //find names staring with A
        System.out.println("---- traditional for loop ----");
        List<String> listStartsWithA = new ArrayList<>();
        for (String name : friends) {
            if (name.startsWith("A")) {
                listStartsWithA.add(name);
            }
        }
        listStartsWithA.forEach(System.out::println);

        System.out.println("---- using filter with lambda expression ----");
        List<String> listStartsWithAJ8 = friends.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        listStartsWithAJ8.forEach(System.out::println);

        List<String> friends2 = new ArrayList<>();
        friends2.add("Nandini");
        friends2.add("Narmada");
        friends2.add("Priya");
        friends2.add("Pallavi");
        friends2.add("Nidhi");
        friends2.add("Parinita");
        friends2.add("Neha");

        System.out.println("---- using filter with lambda expression (duplicate code)----");
        List<String> listStartsWithNJ8 = friends2.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        listStartsWithNJ8.forEach(System.out::println);

        System.out.println("---- using filter and predicate ----");
        final Predicate<String> startsWithA = name -> name.startsWith("A");
        listStartsWithAJ8 = friends.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());
        listStartsWithAJ8.forEach(System.out::println);

        System.out.println("---- using filter and predicate (duplicate code)----");
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        listStartsWithNJ8 = friends2.stream()
                .filter(startsWithN)
                .collect(Collectors.toList());
        listStartsWithNJ8.forEach(System.out::println);
        
        System.out.println("---- using filter and reusable predicate ----");
        listStartsWithAJ8 = friends.stream()
                .filter(checkIfStartsWith("A"))
                .collect(Collectors.toList());
        listStartsWithAJ8.forEach(System.out::println);
        
        listStartsWithNJ8 = friends2.stream()
                .filter(checkIfStartsWith("N"))
                .collect(Collectors.toList());
        listStartsWithNJ8.forEach(System.out::println);
    }
}
