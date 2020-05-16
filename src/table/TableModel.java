/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.Observable;
import java.util.Observer;
import javax.swing.table.AbstractTableModel;
import org.json.simple.JSONObject;

/**
 *
 * @author asksoft
 */
public class TableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    // Columns
    private String[] columnNames = {"Sr.No", "Ticket", "Amount", "Draw Id", "Draw Time", "Date"};
    // Data
    private Object[][] data;
//    = {{"Peter", "Serry", "Rue....", 5, false},
//    {"Paul", "Hey", "XXX", 13, true},
//    {"Patriks", "--", "XXX", 26, false},
//    {"Alice", "Hall", "XXX", 24, true},
//    {"Mary", "Houstong", "XXX", 12, false}};

    TableModel(Object data) {
        this.data = (Object[][]) data;
    }

    

    /**
     * This method receives the new data vector, and update the table
     *
     * @param data with new values
     */
    public void setData(Object[][] data) {
        this.data = data;       //Save data..
        fireTableDataChanged(); //Update table
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);

    }

}
