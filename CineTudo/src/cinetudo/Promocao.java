package cinetudo;

import java.util.Calendar;

public class Promocao {
    private Calendar data;
    private int desconto;
    
    public Promocao(int dia, int porcentagem) {
        data = Calendar.getInstance();
        data.set(Calendar.DAY_OF_WEEK, dia);
        desconto = porcentagem;
    }
    public Promocao(int dia, int mes, int porcentagem) {
        this(dia, porcentagem);
        data.set(Calendar.MONTH, mes-1);
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    
    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
    
    
}
