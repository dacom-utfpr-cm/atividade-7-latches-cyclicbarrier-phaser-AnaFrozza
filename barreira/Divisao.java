/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.barreira;

import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author anafrozza
 */
public class Divisao extends Thread{
    double[] vetor;
    int iteracoes;
    int numThreads;
    int count_itera;

    CyclicBarrier barreira;

    public Divisao(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.count_itera = 0;
        this.barreira = new CyclicBarrier(2,new EstouroBarreira(this));
    }

    @Override
    public void run(){
        while (this.count_itera <= this.iteracoes) {
            Ciclica tarefa01 = new Ciclica(1, this.vetor, this.barreira);
            Ciclica tarefa02 = new Ciclica(2, this.vetor, this.barreira);

            Thread th01 = new Thread(tarefa01);
            Thread th02 = new Thread(tarefa02);

            th01.start();
            th02.start();

            try {
                th01.join();
                th02.join();
            } catch (InterruptedException e) {
                System.out.println("Erro: "+e);
            }
            this.barreira.reset();
        }
    }
 
}
