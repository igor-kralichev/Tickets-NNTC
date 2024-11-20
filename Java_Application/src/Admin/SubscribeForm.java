
package Admin;

import java.sql.ResultSet;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class SubscribeForm extends javax.swing.JFrame {

    private ResultSet rs;
    private boolean insertStr;

    public SubscribeForm () throws  Exception{
        
         mdbc=new MyDBConnection();
         mdbc.init();
         Connection conn=mdbc.getMyConnection();
         stmt= conn.createStatement();
        
        initComponents();
    }
     public ResultSet getResultFromSub() {
        
        ResultSet rs=null;
        
        try{
            rs=stmt.executeQuery("Select * from Subscribe");
        
        }
        catch(SQLException e){}
        
        return rs;
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Подписка");
        setLocation(new java.awt.Point(700, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(5, 2, 1, 2));

        jLabel1.setText("id подписки:");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);

        jLabel2.setText("id подписчика:");
        jPanel1.add(jLabel2);

        String xya="";
        xya = "select id_recipient from Recipient";
        try{
            rs = stmt.executeQuery(xya);
            while (rs.next()){
                String a=rs.getString("id_recipient");
                jComboBox1.addItem(a);
                a="";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        mdbc.close(rs);
        jPanel1.add(jComboBox1);

        jLabel3.setText("Индекс издания:");
        jPanel1.add(jLabel3);

        String xye="";
        xye = "select Index_Ed from Editions";
        try{
            rs = stmt.executeQuery(xye);
            while (rs.next()){
                String a=rs.getString("Index_Ed");
                jComboBox2.addItem(a);
                a="";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        mdbc.close(rs);
        jPanel1.add(jComboBox2);

        jLabel4.setText("Дата подписки:");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextField2);

        jLabel5.setText("Срок подписки(месяцев):");
        jPanel1.add(jLabel5);
        jPanel1.add(jTextField3);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Редактировать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Удалить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setText("Найти");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        ResultSet rs = getResultFromSub();
        jTable1.setModel(new Admin.Subscribe(rs));
        mdbc.close(rs);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id_sub=jTextField1.getText();
        String id_rec=(String)jComboBox1.getSelectedItem();        
        String index=(String)jComboBox2.getSelectedItem();
        String date=jTextField2.getText();       
        String period=jTextField3.getText();
        
        String insertStr="";
        
        try{
            
            insertStr="insert into Subscribe (id_sub, id_recipient, Index_Ed, Date_sub, Period_sub) values('"
                    +id_sub+"','"
                    +id_rec+"','"
                    +index+"','"
                    +date+"','"
                    +period
                    +"')";
            
            int done=stmt.executeUpdate(insertStr);
            getContentPane().removeAll();
            initComponents();
        
        }
        catch(SQLException e){
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id_sub=jTextField1.getText();
        String id_rec=(String)jComboBox1.getSelectedItem();        
        String index=(String)jComboBox2.getSelectedItem();
        String date=jTextField2.getText();
        String period=jTextField3.getText();
        String EditStr="";
         
        try{
            
            EditStr="UPDATE Subscribe set id_recipient" + quotate(id_rec) + "," + "Index_ed=" + quotate(index) + "," + "Date_sub=" + quotate(date) + "," + "Period_sub=" + quotate(period) + "where id_sub=" + quotate(id_sub);
            
            int done=stmt.executeUpdate(EditStr);
            getContentPane().removeAll();
            initComponents();
        }
        catch(SQLException e){
            System.out.println(insertStr);
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id_sub=jTextField1.getText();
                
        String DeleteStr="";
          try{
            
            DeleteStr="DELETE FROM Subscribe WHERE id_sub=" + quotate(id_sub);
                    
            int done=stmt.executeUpdate(DeleteStr);
            getContentPane().removeAll();
            initComponents();
        
        }
        catch(SQLException e){
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
if(Authorization.Test==2) {
            this.jButton1.setVisible(false);
            this.jButton2.setVisible(false);
            this.jButton3.setVisible(false);
        };       
    }//GEN-LAST:event_formWindowActivated

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String Find=jTextField1.getText();
        Subscribe table = (Subscribe)jTable1.getModel();
        TableRowSorter <Subscribe> tr = new TableRowSorter <Subscribe>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(Find,0));
        jTextField1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed
public String quotate(String content){
        return "'"+content+"'";
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubscribeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try{
                new SubscribeForm().setVisible(true);
            }
            catch(Exception e){
            }
        });
    }
private final MyDBConnection mdbc;
private final java.sql.Statement stmt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
