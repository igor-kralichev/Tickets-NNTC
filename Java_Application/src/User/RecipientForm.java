package User;

import java.sql.ResultSet;
import java.sql.*;
import static Admin.Authorization.id_rec;
   
   public class RecipientForm extends javax.swing.JFrame {
   private static final long serialVersionUID = 1L;
   private ResultSet rs;
   private boolean insertStr;
   
   public RecipientForm () throws  Exception{
        
         mdbc=new Admin.MyDBConnection();
         mdbc.init();
         Connection conn=mdbc.getMyConnection();
         stmt= conn.createStatement();
        
        initComponents();
    }
     public ResultSet getResultFromRec() {
        
        ResultSet rs=null;
        String Id_rec1 = Integer.toString(id_rec);
        try{
            rs=stmt.executeQuery("Select R.FIO,R.Street,R.N_house,R.N_flat from Recipient R,Users U where R.id_recipient="+ quotate(Id_rec1));
            System.out.println(rs);
        }
        catch(SQLException e){}
        
        return rs;
        
    }     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DataPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        SendPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Учетная запись");
        setLocation(new java.awt.Point(700, 200));

        DataPanel.setLayout(new java.awt.GridLayout(4, 2, 1, 2));

        jLabel2.setText("ФИО:");
        DataPanel.add(jLabel2);
        DataPanel.add(jTextField2);

        jLabel3.setText("Улица проживания:");
        DataPanel.add(jLabel3);
        DataPanel.add(jTextField3);

        jLabel4.setText("№ дома:");
        DataPanel.add(jLabel4);

        jTextField4.setToolTipText("");
        DataPanel.add(jTextField4);

        jLabel5.setText("№ квартиры:");
        DataPanel.add(jLabel5);
        DataPanel.add(jTextField5);

        SendPanel.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("Редактировать");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        SendPanel.add(jButton2);

        jButton3.setText("Удалить");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        SendPanel.add(jButton3);

        ResultSet rs = getResultFromRec();
        jTable1.setModel(new User.Recipient(rs));
        mdbc.close(rs);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SendPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(SendPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        setBounds(0, 0, 416, 489);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Id_rec = Integer.toString(id_rec);
        String FIO=jTextField2.getText();        
        String Street=jTextField3.getText();
        String N_house=jTextField4.getText();
        String N_flat=jTextField5.getText();
       
        String EditStr="";
         
       try{
           EditStr="UPDATE Recipient set FIO=" + quotate(FIO) + "," + "Street=" + quotate(Street) + "," + "N_house=" + quotate(N_house) + "," + "N_flat=" + quotate(N_flat) + "where id_recipient=" + quotate(Id_rec);
            int done=stmt.executeUpdate(EditStr);
            getContentPane().removeAll();
           initComponents();
        
        }
       catch(SQLException e){
           System.out.println(insertStr);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     new podtverghdenie.potvergdenie().setVisible(true);
     String Id_rec = Integer.toString(id_rec);
     String DeleteStr="";
         try{ 
           DeleteStr="DELETE FROM Recipient WHERE Id_recipient=" + quotate(Id_rec);
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecipientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try{
                new RecipientForm().setVisible(true);
            }
            catch(Exception e){
            }
        });
            }
    private final Admin.MyDBConnection mdbc;
    private final java.sql.Statement stmt;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPanel;
    private javax.swing.JPanel SendPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
