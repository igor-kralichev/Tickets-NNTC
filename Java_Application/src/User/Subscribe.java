package User;

import Admin.*;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author emsh_isip_22
 */
public class Subscribe extends AbstractTableModel {
    
    private int colnum=4;
    private int rownum;
    private String[] colNames={
        "Name_Ed","Date_sub","Period_sub","Cena"
    };
    private  ArrayList<String[]> ResultSets;
    
    /** Creates a new instance of FoodTableModel
     * @param rs */
    public Subscribe(ResultSet rs) {
      
      ResultSets=new ArrayList<>();  
    
      try{
        while(rs.next()){
      
              String[] row={
            rs.getString("Name_Ed"),rs.getString("Date_sub"),rs.getString("Period_sub"),rs.getString("Cena")
          
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