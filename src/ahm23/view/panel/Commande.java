package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import ahm23.bdd.Query;
import javax.swing.JPanel;
import ahm23.view.Gen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Commande extends JPanel{
    
    public static final String TITLE = "AHM23 | Ajout ligne commande";
    
    public JLabel viewTitle = new JLabel("AHM23 - Ajout ligne commande");
    public JLabel numLabel = new JLabel("Numéro de commande :");
    public JLabel nomLabel = new JLabel("nom palette :");
    public JLabel qteLabel = new JLabel("Quantité :");
    public JLabel prixLabel = new JLabel("Prix :");
    
    public static JTextField numField = new JTextField();
    public static JTextField nomField = new JTextField();
    public static JTextField qteField = new JTextField();
    public static JTextField prixField = new JTextField();
    
    public JButton btn = new JButton("+ AJOUTER");
    
    public Police font = new Police();
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font labelFont = font.getInter(Police.PLAIN, 20);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    
    public Commande(){
        this.setLayout(null);
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        
        this.viewTitle.setBounds(32,31,998,82);
        this.numLabel.setBounds(159, 211, 301, 29);
        this.nomLabel.setBounds(598, 211, 301, 29);
        this.qteLabel.setBounds(159, 406, 301, 29);
        this.prixLabel.setBounds(598,406,301, 29);
        
        numField.setBounds(159, 240, 301, 56);
        nomField.setBounds(598, 240, 301, 56);
        qteField.setBounds(159, 435, 301, 56);
        prixField.setBounds(598, 435, 301, 56);
        
        this.btn.setBounds(446, 578, 170, 59);
        
        this.viewTitle.setFont(this.titleFont);
        this.numLabel.setFont(this.labelFont);
        this.nomLabel.setFont(this.labelFont);
        this.qteLabel.setFont(this.labelFont);
        this.prixLabel.setFont(this.labelFont);
        this.btn.setFont(this.btnFont);
        
        this.btn.setBackground(Colorize.PRIMARY_GREEN);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        this.btn.setOpaque(true);
        
        numField.setBorder(new LineBorder(Color.BLACK, 1));
        nomField.setBorder(new LineBorder(Color.BLACK, 1));
        qteField.setBorder(new LineBorder(Color.BLACK, 1));
        prixField.setBorder(new LineBorder(Color.BLACK, 1));
        
        
        this.btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Query bdd = new Query();
                bdd.addCommande(Integer.parseInt(numField.getText()), nomField.getText(), Integer.parseInt(qteField.getText()), Float.parseFloat(prixField.getText()));
            }
        });
        
        this.add(this.viewTitle);
        this.add(this.numLabel);
        this.add(this.nomLabel);
        this.add(this.qteLabel);
        this.add(this.prixLabel);
        this.add(this.btn);
        
        this.add(numField);
        this.add(nomField);
        this.add(qteField);
        this.add(prixField);
    }
}
