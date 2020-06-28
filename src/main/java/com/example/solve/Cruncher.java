/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.solve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author steve
 */
public class Cruncher {

    public static void Cruncher(ArrayList<String> numbers, Integer target) {

        ArrayList<ArrayList<Integer>> operations = new ArrayList<>();

        Integer[] a = new Integer[]{0, 1, 2, 3};
        Integer[] b = new Integer[]{0, 1, 2, 3};
        Integer[] c = new Integer[]{0, 1, 2, 3};
        Integer[] d = new Integer[]{0, 1, 2, 3};
        Integer[] e = new Integer[]{0, 1, 2, 3};
        Integer[] f = new Integer[]{0, 1, 2, 3};

        for (Integer one : a) {
            for (Integer two : b) {
                for (Integer three : c) {
                    for (Integer four : d) {
                        for (Integer five : e) {
                            for (Integer six : f) {

                                ArrayList<Integer> operators = new ArrayList<Integer>(Arrays.asList(one, two, three, four, five, six));
                                operations.add(operators);

                            }
                        }
                    }
                }
            }
        }

        //list done
        Iterator<ArrayList<Integer>> iter = operations.iterator();
        String solution = "";
        Boolean found = false;
        while (iter.hasNext()) {

            ArrayList<Integer> operators = iter.next();
            //System.out.println("oplist:" + operators);

            Integer running = Integer.parseInt(numbers.get(0));
            solution = numbers.get(0);

            Object[] out;

            for (int i = 1; i < numbers.size(); i++) {
                //System.out.println(numbers.get(i));
                out = compute(Integer.parseInt(numbers.get(i)), operators.get(i - 1), running, solution);
                
                if (target == (int)out[0]) {
                    System.out.println(target + " found by " + (String) out[1]);
                    found = true;
                    solution = (String) out[1];
                    break;
                } else {
                    running = (Integer) out[0];
                    solution = (String) out[1];
                }
            }
            if (found) {
            break;
        }

        }

    }

    private static Object[] compute(Integer number, Integer operator, Integer running, String solution) {

        switch (operator) {
            case 0:
                running = running + number;
                //System.out.println("add");
                //System.out.println(running);
                solution = solution + "+" + number;
                break;
            case 1:
                running = running - number;
                //System.out.println("sub");
                solution = solution + "-" + number;
                break;
            case 2:
                running = running * number;
                //System.out.println("mul");
                solution = solution + "*" + number;
                break;
            case 3:
                running = running / number;
                //System.out.println("div");
                solution = solution + "/" + number;
                break;

        }
        return new Object[]{running, solution};
    }
}
