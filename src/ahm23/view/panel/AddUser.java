
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddUser extends JPanel{
    
    public JLabel viewtitle = new JLabel("AHM23 - Ajout utilisateur");
    public static String[] options = {"Utilisateurs", "Comptable", "Administrateur"};
    
    public JLabel prenomLab = new JLabel("prenom :");
    public JLabel nomLab = new JLabel("nom :");
    public JLabel mailLab = new JLabel("mail :");
    public JLabel telLab = new JLabel("telephone :");
    public JLabel usernameLab = new JLabel("username :");
    public JLabel mdpLab = new JLabel("mot de passe :");
    public JLabel roleLab = new JLabel("role :");
    
    public static JTextField prenomField = new JTextField();
    public static JTextField nomField = new JTextField();
    public static JTextField mailField = new JTextField();
    public static JTextField telField = new JTextField();
    public static JTextField usernameField = new JTextField();
    public static JTextField mdpField = new JTextField();
    public static JComboBox<String> liste = new JComboBox<>(options);
            
    
    public JButton btn = new JButton("+ AJOUTER");
    
    
    public Police font = new Police(); 
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    public Font labelFont = font.getInter(Police.PLAIN, 20);
    
    public AddUser(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        
        // Bounds
        this.viewtitle.setBounds(37,31,765,72);
        this.prenomLab.setBounds(159, 192, 147,28);
        this.nomLab.setBounds(159, 243, 147,28);
        this.mailLab.setBounds(159,294, 147,28);
        this.telLab.setBounds(159,346, 147,28);
        this.usernameLab.setBounds(159,397, 147,28);
        this.mdpLab.setBounds(159,446, 147,28);
        this.roleLab.setBounds(629, 260, 59, 30);
        
        prenomField.setBounds(319, 188, 232, 35);
        nomField.setBounds(319, 239, 232, 35);
        mailField.setBounds(319, 290, 232, 35);
        telField.setBounds(319, 338, 232, 35);
        usernameField.setBounds(319, 390, 232, 35);
        mdpField.setBounds(319, 441, 232, 35);
        liste.setBounds(696, 255, 232, 35);
        
        this.btn.setBounds(864, 607, 138, 37);
        
        // Font
        this.viewtitle.setFont(this.titleFont);
        this.prenomLab.setFont(this.labelFont);
        this.nomLab.setFont(this.labelFont);
        this.mailLab.setFont(this.labelFont);
        this.telLab.setFont(this.labelFont);
        this.usernameLab.setFont(this.labelFont);
        this.mdpLab.setFont(this.labelFont);
        this.roleLab.setFont(this.labelFont);
        this.btn.setFont(this.btnFont);
        
        // custom
        prenomField.setBorder(new LineBorder(Color.BLACK, 1));
        nomField.setBorder(new LineBorder(Color.BLACK, 1));
        mailField.setBorder(new LineBorder(Color.BLACK, 1));
        telField.setBorder(new LineBorder(Color.BLACK, 1));
        usernameField.setBorder(new LineBorder(Color.BLACK, 1));
        mdpField.setBorder(new LineBorder(Color.BLACK, 1));
        liste.setBorder(new LineBorder(Color.BLACK, 1));
        liste.setBackground(Colorize.PRIMARY_RED);
        liste.setFont(this.btnFont);
          
        this.btn.setBackground(Colorize.PRIMARY_GREEN);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        this.viewtitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Events
        this.viewtitle.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new HomeView(), HomeView.TITLE);
            }
        });
        this.btn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Query bdd = new Query();
                System.out.println(String.valueOf(liste.getSelectedItem()));
                bdd.insertUser(prenomField.getText(), nomField.getText(), mailField.getText(), telField.getText(), usernameField.getText(), mdpField.getText(), bdd.getIdDroits(String.valueOf(liste.getSelectedItem())));
                Gen.changeFrame(new GestionUser(), GestionUser.TITLE);
            }
        });
        
        // Add
        this.add(this.viewtitle);
        this.add(this.prenomLab);
        this.add(this.nomLab);
        this.add(this.mailLab);
        this.add(this.telLab);
        this.add(this.usernameLab);
        this.add(this.mdpLab);
        this.add(this.roleLab);
        this.add(this.btn);
        
        this.add(prenomField);
        this.add(nomField);
        this.add(mailField);
        this.add(telField);
        this.add(usernameField);
        this.add(mdpField);
        this.add(liste);

    }
}
