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
public class Latch extends Thread{
    int posicao;
    double[] vetor;
    CountDownLatch sinal;

    public Latch(int posicao, double[] vetor, CountDownLatch sinal) {
        this.posicao = posicao;
        this.vetor = vetor;
        this.sinal = sinal;
    }

    @Override
    public void run() {
        if ((this.posicao != 0) && this.posicao != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.posicao - 1] + this.vetor[this.posicao + 1]) / 2;

            this.vetor[this.posicao] = valor;
        }
        this.sinal.countDown();
    }
}
