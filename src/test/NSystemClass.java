/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author asksoft
 */
public class NSystemClass {

    //private Map<String, Map> series = new HashMap<String, Map>();
    //private Map<String, Map> subSeries = new HashMap<String, Map>();
    private Map<String, String> number = new HashMap<String, String>();

    public void setNumber(String key, String number) {
        this.number.put(key, number);
        //this.number = nums;
    }

    public Map<String, String> getNumber() {
        return this.number;
    }

//    public void setSubSeries(String SubSeris) {
//        Map<String, Map> sub = new HashMap<String, Map>();
//        sub.put(SubSeris, this.number);
//        this.subSeries = sub;
//    }
//
//    public Map<String, Map> getSubSeries() {
//        return this.subSeries;
//    }
//
//    public void setSeries(String Seris) {
//        Map<String, Map> sereiss = new HashMap<String, Map>();
//        sereiss.put(Seris, this.subSeries);
//        this.subSeries = sereiss;
//    }
//
//    public Map<String, Map> getSeries() {
//        return this.series;
//    }
    public static void main(String args[]) {
        NSystemClass ns = new NSystemClass();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonEmp = gson.toJson(ns);
        System.out.print(jsonEmp);
    }

    public static NSystemClass NSystemClass() {
        NSystemClass n = new NSystemClass();
        n.setNumber("0", "10");
        n.setNumber("1", "20");
        n.setNumber("30", "20");
//        n.setSubSeries("1000-1100");
//        n.setSeries("1000-1900");
        return n;
    }
}
