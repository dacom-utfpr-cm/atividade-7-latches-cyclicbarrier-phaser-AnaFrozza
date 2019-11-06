/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author anafrozza
 */
public class Main {
    public static void main(String[] args) {
        double[] vetor = new double[]{2,2,2,2};
        CountDownLatch done = new CountDownLatch(1);
        Divisao thread = new Divisao(vetor, 500, done);

        try {
            thread.start();
            done.await();
            System.out.println(Arrays.toString(vetor));
        } catch (InterruptedException ex) {
            System.out.println("Erro: "+ex);
        }
        
        System.out.println("Concluido!");
    }
}
