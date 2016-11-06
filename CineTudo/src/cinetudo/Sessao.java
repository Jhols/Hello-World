package cinetudo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


public class Sessao {
    private int id;
    private Filme filme;
    private String hora, data;
    private boolean assentos[][];
    private Sala sala;
    
    public Sessao(String hora, Filme filme, Sala sala) {
        this.hora = hora;
        Calendar umaData = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        data = sdf.format(umaData);
        this.filme = filme;
        this.sala = sala;
        assentos = new boolean[sala.getCapacidade()/5][5];
        Arrays.fill(assentos, Boolean.FALSE);
    }

    public Sessao(Filme filme, String hora, String data) {
        this.filme = filme;
        this.hora = hora;
        this.data = data;
    }    
    public Sala getSala() {
        return sala;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
         
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme novoFilme) {
        filme = novoFilme;
    }
       
    //metodo esta disponivel
    public boolean getAssento(int linha, int coluna) {
        return assentos[linha][coluna];
    }
    
    public void setAssento(int linha, int coluna, boolean estaOcupado) {
        assentos[linha][coluna] = estaOcupado;
    }
    
    //metodo assentos disponiveis
    public String[] assentosDisponiveis() {
        String cadeiras[] = new String[sala.getCapacidade()];
        int qtd = 0;
        
        for (int i=0; i<assentos.length; i++)
            for (int j=0; j<assentos.length; j++)
                if (assentos[i][j] == false) {
                    cadeiras[qtd] = ("Fila: " + i + "Coluna: " + j);
                    qtd++;
                }
        return cadeiras;   
    }
    
    public void pesquisarIdFilme() {
        Banco.SessaoDAO x = new Banco.SessaoDAO();
        ResultSet resultado = x.pesquisarIdFilme(this);
        int idFilme = 0;
        try{
            while (resultado.next())
            {
                idFilme = resultado.getInt("IdFilme");
                filme.setCodigo(idFilme);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void addSala(int idS)
    {
        Banco.SessaoDAO x = new Banco.SessaoDAO();
        ResultSet resultado = x.addSala(this,idS);
        try{
        while (resultado.next())
        {
            if (resultado.getString("TipoSala").equals("2D")){
                Sala umaSala = new Sala2D(idS, resultado.getInt("Capacidade"));
                umaSala.setPreco(resultado.getFloat("Preco"));
                umaSala.setTipoSala(resultado.getString("TipoSala"));
                this.sala=umaSala;
            }
            if (resultado.getString("TipoSala").equals("3D"))
            {
                Sala umaSala = new Sala3D(idS, resultado.getInt("Capacidade"));
                umaSala.setPreco(resultado.getFloat("Preco"));
                umaSala.setTipoSala(resultado.getString("TipoSala"));
                this.sala=umaSala;
            }
        }
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
        }        
    }
    
    public int incluir()
    {
        Banco.SessaoDAO x = new Banco.SessaoDAO();
        x.incluir(this);
        return 0;
    }
    
}