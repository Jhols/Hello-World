package cinetudo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class CineTudo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         /*Calendar c = Calendar.getInstance();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm E");
         String cole = "10/12/2020 14:25 Seg";
         Date d = new Date();
        try {
            d = sdf.parse(cole);
        } catch (ParseException ex) {
            Logger.getLogger(CineTudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setTime(d);
         
         System.out.println(sdf.format(d));
         c.add(Calendar.HOUR_OF_DAY, 10);
         System.out.println(c.getTime());
         System.out.println(c.get(Calendar.HOUR));
         System.out.println(c.get(Calendar.HOUR_OF_DAY));
         //String cole = "barril";
         Filme umFilme = new Filme(cole, cole, cole, 0, 0, cole);
         Sala umaSala = new Sala3D(5, 10);
         umaSala.addSessao(15, umFilme);
         System.out.println(umaSala.getNumero());
         System.out.println(umaSala.sessoes.get(0).getSala().getPreco());*/
         Calendar c = Calendar.getInstance();
         c.set(Calendar.HOUR_OF_DAY, 16);
         System.out.println(c.get(Calendar.HOUR_OF_DAY));
   }
    
}
