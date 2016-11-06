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
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class CinemaDAO {
    public int incluir(cinetudo.Cinema c){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into CineTudo.Cinema (Nome) values ('"+c.getNome()+"')";
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
    
    public ResultSet pesquisar(cinetudo.Cinema c, String nome){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select idCinema from CineTudo.Cinema where Nome = ('"+nome+"')";
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

    public ResultSet pesquisarTipo(int idSala){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select TipoSala from CineTudo.Sala where id = ("+idSala+")";
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
    
    public ResultSet pesquisar(cinetudo.Cinema c, ArrayList<cinetudo.Sala> salas){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select Sala.idSala, Sala.Capacidade, Sala.Preco, Sala.TipoSala, Cinema.Nome from CineTudo.Sala join CineTudo.Cinema on Sala.SalaCinema = Cinema.idCinema;";
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
    
    public ResultSet pesquisarNomes(cinetudo.Cinema c){
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select Nome,idCinema from CineTudo.Cinema";
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

    public int alterar(cinetudo.Cinema c){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update CineTudo.Cinema set Nome = '"+c.getNome()+"' where idCinema = "+c.getI()+"";
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

    public int deletar (cinetudo.Cinema c){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from CineTudo.Cinema where idCinema = "+c.getI()+"";
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
