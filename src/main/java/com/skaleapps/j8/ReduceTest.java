/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skaleapps.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author 32863
 */
public class ReduceTest {

    public ReduceTest() {

        List<String> friends2 = new ArrayList<>();
        friends2.add("Nandini");
        friends2.add("Narmada");
        friends2.add("Priya");
        friends2.add("Pallavi");
        friends2.add("Nidhi");
        friends2.add("Parinita");
        friends2.add("Neha");

        //count length of all the names
        System.out.println("using traditional for loop");
        int count = 0;
        for (String name : friends2) {
            count += name.length();
        }
        System.out.println("count = " + count);

        System.out.println("using lambda, map and sum");
        System.out.println("count = " + friends2.stream()
                .mapToInt(name -> name.length())
                .sum()
        );

        System.out.println("using lambda, map and sum - another operation");
        OptionalInt longestNameLen = friends2.stream()
                .mapToInt(name -> name.length())
                .max();
        System.out.println("longestNameLen = " + (longestNameLen.isPresent() ? longestNameLen.getAsInt() : " not found"));

        System.out.println("using reduce");
        final Optional<String> longestName = friends2.stream()
                .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        longestName.ifPresent(name -> System.out.println("longest name: " + name));

        System.out.println("using reduce with default value");
        final String madhumalatiOrLonger = friends2.stream()
                .reduce("Madhumalati", (name1, name2)
                        -> name1.length() >= name2.length() ? name1 : name2
                );
        System.out.println("madhumalatiOrLonger = " + madhumalatiOrLonger);
    }

}
