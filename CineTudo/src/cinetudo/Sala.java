package cinetudo;

import java.util.ArrayList;

public abstract class Sala {
    protected ArrayList<Sessao> sessoes;
    protected int numero, capacidade;
    protected float preco;
    protected String cine;
    protected String tipoSala;
    protected int cineCod;

    protected void criaSala(int numero, int capacidade) {
        this.numero = numero;
        setCapacidade(capacidade);
        sessoes = new ArrayList<>();
        preco = 20;
    }
        
       
    protected void criaSala(int capacidade) {
        setCapacidade(capacidade);
        sessoes = new ArrayList<>();
        preco = 20;
    }    
    
    public int getCapacidade() {
        return capacidade;
    }
    
    public void setCapacidade(int qtd) {
        if (qtd >= 5) {
            if (qtd%5 == 0)
                capacidade = qtd;
            else
                capacidade = (qtd/5 + 1)*5;
        }
        else
            System.out.println("Numero de capacidade invalido!");
    }

    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int novoNum) {
        numero = novoNum;
    }
    
    public void addSessao(int hora, Filme filme) {
      // Sessao umaSessao = new Sessao(hora, filme, capacidade, this);
       // sessoes.add(umaSessao);
    }
    
    public void removerSessao(String hora) {
        int k=0;
        for (Sessao umaSessao : sessoes) {
            if (hora.equals(umaSessao.getHora()))
                break;
            k++;
        }
        if (k < sessoes.size())
            sessoes.remove(k);
    }
    
    public void setPreco(float valorInteira) {
        preco = valorInteira;
    }
    
    public float getPreco() {
        return preco;
    }
    
    public String getTipoSala() {
        return tipoSala;
    }
    
    public void setTipoSala(String novoTipo) {
        tipoSala = novoTipo;
    }
    
    public void addFilmeNumaSessao(String hora, Filme filme) {
        int k=0;
        for (Sessao umaSessao : sessoes) {
            if (hora.equals(umaSessao.getHora()))
                break;
            k++;
        }
        if (k < sessoes.size())
            sessoes.get(k).setFilme(filme);
        else
            System.out.println("A sessao de "+ hora +" horas não foi encontrada!");
    }

    public String getCine() {
        return cine;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }

    public int getCineCod() {
        return cineCod;
    }

    public void setCineCod(int cineCod) {
        this.cineCod = cineCod;
    }
    
    public int incluir(){
        Banco.SalaDAO x = new Banco.SalaDAO();
        x.incluir(this);
    return 0;
    }
    
    public int alterar(){
        Banco.SalaDAO x = new Banco.SalaDAO();
        x.alterar(this);
        return 0;
    }    
    
    
    
}