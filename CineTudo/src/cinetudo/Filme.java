package cinetudo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Filme {
    private String titulo, diretor, atorPrincipal, categoria;
    private int duracao, faixaEtaria,codigo;
    
    public Filme(String titulo, String diretor, String ator, int duracao, int faixaEtaria, String categoria) {
        this.titulo = titulo;
        this.diretor = diretor;
        atorPrincipal = ator;
        this.duracao = duracao;
        this.faixaEtaria = faixaEtaria;
        this.categoria = categoria;
    }

    public Filme(String titulo) {
        this.titulo = titulo;
    }

    public Filme() {
    }
    
    
    
    
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String novoTitulo) {
        titulo = novoTitulo; 
    }
    
    public String getDiretor() {
        return diretor;
    }
    
    public void setDiretor(String novoDiretor) {
        diretor = novoDiretor; 
    }
    
    public String getAtor() {
        return atorPrincipal;
    }
    
    public void setAtor(String novoAtor) {
        atorPrincipal = novoAtor; 
    }
    
    public int getFaixaEtaria() {
        return faixaEtaria;
    }
    
    public void setFaixaEtaria(int novaFaixa) {
        faixaEtaria = novaFaixa; 
    }
    
    public int getDuracaoMin() {
        return duracao;
    }
    
    public int getDuracaoHora() {
        return duracao/60;
    }
    
    public void setDuracao(int novaDuracao) {
        duracao = novaDuracao; 
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String novaCategoria) {
        categoria = novaCategoria; 
    }
    
    public int incluir(){
    Banco.FilmeDAO x = new Banco.FilmeDAO();
    x.incluir(this);
    return 0;
    }
    
    public int deletar(){
    Banco.FilmeDAO x = new Banco.FilmeDAO();
    x.deletar(this);
    return 0;
    }
    
    public int alterar(){
    Banco.FilmeDAO x = new Banco.FilmeDAO();
    x.alterar(this);
    return 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    public void pesquisar(){
        Banco.FilmeDAO x = new Banco.FilmeDAO();
        ResultSet resultado = x.pesquisar(this);
        try{
            while (resultado.next())
            {
                this.titulo = resultado.getString("Titulo");
                this.diretor = resultado.getString("Diretor");
                this.atorPrincipal = resultado.getString("AtorPrincipal");
                this.duracao = resultado.getInt("Duracao");
                this.faixaEtaria = resultado.getInt("Classificacao");
                this.categoria = resultado.getString("Categoria");
                //this.nota = resultado.getFloat("nota");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> pesquisarNomeFilmes() {
        Banco.FilmeDAO x = new Banco.FilmeDAO();
        ArrayList<String> nomeFilmes = new ArrayList<>();
        ResultSet resultado = x.pesquisarNomeFilmes(this);
        try{
            while (resultado.next())
            {
                nomeFilmes.add(resultado.getString("Titulo"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return nomeFilmes;
    }
        
    
    public void pesquisar(String titulo){
        Banco.FilmeDAO x = new Banco.FilmeDAO();
        ResultSet resultado = x.pesquisar(this,titulo);
        try{
            while (resultado.next())
            {
                this.codigo = resultado.getInt("idFilme");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
     

}