/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author asksoft
 */
public class ArrayListAddRemove {

    public static final ArrayList<String> list = new ArrayList<>();

    public static void main(String args[]) {
        list.add("1000-1900");
        list.add("2000-2900");
        list.add("3000-3900");
        System.out.println("Orignal ArrayList : " + list);
        list.remove(new String("2000-2900"));
        System.out.println("Modified ArrayList : " + list);

    }
}
