/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade07.barreira;

/**
 *
 * @author anafrozza
 */
public class EstouroBarreira implements Runnable{
    Divisao divisao;

    public EstouroBarreira(Divisao classe) {
        this.divisao = classe;
    }

    @Override
    public void run() {
        this.divisao.count_itera++;
    }
}
