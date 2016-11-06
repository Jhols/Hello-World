/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joao
 */
public class SalaDAO {
    
    public int incluir(cinetudo.Sala s){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "insert into CineTudo.Sala (SalaCinema, Capacidade, Preco, TipoSala) values ("+s.getCineCod()+","+s.getCapacidade()+","+s.getPreco()+",'"+s.getTipoSala()+"')";
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

    public int alterar(cinetudo.Sala s){
      Connection minhaConexao = ConnectionFactory.getConnection();
      String sql;
      sql = "update CineTudo.Sala set Capacidade = "+s.getCapacidade()+", SalaCinema = "+s.getCineCod()+", TipoSala = '"+s.getTipoSala()+"'  where idSala = "+s.getNumero()+"";
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
