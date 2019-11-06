/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.phaser;

import java.util.concurrent.Phaser;

/**
 *
 * @author anafrozza
 */
public class Divisao extends Thread{
    double[] vetor;
    int iteracoes;
    int numThreads;

    Phaser phaser;

    public Divisao(double[] vetor, int iteracoes) {
        this.vetor = vetor;
        this.iteracoes = iteracoes;
        this.phaser = new Phaser(2);
    }

    @Override
    public void run(){
        int count = 0;

        while (count <= this.iteracoes) {
            Phaser_Barreira tarefa01 = new Phaser_Barreira(1, vetor, phaser);
            Phaser_Barreira tarefa02 = new Phaser_Barreira(2, vetor, phaser);

            Thread thr01 = new Thread(tarefa01);
            Thread thr02 = new Thread(tarefa02);


            thr01.start();
            thr02.start();

            this.phaser.awaitAdvance(this.phaser.getPhase());

            count++;
        }
    }
}
