/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.phaser;

import java.util.Arrays;

/**
 *
 * @author anafrozza
 */
public class Main {
    public static void main(String[] args) {
        double[] vetor = new double[]{2, 2, 2, 2};

        Divisao thread = new Divisao(vetor, 5000);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println("Erro: "+e);
        }

        System.out.println(Arrays.toString(vetor));
    }
}
