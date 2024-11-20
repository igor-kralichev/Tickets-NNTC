/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.sql.ResultSet;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author student
 */
public class UsersForm extends javax.swing.JFrame {

    private ResultSet rs;
    private boolean insertStr;

    /**
     * Creates new form SubscribeForm
     * @throws java.lang.Exception
     */
    public UsersForm () throws  Exception{
        
         mdbc=new MyDBConnection();
         mdbc.init();
         Connection conn=mdbc.getMyConnection();
         stmt= conn.createStatement();
        
        initComponents();
    }
     public ResultSet getResultFromUSA() {
        
        ResultSet rs=null;
        
        try{
            rs=stmt.executeQuery("Select * from Users");
        
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
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Пользователи");
        setLocation(new java.awt.Point(700, 200));

        jPanel1.setLayout(new java.awt.GridLayout(4, 2, 1, 2));

        jLabel1.setText("ФИО:");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField1);

        jLabel2.setText("Логин:");
        jPanel1.add(jLabel2);
        jPanel1.add(jTextField2);

        jLabel3.setText("Пароль:");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField3);

        jLabel4.setText("Роль:");
        jPanel1.add(jLabel4);

        jTextField4.setSelectionColor(new java.awt.Color(238, 238, 238));
        jPanel1.add(jTextField4);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButton3.setText("Удалить");
        jButton3.setAlignmentY(5.0F);
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setText("Найти");
        jButton4.setAlignmentX(1.0F);
        jButton4.setAlignmentY(5.0F);
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setPreferredSize(new java.awt.Dimension(15, 25));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        ResultSet rs = getResultFromUSA();
        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new Admin.Users(rs));
        mdbc.close(rs);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String FIO=jTextField1.getText();
        String Login=jTextField2.getText();        
        String Password=jTextField3.getText();
        String Role=jTextField4.getText();
        
        String insertStr="";
        
        try{
            
            insertStr="insert into Users (FIO, Login, Password, Role) values('"
                    +FIO+"','"
                    +Login+"','"
                    +Password+"','"
                    +Role
                    +"')";
            
            int done=stmt.executeUpdate(insertStr);
            getContentPane().removeAll();
            initComponents();
        
        }
        catch(SQLException e){
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String Find=jTextField1.getText();
        Users table = (Users)jTable1.getModel();
        TableRowSorter <Users> tr = new TableRowSorter <Users>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(Find,0));
        jTextField1.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String FIO=jTextField1.getText();

        String DeleteStr="";
        try{

            DeleteStr="DELETE FROM Users WHERE FIO=" + quotate(FIO);

            int done=stmt.executeUpdate(DeleteStr);
            getContentPane().removeAll();
            initComponents();

        }
        catch(SQLException e){
        }

    }//GEN-LAST:event_jButton3ActionPerformed
 public String quotate(String content){
    
        return "'"+content+"'";
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
        try{
                new UsersForm().setVisible(true);
            }
            catch(Exception e){
            }
        });
    }
private final MyDBConnection mdbc;
private final java.sql.Statement stmt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
