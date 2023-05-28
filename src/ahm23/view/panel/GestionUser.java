
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class GestionUser extends JPanel{
    
    public static final String TITLE = "ahm23 | Gestion utilisateurs";
    public Query bdd = new Query();
    
    public JLabel viewTitle = new JLabel("AHM23 - Gestion utilisateurs");
    
    public static JTextField searchBar = new JTextField();
    public JButton btnAjout = new JButton("+ AJOUTER");
    public JButton btnSearch = new JButton("RECHERCHER");
    
    public JPanel headerTab = new JPanel();
    public JLabel headerNom = new JLabel("NOM", SwingConstants.CENTER);
    public JLabel headerPrenom = new JLabel("PRENOM", SwingConstants.CENTER);
    public JLabel headerMail = new JLabel("MAIL", SwingConstants.CENTER);
    
    public JScrollPane scroll = new JScrollPane(new Scrollable(bdd.getUsers()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    
    public Police font = new Police();
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    public Font headerFont = font.getImpact(Police.BOLD, 24);
    
    public GestionUser(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        this.headerTab.setLayout(null);
        
        // Bounds
        this.viewTitle.setBounds(37,31,780,71);
        this.btnAjout.setBounds(158,207,150,37);
        this.btnSearch.setBounds(784, 207, 150, 37);
        searchBar.setBounds(158, 148, 776,41);
        this.headerTab.setBounds(143, 290, 793, 48);
        scroll.setBounds(143, 338, 793, 338);
        this.headerNom.setBounds(183-143, 302-290, 174,25);
        this.headerPrenom.setBounds(453-143,302-290,174,25);
        this.headerMail.setBounds(725-143,302-290,174,25);
        
        // Font
        this.viewTitle.setFont(this.titleFont);
        this.btnAjout.setFont(this.btnFont);
        this.btnSearch.setFont(this.btnFont);
        this.headerNom.setFont(this.headerFont);
        this.headerPrenom.setFont(this.headerFont);
        this.headerMail.setFont(this.headerFont);
        
        // btn and input Customization
        this.btnAjout.setBackground(Colorize.PRIMARY_GREEN);
        this.btnAjout.setFocusPainted(false);
        this.btnAjout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnAjout.setBorderPainted(false);
        
        this.btnSearch.setBackground(Colorize.PRIMARY_RED);
        this.btnSearch.setFocusPainted(false);
        this.btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btnSearch.setBorderPainted(false);
        
        searchBar.setBorder(new LineBorder(Color.BLACK, 1));
        this.headerTab.setBackground(Colorize.PRIMARY_RED);
        
        // Event
        
        this.viewTitle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new HomeView(), HomeView.TITLE);
            }
        });
        
        this.btnSearch.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                scroll.setViewportView(new Scrollable(bdd.getUsers(searchBar.getText())));
            }
        });
        
        this.btnAjout.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                new AddUser();
            }
        });
        
        
        // AJout
        
        this.add(this.viewTitle);
        this.add(searchBar);
        this.add(this.btnAjout);
        this.add(this.btnSearch);
        this.add(this.headerTab);
        this.add(scroll);
        
        this.headerTab.add(this.headerNom);
        this.headerTab.add(this.headerPrenom);
        this.headerTab.add(this.headerMail);
    }
    
}
