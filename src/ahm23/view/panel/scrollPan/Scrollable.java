
package ahm23.view.panel.scrollPan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Scrollable extends JTable{
    
    
    public Scrollable(){
        String[] columnHeaders = {"Name", "Age", "Gender"};
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
        this.setModel(model);
        this.setTableHeader(null);
    }
    
    public Scrollable(ArrayList<Object[]> data){
        String[] ColumnHeaders = {"libelle", "M3", "alerte"};
        DefaultTableModel model = new DefaultTableModel(ColumnHeaders, 0);
        for(Object[] elem : data){
            model.addRow(elem);
        }
        this.setTableHeader(null);
        this.setModel(model);
    }
    
    public Scrollable(int nbCol,ArrayList<Object[]> data){
        String[] columnHeaders = createHeader(nbCol);
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
        for(Object[] elem: data){
            model.addRow(elem);
        }
        
        this.setTableHeader(null);
        this.setModel(model);
    }
    
    public String[] createHeader(int nbCol){
        String elem[] = new String[nbCol];
        for(int e = 0; e != nbCol; e++){
            elem[e] = String.format("%d", e);
        }
        return elem;
    }
}
