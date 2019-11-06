/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.barreira;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author anafrozza
 */
public class Ciclica implements Runnable{
    int position;
    double[] vetor;
    CyclicBarrier barreira;



    public Ciclica(int position, double[] vetor, CyclicBarrier barreira) {
        this.position = position;
        this.vetor = vetor;

        this.barreira = barreira;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
        }


        try {
            this.barreira.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            System.out.println("Erro: "+e);
        }

    }
}
