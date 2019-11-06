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
public class Phaser_Barreira implements Runnable{
    int position;
    double[] vetor;

    Phaser phaser;

    public Phaser_Barreira(int position, double[] vetor, Phaser phaser) {
        this.position = position;
        this.vetor = vetor;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
        }
        this.phaser.arrive();
    }
}
