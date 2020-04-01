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
public class CrossInput {

    public static void main(String agrs[]) {
        CrossInput.cross(11);
    }

    private static void cross(int p) {
        String index = "" + p;
        try {
            int last = (((p / 10) + 1) * 10) - 1;
            int rightbottom = last - p; //bottom right difference
            int back = (p / 10) * 10;
            int leftbottom = p - back;//bottom left
            ArrayList<String> num = new ArrayList<>();
            num.add("E_" + p);
            int K = p + 11;
            int s = 1;
            while (K <= 99 && s <= rightbottom) {

                num.add("E_" + K);
                K = K + 11;
                s++;
            }
            K = p - 11;
            s = 1;
            while (K > 0 && s <= rightbottom) {

                num.add("E_" + K);
                K = K - 11;
                s++;
            }
            K = p + 9;
            s = 1;
            while (K <= 99 && s <= leftbottom) {

                num.add("E_" + K);
                K = K + 9;
                s++;
            }
            K = p - 9;
            s = 1;
            while (K > 0 && s <= leftbottom) {

                num.add("E_" + K);
                K = K - 9;
                s++;
            }
            //int rightbottom = last - p; //right difference
            //index = "" + p;
            System.out.println(num);
        } catch (Exception ex) {

        }
    }
}
