/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joao
 */
public class FilmeDAO {
    
    public int incluir(cinetudo.Filme f){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into CineTudo.Filme (Titulo, Diretor, AtorPrincipal, Duracao, Classificacao, Categoria) values ('"+f.getTitulo()+"','"+f.getDiretor()+"','"+f.getAtor()+"',"+f.getDuracaoMin()+","+f.getFaixaEtaria()+",'"+f.getCategoria()+"')";
      int retorno=0;
      try{
          Statement stm = minhaConexao.createStatement();
          retorno = stm.executeUpdate(sql);
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return retorno;
      }
      
    }
    
    public int alterar(cinetudo.Filme f){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update CineTudo.Filme set Titulo = '"+f.getTitulo()+"' ,Diretor = '"+f.getDiretor()+"',AtorPrincipal = '"+f.getAtor()+"',Duracao = "+f.getDuracaoMin()+",Classificacao = "+f.getFaixaEtaria()+",Categoria  ='"+f.getCategoria()+"' where Titulo = '"+f.getTitulo()+"'";
      int retorno=0;
      try{
          Statement stm = minhaConexao.createStatement();
          retorno = stm.executeUpdate(sql);
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return retorno;
      }
      
    }

    public ResultSet pesquisar(cinetudo.Filme f, String titulo){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select idFilme from CineTudo.Filme where Titulo = ('"+titulo+"')";
        ResultSet resultado=null;
        try{
            Statement stm = minhaConexao.createStatement();
            resultado = stm.executeQuery(sql);
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return resultado;
      }

    }
    
    public ResultSet pesquisarNomeFilmes(cinetudo.Filme f) {
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select Titulo from CineTudo.Filme";
        ResultSet resultado=null;
        try{
            Statement stm = minhaConexao.createStatement();
            resultado = stm.executeQuery(sql);
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return resultado;
      }
    }

    public ResultSet pesquisar(cinetudo.Filme f){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select Titulo,Diretor,AtorPrincipal,Duracao,Classificacao,Categoria from CineTudo.Filme where Titulo='"+f.getTitulo()+"'";
        ResultSet resultado=null;
        try{
            Statement stm = minhaConexao.createStatement();
            resultado = stm.executeQuery(sql);
        }
        catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return resultado;
      }
    }
    
    public int deletar (cinetudo.Filme f){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from CineTudo.Filme where Titulo = '"+f.getTitulo()+"'";
      int retorno=0;
      try{
          Statement stm = minhaConexao.createStatement();
          retorno = stm.executeUpdate(sql);
      }
      catch (SQLException e){
          System.out.println(e.getMessage());
      }
      finally{
          return retorno;
      }
      
    }    
}
