
package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import ahm23.bdd.Query;
import ahm23.view.Gen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddStocks extends JPanel{
    
    public static final String TITLE = "ahm23 | Ajout stocks";
    
    public JLabel viewTitle = new JLabel("AHM23 - AJOUT STOCKS");
    
    public JLabel matiereLabel = new JLabel("Matière première :");
    public JLabel longeurLabel = new JLabel("Longeur :");
    public JLabel largeurLabel = new JLabel("Largeur :");
    public JLabel epaisseurLabel = new JLabel("Epaisseur :");
    public JLabel essenceLabel = new JLabel("Essence bois :");
    public JLabel quantiteLabel = new JLabel("Quantité :");
    
    public static JTextField matiereField = new JTextField();
    public static JTextField longeurField = new JTextField();
    public static JTextField largeurField = new JTextField();
    public static JTextField epaisseurField = new JTextField();
    public static JTextField essenceField = new JTextField();
    public static JTextField quantiteField = new JTextField();
    
    public JButton btn = new JButton("Ajouter");
    
    public Police font = new Police();
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font interFont = font.getInter(Police.PLAIN, 20);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    
    public AddStocks(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        
        // Position
        this.viewTitle.setBounds(38, 26, 646, 72);
        
        this.matiereLabel.setBounds(270, 199, 308, 24);
        this.longeurLabel.setBounds(65, 330, 96,24);
        this.largeurLabel.setBounds(430, 330, 93, 24);
        this.epaisseurLabel.setBounds(795, 330, 114, 24);
        this.essenceLabel.setBounds(251, 439, 251, 24);
        this.quantiteLabel.setBounds(610, 439, 151, 22);
        
        matiereField.setBounds(270, 226, 540, 34);
        longeurField.setBounds(65, 357, 219, 34);
        largeurField.setBounds(430, 357, 219, 34);
        epaisseurField.setBounds(795, 357, 219, 34);
        essenceField.setBounds(251, 466, 219, 34);
        quantiteField.setBounds(610, 466, 219, 34);
        
        this.btn.setBounds(470, 555, 180, 52);
        
        // Font
        this.viewTitle.setFont(this.titleFont);
        
        this.matiereLabel.setFont(this.interFont);
        this.longeurLabel.setFont(this.interFont);
        this.largeurLabel.setFont(this.interFont);
        this.epaisseurLabel.setFont(this.interFont);
        this.essenceLabel.setFont(this.interFont);
        this.quantiteLabel.setFont(this.interFont);
        
        this.btn.setFont(this.btnFont);
        
        // btn and Field style
        matiereField.setBorder(new LineBorder(Color.BLACK, 1));
        longeurField.setBorder(new LineBorder(Color.BLACK, 1));
        largeurField.setBorder(new LineBorder(Color.BLACK, 1));
        epaisseurField.setBorder(new LineBorder(Color.BLACK, 1));
        essenceField.setBorder(new LineBorder(Color.BLACK, 1));
        quantiteField.setBorder(new LineBorder(Color.BLACK, 1));
        
        
        this.btn.setBackground(Colorize.PRIMARY_RED);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        this.btn.setOpaque(true);
        
        this.viewTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Events
        
        this.btn.addMouseListener(new MouseAdapter(){
            
            public void mouseClicked(MouseEvent e){
                Query bdd = new Query();
                bdd.addStocks(matiereField.getText(), longeurField.getText(), largeurField.getText(), epaisseurField.getText(), essenceField.getText(), quantiteField.getText());
                matiereField.setText("");
                longeurField.setText("");
                largeurField.setText("");
                epaisseurField.setText("");
                essenceField.setText("");
                quantiteField.setText("");
            }
            
        });
        this.viewTitle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new HomeView(), HomeView.TITLE);
            }
        });
        
        // Ajout
        this.add(this.viewTitle);
        this.add(this.matiereLabel);
        this.add(this.longeurLabel);
        this.add(this.largeurLabel);
        this.add(this.epaisseurLabel);
        this.add(this.essenceLabel);
        this.add(this.quantiteLabel);
        this.add(this.btn);
        this.add(matiereField);
        this.add(longeurField);
        this.add(largeurField);
        this.add(epaisseurField); 
        this.add(essenceField);
        this.add(quantiteField);
        
    }
}
