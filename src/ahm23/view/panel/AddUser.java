
package ahm23.view.panel;

import ahm23.Design.Colorize;
import ahm23.Design.Police;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddUser extends JFrame{
    
    public JLabel viewtitle = new JLabel("AHM23 - Ajout utilisateur");
    
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
    
    public JButton btn = new JButton("+ AJOUTER");
    
    
    public Police font = new Police(); 
    public Font titleFont = font.getImpact(Police.BOLD, 64);
    public Font btnFont = font.getImpact(Police.BOLD, 20);
    public Font labelFont = font.getInter(Police.PLAIN, 20);
    
    public AddUser(){
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        // Bounds
        this.viewtitle.setBounds(37,31,765,72);
        this.prenomLab.setBounds(159, 192, 147,28);
        this.nomLab.setBounds(159, 243, 147,28);
        this.mailLab.setBounds(159,294, 147,28);
        this.telLab.setBounds(159,346, 147,28);
        this.usernameLab.setBounds(159,397, 147,28);
        this.mdpLab.setBounds(159,446, 147,28);
        
        prenomField.setBounds(319, 188, 232, 35);
        nomField.setBounds(319, 239, 232, 35);
        mailField.setBounds(319, 290, 232, 35);
        telField.setBounds(319, 338, 232, 35);
        usernameField.setBounds(319, 390, 232, 35);
        mdpField.setBounds(319, 441, 232, 35);
        
        this.btn.setBounds(864, 647, 138, 37);
        
        // Font
        this.viewtitle.setFont(this.titleFont);
        this.prenomLab.setFont(this.labelFont);
        this.nomLab.setFont(this.labelFont);
        this.mailLab.setFont(this.labelFont);
        this.telLab.setFont(this.labelFont);
        this.usernameLab.setFont(this.labelFont);
        this.mdpLab.setFont(this.labelFont);
        this.btn.setFont(this.btnFont);

        // custom
        prenomField.setBorder(new LineBorder(Color.BLACK, 1));
        nomField.setBorder(new LineBorder(Color.BLACK, 1));
        mailField.setBorder(new LineBorder(Color.BLACK, 1));
        telField.setBorder(new LineBorder(Color.BLACK, 1));
        usernameField.setBorder(new LineBorder(Color.BLACK, 1));
        mdpField.setBorder(new LineBorder(Color.BLACK, 1));
          
        this.btn.setBackground(Colorize.PRIMARY_GREEN);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.btn.setBorderPainted(false);
        
        // Events
        
        
        // Add
        this.add(this.viewtitle);
        this.add(this.prenomLab);
        this.add(this.nomLab);
        this.add(this.mailLab);
        this.add(this.telLab);
        this.add(this.usernameLab);
        this.add(this.mdpLab);
        this.add(this.btn);
        
        this.add(prenomField);
        this.add(nomField);
        this.add(mailField);
        this.add(telField);
        this.add(usernameField);
        this.add(mdpField);
        
        this.setResizable(false);
        this.setVisible(true);
    }
}
