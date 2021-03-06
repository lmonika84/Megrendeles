/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.IModell;
import model.Szemely;

/**
 *
 * @author monika.lohr
 */
public class SzemelyekDialog extends javax.swing.JDialog {

private IModell model;
private Frame parent;

    public SzemelyekDialog(java.awt.Frame parent,IModell model) {
        super(parent, true);
        this.parent=parent;
        this. model=model;
        initComponents();
        setLocationRelativeTo(parent);
        setTitle("Személyek listája");
        refreshJList(); 
//    try {
//        List<Szemely> szemelyek=model.getSzemelyek();
//        lstSzemelyek.setListData(szemelyek.toArray());
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(rootPane, ex, "Hibás az adatbázis", JOptionPane.ERROR_MESSAGE );
//    }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstSzemelyek = new javax.swing.JList();
        btnUj = new javax.swing.JButton();
        btnSzerkeszt = new javax.swing.JButton();
        btnTorol = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstSzemelyek.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstSzemelyek);

        btnUj.setText("Új");
        btnUj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjActionPerformed(evt);
            }
        });

        btnSzerkeszt.setText("Szerkeszt");
        btnSzerkeszt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSzerkesztActionPerformed(evt);
            }
        });

        btnTorol.setText("Töröl");
        btnTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTorolActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(btnUj, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSzerkeszt, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnTorol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUj, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSzerkeszt)
                        .addGap(18, 18, 18)
                        .addComponent(btnTorol)
                        .addGap(58, 58, 58)
                        .addComponent(btnOK)
                        .addGap(0, 103, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjActionPerformed
       SzemelyAdatokDialog szad= new SzemelyAdatokDialog(parent,true, null);
       szad.setVisible(true);
       
       if(szad.isMentes()){
           Szemely ujszemely= szad.getSzemely();
           try {
               model.addSzemely(ujszemely);
               refreshJList(); 
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(rootPane, ex,"Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
           }
       }
    }//GEN-LAST:event_btnUjActionPerformed

    private void btnSzerkesztActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSzerkesztActionPerformed
        Szemely szemely= (Szemely) lstSzemelyek.getSelectedValue();
        
        if(szemely!=null){
        SzemelyAdatokDialog szad= new SzemelyAdatokDialog(parent, true, szemely);
        szad.setVisible(true); 
        
        if(szad.isMentes()){
            try {
                model.updateSzemely(szemely);
                int index=lstSzemelyek.getSelectedIndex();
                refreshJList();
                lstSzemelyek.setSelectedIndex(index);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex, "Hibás az adatbázis", JOptionPane.ERROR_MESSAGE );
            }
        }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Válassz ki valakit a listából", "Nincs kiválasztva senki", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSzerkesztActionPerformed

    private void btnTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTorolActionPerformed
     Szemely szemely= (Szemely) lstSzemelyek.getSelectedValue();
        
        if(szemely!=null){
           int valasz= JOptionPane.showConfirmDialog(parent, "Biztos hogy törölni akarod"+szemely.getNev()+"-t?", "Törlés megerősítés", JOptionPane.YES_NO_OPTION);  
            if(valasz==JOptionPane.YES_OPTION)
                try {
                    model.removeSzemely(szemely);
           } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex,"Adatbázis hiba", JOptionPane.ERROR_MESSAGE);
           }
            refreshJList();
                 
        }
       else{
            JOptionPane.showMessageDialog(rootPane, "Válassz ki valakit a listából", "Nincs kiválasztva senki", JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_btnTorolActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    public void refreshJList(){
         try {
        List<Szemely> szemelyek=model.getSzemelyek();
        lstSzemelyek.setListData(szemelyek.toArray());
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(rootPane, ex, "Hibás az adatbázis", JOptionPane.ERROR_MESSAGE );
    }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSzerkeszt;
    private javax.swing.JButton btnTorol;
    private javax.swing.JButton btnUj;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstSzemelyek;
    // End of variables declaration//GEN-END:variables
}
