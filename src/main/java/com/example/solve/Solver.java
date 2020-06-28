/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.solve;


import static com.example.solve.Arranger.Arranger;
import static com.example.solve.Cruncher.Cruncher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author steve
 */
public class Solver {

    public static void main(String[] args) {
        
        if (args.length != 7) {
            System.out.println("Solver-1.0.jar");
            System.out.println("usage: java -jar Solver-1.0.jar <target> <number> <number> <number> <number> <number> <number>");
            System.out.println("example: java -jar Solver-1.0.jar 555 1 2 3 4 5 6");
            System.exit(1);
            
        }

        System.out.println("target is " + args[0]);

        ArrayList<String> argar = new ArrayList<>(Arrays.asList(args));
        argar.remove(0); //chop the target off
        ArrayList<ArrayList<String>> permutations = Arranger(argar);
       
         
        Iterator<ArrayList<String>> iter = permutations.iterator();

        while (iter.hasNext()) {
            Cruncher(iter.next(), Integer.valueOf(args[0] ));
        }

    }
}
