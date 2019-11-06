/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.latch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author anafrozza
 */
public class Divisao extends Thread{
    double[] vetor;
    int iteracoes;
    int numThreads;

    CountDownLatch doneSignal;
    CountDownLatch done;

    public Divisao(double[] vetor, int iteracoes, CountDownLatch done) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.done = done;
        this.doneSignal = new CountDownLatch(2);
    }

    @Override
    public void run(){
        int count_itera = 0;

        while (count_itera <= this.iteracoes) {
            try {
                Latch thread01 = new Latch(1, this.vetor, this.doneSignal);
                Latch thread02 = new Latch(2, this.vetor, this.doneSignal);

                thread01.start();
                thread02.start();

                this.doneSignal.await();
                count_itera++;
                this.doneSignal = new CountDownLatch(2);

            } catch (InterruptedException ex) {
                System.out.println("Erro: "+ex);
            }
        }
        this.done.countDown();
    }

}
