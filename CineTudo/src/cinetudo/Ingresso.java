package cinetudo;

import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ingresso {
    private Sessao sessao;
    private Cinema cine;
    private String assento;
    private float precoFinal;
    private int fila, coluna;
    
    
    public Ingresso(Cinema cine, Sessao sessao, int fila, int coluna) {
        this.cine = cine;
        this.sessao = sessao;
        this.precoFinal = 0;
        this.fila = fila;
        this.coluna = coluna;
    }
   
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cinema getCine() {
        return cine;
    }

    public void setCine(Cinema cine) {
        this.cine = cine;
    }
    
    //metodo imprimir ticket
    public String imprimirIngresso() {
        return ("Filme: " + sessao.getFilme() + "\nData: "+ sessao.getData().toString() +"\nHora: "+ sessao.getHora() +"\nSala: "+ sessao.getSala().getNumero() +"Assento: "+ (char)fila+65 +""+ coluna);
    }
    
    //metodo vender
    public void venderIngresso(boolean meiaEntrada) {
        Calendar dataAtual = Calendar.getInstance();
        
        //verificar preço da sala
        precoFinal += sessao.getSala().getPreco();
        
        //Verificar a existência de promoções para a data atual e descontar do preço.
        for (int i=0; i<cine.qtdPromocoes(); i++) {
            if (dataAtual.get(Calendar.DAY_OF_MONTH) == cine.getPromocao(i).getData().get(Calendar.DAY_OF_MONTH))
                if (dataAtual.get(Calendar.MONTH) == cine.getPromocao(i).getData().get(Calendar.MONTH))
                    precoFinal *= cine.getPromocao(i).getDesconto()/100;
        }
        
        //verificar meia entrada
        if (meiaEntrada == true)
            precoFinal /= 2;
        
        cine.aumentarReceita(precoFinal);
        
        //modifica o assento da sessão
        sessao.setAssento(fila, coluna, true);
    }
    
    //metodo cancelar venda
    public void cancelaIngresso() {
        cine.diminuirReceita(precoFinal);
        sessao.setAssento(fila, coluna, false);
        //deletar do banco
    }


    
}
