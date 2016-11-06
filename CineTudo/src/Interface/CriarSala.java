/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joao
 */
public class CriarSala extends javax.swing.JInternalFrame {

    /**
     * Creates new form CriarSala
     */
    public CriarSala() {
        initComponents();
        fillCb();
/*
            for (int i=5;i<7;i++){
            cinetudo.Cinema c1 = new cinetudo.Cinema(i);
            c1.pesquisar(i);
            JOptionPane.showMessageDialog(null,c1.getNome());
            CB.insertItemAt(c1.getNome(), 0);
        }
        
*/
    }
    
    public void fillCb()
    {
        ArrayList<cinetudo.Cinema> c2 = new ArrayList<>();
        cinetudo.Cinema c1 = new cinetudo.Cinema();
        c2 = c1.pesquisarNomes();
        for (cinetudo.Cinema nc : c2)
        {
            nC.insertItemAt(nc.getNome(), 0);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cap = new javax.swing.JTextField();
        nC = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tipoSala = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Criar sala");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cinema:");

        jLabel2.setText("Capacidade:");

        jLabel4.setText("Tipo:");

        tipoSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2D", "3D" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nC, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoSala, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tipoSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //String cb = CB.getSelectedItem().toString();
        String nis;
        cinetudo.Cinema c = new cinetudo.Cinema();
        if(tipoSala.getSelectedItem().toString().equals("2D")){
            nis = nC.getSelectedItem().toString();
            c.pesquisar(nis);
            int i = c.getI();
          //  int i = Integer.parseInt(cod.getText());
            int capacidade = Integer.parseInt(cap.getText());
          //  float pre = Float.parseFloat(preco.getText());
            cinetudo.Sala s = new cinetudo.Sala2D(capacidade);
            s.setCineCod(i);
            s.setTipoSala("2D");
            int resposta = s.incluir();
            JOptionPane.showMessageDialog(null,"Sucesso");
        }
        else if (tipoSala.getSelectedItem().toString().equals("3D"))
        {
            nis = nC.getSelectedItem().toString();
            c.pesquisar(nis);
            int i = c.getI();
            //int i = Integer.parseInt(cod.getText());
            int capacidade = Integer.parseInt(cap.getText());
          //  float pre = Float.parseFloat(preco.getText());
            cinetudo.Sala s = new cinetudo.Sala3D(capacidade);
            s.setCineCod(i);
            s.setTipoSala("3D");
            int resposta = s.incluir();
            JOptionPane.showMessageDialog(null,"Sucesso");
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cap;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> nC;
    private javax.swing.JComboBox<String> tipoSala;
    // End of variables declaration//GEN-END:variables
}