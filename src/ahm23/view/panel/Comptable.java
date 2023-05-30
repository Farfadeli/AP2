package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import ahm23.bdd.Query;
import ahm23.view.Gen;
import ahm23.view.panel.scrollPan.Scrollable;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Comptable extends JPanel{
    
    public static final String TITLE = "ahm23 | Comptabilité";
    
    public JLabel viewTitle = new JLabel("AHM23 - Comptable");
    public static Query bdd = new Query();
    
    public static JTextField paletteField = new JTextField();
    public JButton btn = new JButton("RECHERCHER");
    
    public JPanel headerTab = new JPanel();
    public static JScrollPane scroll  = new JScrollPane(new Scrollable(3, bdd.getPalette()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public JLabel designationLabel = new JLabel("Designation");
    public JLabel coutRevientLabel = new JLabel("Cout revient");
    public JLabel quantiteLabel = new JLabel("Quantite");
    
    public static JLabel total = new JLabel("TOTAL :   "+ bdd.getTotal() +" euros");
    
    public Police font = new Police();
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    public Font headerFont = font.getImpact(Police.BOLD, 24);
    
    
    public Comptable(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        
        this.viewTitle.setBounds(32, 18, 595, 69);
        paletteField.setBounds(158, 128, 764, 41);
        this.btn.setBounds(471, 191, 180, 37);
        this.headerTab.setBounds(143, 312, 793, 48);
        scroll.setBounds(143,360,793,266);
        total.setBounds(665,650,500,24);
        
        this.designationLabel.setBounds(200-143, 324-312, 174, 25);
        this.coutRevientLabel.setBounds(725-143, 324-312, 174, 25);
        this.quantiteLabel.setBounds(500-143, 324-312,174,25);
        
        
        paletteField.setBorder(new LineBorder(Color.BLACK, 1));
        
        this.btn.setBackground(Colorize.PRIMARY_RED);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        this.btn.setOpaque(true);
        
        this.headerTab.setLayout(null);
        this.headerTab.setBackground(Colorize.PRIMARY_RED);
        
        this.viewTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.viewTitle.setFont(this.titleFont);
        this.btn.setFont(this.btnFont);
        this.designationLabel.setFont(this.headerFont);
        this.coutRevientLabel.setFont(this.headerFont);
        this.quantiteLabel.setFont(this.headerFont);
        total.setFont(this.btnFont);
        
        
        this.viewTitle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new HomeView(), HomeView.TITLE);
            }
        });
        this.btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                scroll.setViewportView(new Scrollable(3, bdd.getPalette(paletteField.getText())));
                total.setText("TOTAL :   " + bdd.getTotal(paletteField.getText()) + " euros");
            }
        });
        
        this.add(this.viewTitle);
        this.add(paletteField);
        this.add(this.btn);
        this.add(this.headerTab);
        this.add(scroll);
        this.add(total);
        
        this.headerTab.add(this.designationLabel);
        this.headerTab.add(this.coutRevientLabel);
        this.headerTab.add(this.quantiteLabel);
    }
    
}
