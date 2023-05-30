
package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import ahm23.bdd.Query;
import ahm23.view.Gen;
import ahm23.view.panel.scrollPan.Scrollable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.LineBorder;

public class Gestion extends JPanel{
       
    public static final String TITLE = "ahm23 | Gestion Stock";
    
    public JLabel viewTitle = new JLabel("AHM23 - Vision Stocks");
    
    public static JTextField searchField = new JTextField();
    public static JScrollPane scroll = new JScrollPane(new Scrollable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public JPanel colTitle = new JPanel();
    public JLabel libelleLab = new JLabel("Libelle");
    public JLabel mLab = new JLabel("M3");
    public JLabel alertLab = new JLabel("Alerte");
    public JButton btn = new JButton("RECHERCHER");
    
    public Police font = new Police();
    
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font impactFont = font.getImpact(Police.BOLD, 20);
    public Font colFont = font.getImpact(Police.PLAIN, 24);
    
    public Gestion(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        this.colTitle.setLayout(null);
        
        this.viewTitle.setBounds(41 , 13 , 642 , 66);
        searchField.setBounds(158 , 123 , 764 , 41);
        this.btn.setBounds(471 , 194 , 148, 37);
        this.colTitle.setBounds(163, 303, 793, 48);
        scroll.setBounds(163 , 351 , 793 , 321);
        this.libelleLab.setBounds(244-163, 315-303 ,118, 25);
        this.mLab.setBounds(531-163, 315-303 ,118, 25);
        this.alertLab.setBounds(760-163, 315-303 ,118, 25);
        
        this.btn.setBackground(Colorize.PRIMARY_RED);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        this.btn.setOpaque(true);
        
        searchField.setBorder(new LineBorder(Color.BLACK, 1));
        this.colTitle.setBackground(Colorize.PRIMARY_RED);
        
        this.viewTitle.setFont(this.titleFont);
        this.btn.setFont(this.impactFont);
        this.libelleLab.setFont(this.impactFont);
        this.mLab.setFont(this.impactFont);
        this.alertLab.setFont(this.impactFont);
        
        
        this.viewTitle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new HomeView(), HomeView.TITLE);
            }
        });
        
        this.btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Query bdd = new Query();
                scroll.setViewportView(new Scrollable(bdd.getStock(searchField.getText())));
            }
        });
        
        this.colTitle.add(this.libelleLab);
        this.colTitle.add(this.mLab);
        this.colTitle.add(this.alertLab);
        
        this.add(this.viewTitle);
        this.add(searchField);
        this.add(this.btn);
        this.add(this.colTitle);
        this.add(scroll);
    }
}
