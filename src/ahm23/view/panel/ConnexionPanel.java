package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import ahm23.User;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ConnexionPanel extends JPanel{
     
    
    // TITLE of the view
    public static final String TITLE = "AHM23 | Connexion";
    
    // Components
    
    // Labels
    public JLabel viewTitle = new JLabel("Connexion");
    public JLabel idLabel = new JLabel("Identifiant : ");
    public JLabel passLabel = new JLabel("Mot de passe : ");
    
    // Fields
    public static JTextField idField = new JTextField();
    public static JPasswordField passField = new JPasswordField();
    
    // Button
    public JButton button = new JButton("Connexion");
    
    // Init my Font
    public Police font = new Police();
    public Font connectFontInter = font.getInter(Police.PLAIN, 14);
    public Font titleFont = font.getImpact(Police.BOLD,  64);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    
    // create JPanel Constructor
    public ConnexionPanel(){
        this.setLayout(null);
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        
        // set Font
        this.viewTitle.setFont(font.getImpact(Police.BOLD, 64));
        this.button.setFont(this.btnFont);
        this.idLabel.setFont(this.connectFontInter);
        this.passLabel.setFont(this.connectFontInter);
        
        // Components Pos
        this.viewTitle.setBounds(394, 25, 293, 71);
        this.idLabel.setBounds(350, 227, 134, 18);
        idField.setBounds(350, 258, 380, 40);
        this.passLabel.setBounds(350, 351, 134, 18);
        passField.setBounds(350, 382, 380, 40);
        this.button.setBounds(470, 564, 140, 52);
        
        // Custom Colors
        this.button.setBackground(Colorize.PRIMARY_RED);
        this.button.setFocusPainted(false);
        this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.button.setBorderPainted(false);
        this.setOpaque(false);
        
        // Custom input
        idField.setBorder(new LineBorder(Color.BLACK, 1));
        passField.setBorder(new LineBorder(Color.BLACK, 1));
        
        // Events
        this.button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Query quer = new Query();
                User user = quer.connexion(idField.getText(), passField.getText());
                if(user != null){
                    Gen.changeFrame(new HomeView(), HomeView.TITLE);
                }
                
            }
        
        });
       
        
        // Components add
        this.add(this.viewTitle);
        this.add(this.idLabel);
        this.add(this.passLabel);
        this.add(idField);
        this.add(passField);
        this.add(this.button);
    }
    
}
