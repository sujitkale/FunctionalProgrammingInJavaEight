/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skaleapps.j8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 32863
 */
public class PickTest {

    public PickTest() {

        List<String> friends2 = new ArrayList<>();
        friends2.add("Nandini");
        friends2.add("Narmada");
        friends2.add("Priya");
        friends2.add("Pallavi");
        friends2.add("Nidhi");
        friends2.add("Parinita");
        friends2.add("Neha");

        // pick first name starting with P
        System.out.println("---- using traditional for ----");
        String found = null;
        for (String name : friends2) {
            if (name.startsWith("P")) {
                found = name;
                break;
            }
        }
        if (found != null) {
            System.out.println("name " + found);
        } else {
            System.out.println("name not found");
        }

        System.out.println("---- using filter and lambda ----");
        Optional<String> foundByJ8 = friends2.stream()
                .filter(name -> name.startsWith("z"))
                .findFirst();
        System.out.println("name " + foundByJ8.orElse(" not found"));
    }
}
