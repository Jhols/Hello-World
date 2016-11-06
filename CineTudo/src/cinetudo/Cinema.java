package cinetudo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cinema {
    private int i;
    private ArrayList<Sala> salas;
    private ArrayList<Promocao> promocoes;
    private float receita;
    private String nome;
    
    
    public Cinema(String nome) {
        this.nome = nome;
        salas = new ArrayList<>();
        promocoes = new ArrayList<>();
        receita = 0;
    }

    public Cinema(int i, String nome) {
        this.i = i;
        this.nome = nome;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
    

    public Cinema() {
    }
    

    
    public Cinema(int i) {
        this.i = i;
    }

    public Cinema(ArrayList<Sala> salas) {
        this.salas = salas;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
    public float getReceita() {
        return receita;
    }
    
    public void aumentarReceita(float precoIngresso) {
        receita += precoIngresso;
    }
    
    public void diminuirReceita(float precoIngresso) {
        receita -= precoIngresso;
    }
    
    public Promocao getPromocao(int indice) {
        return promocoes.get(indice);
    }
    
    public int qtdPromocoes() {
        return promocoes.size();
    }
    
    public void addSala2D(int numero, int capacidade) {
        Sala novaSala = new Sala2D(numero, capacidade);
        salas.add(novaSala);
    }
    
    public void addSala3D(int numero, int capacidade) {
        Sala novaSala = new Sala3D(numero, capacidade);
        salas.add(novaSala);
    }
      
    
    
    
    //Acesso ao Banco de Dados
    
    public int incluir(){
    Banco.CinemaDAO x = new Banco.CinemaDAO();
    x.incluir(this);
    return 0;
    }
    
    public void pesquisar(String nome){
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        ResultSet resultado = x.pesquisar(this,nome);
        try{
        while (resultado.next())
        {
            this.i = resultado.getInt("idCinema");
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Cinema> pesquisarNomes(){
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        ArrayList<Cinema> nomeCine = new ArrayList<>();
        ResultSet resultado = x.pesquisarNomes(this);
        try{
        while (resultado.next())
        {
            String nomeC = resultado.getString("Nome");
            int idcine = resultado.getInt("idCinema");
            Cinema cine = new Cinema(idcine, nomeC);
            nomeCine.add(cine);
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
        return nomeCine;
    }    
    
    public void removerSala(int numero) {
        int k=0;
        for (Sala umaSala : salas) {
            if (numero == salas.get(k).getNumero())
                break;
            k++;
        }
        if (k < salas.size())
            salas.remove(k);
    }
   
    public String pesquisarTipo(int idSala){
        String tSala = null;
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        ResultSet resultado = x.pesquisarTipo(idSala);
        try {
            while (resultado.next()) {
                tSala = resultado.getString("TipoSala");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return tSala;
    }

    
    public void pesquisar(){
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        ResultSet resultado = x.pesquisar(this,this.salas);
        try{
        while (resultado.next())
        {
            if (resultado.getString("Sala.TipoSala").equals("2D")){
                Sala umaSala = new Sala2D(resultado.getInt("Sala.idSala"), resultado.getInt("Sala.Capacidade"));
                umaSala.setPreco(resultado.getFloat("Sala.Preco"));
                umaSala.setCine(resultado.getString("Cinema.Nome"));
                umaSala.setTipoSala(resultado.getString("Sala.TipoSala"));
                salas.add(umaSala);
            }
            if (resultado.getString("Sala.TipoSala").equals("3D"))
            {
                Sala umaSala = new Sala3D(resultado.getInt("Sala.idSala"), resultado.getInt("Sala.Capacidade"));
                umaSala.setCapacidade(resultado.getInt("Sala.Capacidade"));
                umaSala.setPreco(resultado.getFloat("Sala.Preco"));
                umaSala.setCine(resultado.getString("Cinema.Nome"));
                umaSala.setTipoSala(resultado.getString("Sala.TipoSala"));
                salas.add(umaSala);
            }
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }
    }
    
    public int alterar(){
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        x.alterar(this);
        return 0;
    }
    
    public int deletar(){
        Banco.CinemaDAO x = new Banco.CinemaDAO();
        x.deletar(this);
        return 0;
    }
    
}
