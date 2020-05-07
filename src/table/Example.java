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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * Example class to learn how to use AbstractTableModel
 *
 * @author Moreno
 *
 */
public class Example extends JFrame {

    private static final long serialVersionUID = 1L; // default serialVersionUID

    /**
     * Example class, is a JFrame
     *
     */
    public Example() {
        super("Example");

        TableModelCustom myModel = new TableModelCustom();  //Create my table model
        JTable table = new JTable(myModel);                 //Create JTable
        table.setPreferredScrollableViewportSize(new Dimension(480, 70));   //Prefered size scroll

        JScrollPane scrollPane = new JScrollPane(table);    //Create scroll with table

        JButton button = new JButton("Click me");           //Create JButton
        JButton button2 = new JButton("Click me2");         //Create JButton2
        button.addActionListener(new ActionListener() {     //Listener onClick...

            @Override
            public void actionPerformed(ActionEvent e) {
                //Change data
                Object[][] data = {{"Rick", "Mourt", "Main Street", 55, true}};

                //Send data to the model
                myModel.setData(data);
            }
        });

        button2.addActionListener(new ActionListener() {        //Listener onClick...

            @Override
            public void actionPerformed(ActionEvent e) {
                //Change data
                Object[][] data = {{"Thomas", "Mourt", "Main Street 50", 55, true},
                {"Rich", "Fua", "Main Street 2", 25, false},
                {"Alan", "Poe", "Main Street 3", 12, true}};

                //Send data to the model
                myModel.setData(data);
            }
        });

        //Add components to the window
        add(button, BorderLayout.NORTH);        //Add first button
        add(scrollPane, BorderLayout.CENTER);   //Add scroll pane
        add(button2, BorderLayout.SOUTH);       //Add first button

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Model
     *
     * @author Moreno
     *
     * @see AbstractTableModel
     */
    class TableModelCustom extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        // Columns
        private String[] columnNames = {"Name", "Surname", "Direction", "Age", "Sport"};
        // Data
        private Object[][] data = {{"Peter", "Serry", "Rue....", 5, false},
        {"Paul", "Hey", "XXX", 13, true},
        {"Patriks", "--", "XXX", 26, false},
        {"Alice", "Hall", "XXX", 24, true},
        {"Mary", "Houstong", "XXX", 12, false}};

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

    public static void main(String[] args) {
        new Example();  //Create the window
    }
}
