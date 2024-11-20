package podtverghdenie;

import static Admin.Authorization.id_rec;
import static User.podschetForm.mes;
import static User.podschetForm.pr;
import static User.podschetForm.st;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

   public class potvergdenie2 extends javax.swing.JFrame {
   private static final long serialVersionUID = 1L;
   private ResultSet rs1;
   private ResultSet rs2;
   private ResultSet rs3;

   
    public potvergdenie2() throws SQLException {
         mdbc=new Admin.MyDBConnection();
         mdbc.init();
         Connection conn=mdbc.getMyConnection();
         stmt= conn.createStatement();
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Добавление");

        jButton1.setText("НЕТ");
        jButton1.setActionCommand("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ДА");
        jButton2.setActionCommand("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Вы уверены, что хотите оформить подписку?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
           new User.podschetForm().setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(potvergdenie2.class.getName()).log(Level.SEVERE, null, ex);
       }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
   @SuppressWarnings("empty-statement")
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String zap1 = "";
        String zap2 = "";
        String zap3 = "";    
        String insertStr="";
        String count="";
        
        try{
        zap1 = "Select CURDATE()";
        System.out.println(zap1);
        rs1 = stmt.executeQuery(zap1);
        String Date_Sub="";
        while (rs1.next()) {
                Date_Sub = (rs1.getString("CURDATE()"));
                System.out.println(Date_Sub);
            }
        zap2 = "Select Index_Ed From Editions where Name_Ed=" + "'" + pr + "'";
        System.out.println(zap2);
        rs2 = stmt.executeQuery(zap2);
        String Index_Ed="";
        while (rs2.next()) {
                Index_Ed = rs2.getString("Index_Ed");
                System.out.println(Index_Ed);
            }     
        zap3 = "Select ADDDATE(CURDATE() + 0" + ",Interval" + " " + mes + " " + "Month) AS Q";
        System.out.println(zap3);
        rs3 = stmt.executeQuery(zap3);
        String Period_Sub="";
        while (rs3.next()) {
                Period_Sub =(rs3.getString("Q"));
                System.out.println(Period_Sub);
                
            }
        
        insertStr="insert into Subscribe (Name_Edition, id_recipient, Index_Ed, Date_sub, Period_sub, Cena) values('"                    
                    +pr+"','"
                    +id_rec+"','"
                    +Index_Ed+"','"
                    +Date_Sub+"','"
                    +Period_Sub+"','"
                    +st
                    +"')";
        
            count="UPDATE Editions SET cnt = cnt + 1 Where Editions.Index_Ed = "+quotate(Index_Ed);
            System.out.println(insertStr);
            System.out.println(count);
            this.dispose();    
            int done4=stmt.executeUpdate(count);
            int done=stmt.executeUpdate(insertStr);
            getContentPane().removeAll();
            initComponents();
            }
        catch(SQLException e){
            System.out.println("Ошибка с сервером");
        }       
    }//GEN-LAST:event_jButton2ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new potvergdenie2().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(potvergdenie2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    public String quotate(String content){
    
        return "'"+content+"'";
    }
    private final Admin.MyDBConnection mdbc;
    private final java.sql.Statement stmt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
