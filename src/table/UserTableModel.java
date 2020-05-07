/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

/**
 *
 * @author asksoft
 */
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -7852567715605820609L;
    private List<ticket> userData = new ArrayList<ticket>();
    private String[] columnNames = {"Sr.No", "Ticket","Amount","Draw Id","Draw Time","Date"};

    public UserTableModel() {
    }

    public UserTableModel(List<ticket> userData) {
        this.userData = userData;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return userData.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object userAttribute = null;
        ticket userObject = userData.get(row);
        switch (column) {
            case 0:
                userAttribute = userObject.getSrno();
                break;
            case 1:
                userAttribute = userObject.getTicket();
                break;
            case 2:
                userAttribute = userObject.getAmount();
                break;
            case 3:
                userAttribute = userObject.getDrawid();
                break;
            case 4:
                userAttribute = userObject.getDrawtime();
                break;
            case 5:
                userAttribute = userObject.getDate();
                break;
            default:
                break;
        }
        return userAttribute;
    }

    public void addUser(ticket user) {
        userData.add(user);
        fireTableDataChanged();
    }
}
