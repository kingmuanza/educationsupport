/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author N9-T
 */
public class Test {
 
    
    public static void main(String []args){
        List<TestClass> ltc = new ArrayList<>();
        TestClass tc1 = new TestClass(12,"tc1");
        TestClass tc2 = new TestClass(2,"tc1");
        TestClass tc3 = new TestClass(123,"tc1");
        ltc.add(tc3);
        ltc.add(tc2);
        ltc.add(tc1);
        System.out.println("PREMIER = TC2 ******** "+(ltc.indexOf(tc2)+1));
        Collections.sort(ltc, (a,b) -> retournAge(a) < retournAge(b) ? -1 :retournAge(a) == retournAge(b) ? 0: 1);
        ltc.forEach((TestClass a) -> {
            System.out.println(a.getAge());
        });
        System.out.println("PREMIER = TC2 ******** "+(ltc.indexOf(tc2)+1));
    }
    
    private static int retournAge(TestClass tc){
        return tc.getAge();
    }
    
    static class TestClass{
        private int age;
        private String nom;
        
        public TestClass(int age, String nom){
            this.age = age;
            this.nom = nom;
        }
        
        public int getAge(){
            return this.age;
        }
    }
    
}
