package Admin;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author emsh_isip_22
 */
public class Delivery extends AbstractTableModel {

    private int colnum = 3;
    private int rownum;
    private String[] colNames = {
        "id_Delivery", "Date_Delivery", "id_sub"
    };
    private ArrayList<String[]> ResultSets;

    /**
     * Creates a new instance of FoodTableModel
     *
     * @param rs
     */
    public Delivery(ResultSet rs) {

        ResultSets = new ArrayList<>();

        try {
            while (rs.next()) {

                String[] row = {
                    rs.getString("id_Delivery"), rs.getString("Date_Delivery"), rs.getString("id_sub")

                };
                boolean add = ResultSets.add(row);

            }
        } catch (SQLException e) {
            System.out.println("Exception in Praktika2");
        }

    }

    @Override
    public Object getValueAt(int rowindex, int columnindex) {

        String[] row = ResultSets.get(rowindex);
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
