/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class NSystemArray {

    public Map<String, Map> series = new HashMap<>();

    //Add Series
    public void setMainSeries(String Series) {
        Map<String, Map> tempSeries = new HashMap<>();
        this.series.put(Series, tempSeries);
    }

    public void setSubSeries(String subSeries, String Main) {//Mian=1000-1900
        Map<String, Map> mainSeries = this.series.get(Main);//get Main         
        Map<String, ArrayList> tempSubSeries = new HashMap<>();
        ArrayList<Map> aMap = new ArrayList<>();
        tempSubSeries.put(subSeries, aMap);
        mainSeries.put(subSeries, tempSubSeries);

    }

    public void setNumber(String index, String value, String Main, String Sub) {
        try {
            Map<String, Map> mainSeries = this.series.get(Main);//Main
            Map<String, ArrayList> tempSubSeries = mainSeries.get(Sub);//Sub
            ArrayList<Map> aMap = tempSubSeries.get(Sub);//Array
            boolean flag = false;
            for (int i = 0; i < aMap.size(); ++i) {
                Map<String, String> numberTemp = aMap.get(i);
                for (Map.Entry<String, String> finas : numberTemp.entrySet()) {
                    if (finas.getKey().equals(index)) {
                        numberTemp.replace(finas.getKey(), value);
                        flag = true;
                    }
                }

            }
            if (!flag) {
                Map<String, String> number = new HashMap<>();
                number.put(index, value);
                aMap.add(number);
            }
            //mainSeries.put(Sub, tempSubSeries);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String args[]) {
        NSystemArray ns = new NSystemArray();
        ns.setMainSeries("1000-1900");
        ns.setSubSeries("1000-1099", "1000-1900");
        ns.setNumber("0", "1", "1000-1900", "1000-1099");
        ns.setNumber("1", "1", "1000-1900", "1000-1099");
        ns.setNumber("1", "5", "1000-1900", "1000-1099");

        ns.setMainSeries("2000-2900");
        ns.setSubSeries("2000-2099", "2000-2900");
        ns.setNumber("0", "1", "2000-2900", "2000-2099");
        ns.setNumber("1", "1", "2000-2900", "2000-2099");
        ns.setNumber("2", "1", "1000-1900", "1000-1099");

        int qty = 0;
        String sr = "";
        Map<String, Integer> final_Map = new HashMap<>();
        for (Map.Entry<String, Map> entry : ns.series.entrySet()) {
            Map<String, ArrayList> test = entry.getValue();
            for (Map.Entry<String, ArrayList> entrys : test.entrySet()) {
                sr = entry.getKey();
                Map<String, ArrayList> tp = new HashMap<>();
                tp = (Map<String, ArrayList>) entrys.getValue();
                //System.out.println(tp);
                for (Map.Entry<String, ArrayList> num : tp.entrySet()) {
                    //System.out.println(num.getValue());
                    ArrayList<Map> number = num.getValue();
                    for (int i = 0; i < number.size(); i++) {
                        Map<String, String> numF = (number.get(i));
                        for (Map.Entry<String, String> finas : numF.entrySet()) {
                            int userQty = Integer.parseInt(finas.getValue());
                            qty = qty + userQty;
                        }
                    }
                }
            }
            final_Map.put(sr, qty);
            qty = 0;
            //System.out.println("Key = " + entry.getKey()
            //    + ", Value = " + entry.getValue());
        }
        System.out.println(final_Map);
        System.out.println("total Qty: " + qty);
        System.exit(0);
        //get pervious no
        System.out.println(ns.series.get("1000-1900"));
        Map<String, Map> subSeries = ns.series.get("1000-1900");
        System.out.println(subSeries.get("1000-1099"));
        Map<String, ArrayList> aMap = subSeries.get("1000-1099");
        ArrayList<Map> aListMap = aMap.get("1000-1099");
        for (int i = 0; i < aListMap.size(); i++) {
            Map<String, String> fi = aListMap.get(i);
            for (Map.Entry<String, String> entry : fi.entrySet()) {
                System.out.println(entry.getKey());
            }
        }

        System.out.println(aListMap);

        for (int i = 1000; i <= 10990; i = i + 1000) {
            int t = i + 900;
            System.out.println("Q" + i + "_" + t);

        }
        if (ns.checkSubSeries("3000-3099", "3000-3900")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

//        ns.series.entrySet().stream().forEach((Series) -> {
//            Series.getValue().entrySet().stream().forEach((SubSseries) -> {
//                
//            });
//            
//        });
        System.exit(0);
//        Map<String, Map> series = new HashMap<>();
//        Map<String, Map> subSeries = new HashMap<>();
//        Map<String, Integer> Number = new HashMap<>();
//
//        series.put("1000-1900", subSeries);
//        subSeries.put("1000-1900", Number);
//        Number.put("0", 1);
//        Number.put("1", 2);
//        Number.put("2", 3);
//        series.put("1000-1900", subSeries);
//        Map<String, Integer> Number2 = new HashMap<>();
//        subSeries.put("2000-2900", Number2);
//        Number2.put("0", 4);
//        Number2.put("1", 5);
//        Number2.put("2", 6);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String jsonEmp = gson.toJson(series);
//        System.out.print(jsonEmp);

//        Map<String, Map> series = new HashMap<>();
//        Map<String, Map> subSeries = new HashMap<>();
//        Map<String, String> number = new HashMap<>();
//        series.put("1000-1900", subSeries);
//        subSeries.put("1000-1099", number);
//        number.put("0", "10");
//        ArrayList<Map> test=(ArrayList<Map>) series;
//        Iterator<Map> itr = test.iterator();
//        while (itr.hasNext()) {
//            Map<String, String> temp = itr.next();
//            System.out.println(temp.get("1000-1900"));
//        }
    }

    public boolean checkSubSeries(String btxt, String text) {
        boolean r = false;
        try {
            System.out.println(this.series.get(text));
            Map<String, Map> subSeries = this.series.get(text);
            System.out.println(subSeries.get(btxt));
            Map<String, ArrayList> aMap = subSeries.get(btxt);
            ArrayList<Map> aListMap = aMap.get(btxt);
            if (aListMap.size() > 0) {

                r = true;
            } else {
                r = false;
            }
        } catch (Exception ex) {

        }
        return r;
    }

}
