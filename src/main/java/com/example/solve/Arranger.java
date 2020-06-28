/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.solve;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author steve
 * 
 * Returns all arrangements of an arraylist of strings (i.e. n!) as an arraylist of arraylists
 * 
 */
public class Arranger {

    public static ArrayList<ArrayList<String>> Arranger(ArrayList<String> elements) {

        ArrayList<ArrayList<String>> permutations = new ArrayList<>();
        if (elements.size() == 2) {
            //2 is easy
            ArrayList<String> a = new ArrayList<>();
            a.add(elements.get(0));
            a.add(elements.get(1));
            ArrayList<String> b = new ArrayList<>();
            b.add(elements.get(1));
            b.add(elements.get(0));

            permutations.add(a);
            permutations.add(b);

        } else {
            //do it the hard way
            for (int i = 0; i < elements.size(); i++) {
                //System.out.println("outer:" + i);
                int target = elements.size() - 1;
                ArrayList<String> elements2 = new ArrayList<>();
                int k = 0;
                for (int j = 0; j < target; j++) {
                    //System.out.println("inner:" + j);
                    if (i == j) {
                        //avoid dupe
                        k = 1;
                    }
                    elements2.add(elements.get(j + k));
                }

                ArrayList<ArrayList<String>> elements3 = Arranger(elements2);
                Iterator<ArrayList<String>> iter = elements3.iterator();
                while (iter.hasNext()) {
                    ArrayList<String> perm = new ArrayList<>();
                    perm.add(elements.get(i));
                    perm.addAll(iter.next());
                    permutations.add(perm);
                }
            }
        }

        return permutations;
    }

}
