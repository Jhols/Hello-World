package cinetudo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Sala3D extends Sala {
    
    final String TIPOSALA = "3D";
    
    public Sala3D(int numero, int capacidade) {
        criaSala(numero, capacidade);
       // tipoSala = "3D";
        preco *= 1.2;
    }
    
    public Sala3D(int capacidade) {
        criaSala(capacidade);
        //tipoSala = "3D";
        preco *= 1.2;
    }    
/*    
    public void setPreco(float valorInteira) {
        super.setPreco(valorInteira);
        preco *= 1.2;
    }
*/
}
