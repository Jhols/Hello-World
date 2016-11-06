/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import cinetudo.Sessao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joao
 */
public class SessaoDAO {
    
    public int incluir(cinetudo.Sessao sessao)
    {
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into CineTudo.Sessao (SalaSessao, FilmeSessao, Hora, Data) values ("+sessao.getSala().getNumero()+", "+sessao.getFilme().getCodigo()+",'"+sessao.getHora()+"', '"+sessao.getData()+"')";
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
    
    public ResultSet pesquisarIdFilme(cinetudo.Sessao sessao)
    {
    Connection minhaConexao = ConnectionFactory.getConnection();
    String sql;
    sql = "select idFilme from CineTudo.Filme where Titulo = ('"+sessao.getFilme().getTitulo()+"')";
    
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
    
    public ResultSet addSala (cinetudo.Sessao sessao, int idS)
    {
        Connection minhaConexao = ConnectionFactory.getConnection();
        String sql;
        sql = "select Capacidade,Preco,TipoSala from CineTudo.Sala where idSala = ("+idS+")";

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
    
    public int alterar(cinetudo.Sessao s){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update CineTudo.Filme set Hora = '"+s.getHora()+"' ,SalaSessao = "+s.getSala().getNumero()+",FilmeSessao = "+s.getFilme().getCodigo()+",Data = '"+s.getData()+"' where idSessao = "+s.getId()+"";
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
    
     /*public ResultSet pesquisar(cinetudo.Filme f){
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
    }*/
    
    public int deletar (cinetudo.Sessao s){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "delete from CineTudo.Sessao where idSessao = "+s.getId()+"";
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
 
