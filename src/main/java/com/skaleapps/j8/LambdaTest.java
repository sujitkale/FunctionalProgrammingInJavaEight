/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skaleapps.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author 32863
 */
public class LambdaTest {
    public LambdaTest() {
        List<String> friends = new ArrayList<>();
        friends.add("Alice");
        friends.add("Barbara");
        friends.add("Clita");
        friends.add("Dorothy");
        friends.add("Emma");

        // traditional for loop
        for (String name : friends) {
            System.out.println("a = " + name);
        }

        // for each
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println("b = " + t);
            }

        });

        // lambda
        friends.forEach((final String name) -> System.out.println("c = " + name));

        // lambda with auto param type. can't make it final
        friends.forEach((name) -> System.out.println("d = " + name));

        // lambda with auto param type and no parentheses. This only works for one parameter. can't make it final
        friends.forEach(name -> System.out.println("d = " + name));
        
        // lambda with no param name and method reference
        friends.forEach(System.out::println);
    }
}
