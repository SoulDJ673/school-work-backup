/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.simplespringinjection;

/**
 *
 * @author souldj673
 */
public class LlamaFactoryApp {
    public static void main(String[] args) {
        Llama prism = new Llama("Oreo", "Brown");
        Llama oreo = new Llama("Prism", "White & Grey");
        Llama floyd = new Llama("Floyd", "Brown", prism, oreo);
        
        System.out.println("Tell me about Floyd,");
        System.out.println("Name: " + floyd.getName());
        System.out.println("Color: " + floyd.getWoolColor());
        System.out.println("Dam: " + floyd.getDam().getName());
        System.out.println("Sire: " + floyd.getSire().getName());
        
        
    }
}
