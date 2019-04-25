/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skaleapps.j8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 32863
 */
public class MapTest {

    public MapTest() {
        List<String> friends = new ArrayList<>();
        friends.add("Alice");
        friends.add("Barbara");
        friends.add("Clita");
        friends.add("Dorothy");
        friends.add("Emma");

        // make all upper case
        System.out.println("---- traditional for loop ----");
        List<String> FRIENDS = new ArrayList<>();
        for (String name : friends) {
            FRIENDS.add(name.toUpperCase());
        }
        FRIENDS.forEach(System.out::println);

        System.out.println("---- using lambda expression ----");
        friends.forEach(name -> FRIENDS.add(name.toUpperCase()));
        FRIENDS.forEach(System.out::println);

        System.out.println("---- using map ----");
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
        
        System.out.println("---- using map for different operations ----");
        friends.stream()
                .map(name -> name.replace('a','z'))
                .forEach(System.out::println);
    }
}
