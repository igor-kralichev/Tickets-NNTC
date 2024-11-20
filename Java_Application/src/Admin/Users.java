/*
 * CarTableModel.java
 *
 * Created on 2005/01/17, 15:31
 */

package Admin;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author emsh_isip_22
 */
public class Users extends AbstractTableModel {
    
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "FIO","Login","Password","Role"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel
     * @param rs */
    public Users(ResultSet rs) {
      
      ResultSets=new ArrayList<>();  
    
      try{
        while(rs.next()){
      
              String[] row={
            rs.getString("FIO"),rs.getString("Login"),rs.getString("Password"),rs.getString("Role")
          
            };
            boolean add = ResultSets.add(row);
      
         }   
      }
      catch(SQLException e){
          System.out.println("Exception in Praktika2");
            }
        
    }
   
    @Override
    public Object getValueAt(int rowindex, int columnindex) {
        
       String[] row=ResultSets.get(rowindex);
       return row[columnindex];
        
    }

    @Override
    public int getRowCount() {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() {
        return colnum;
    }

    /**
     *
     * @param param
     * @return
     */
    @Override
    public String getColumnName(int param) {

       return colNames[param];
    }
    
}
