package ahm23.view.panel;

import ahm23.Design.Police;
import ahm23.view.Gen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomeView extends JPanel{
    
    public static final String TITLE = "ahm23 | Accueil";
    
    public JLabel titleLabel = new JLabel("AHM23 - ACCUEIL");
    
    public JLabel iconStock = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/ahm23/view/panel/icon/in-stock.png"));
    public JLabel iconComptable = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/ahm23/view/panel/icon/fichier.png"));
    public JLabel iconAdd = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/ahm23/view/panel/icon/warehouse.png"));
    public JLabel iconFire = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/ahm23/view/panel/icon/feu.png"));
    public JLabel iconUser = new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/ahm23/view/panel/icon/utilisateur.png"));
    
    public JLabel stock = new JLabel("Gestion stocks");
    public JLabel comptable = new JLabel("Comptabilité");
    public JLabel adding = new JLabel("Ajout stocks");
    public JLabel fire = new JLabel("Allume feu");
    public JLabel utilisateur = new JLabel("Utilisateurs");
    
    Police font = new Police();
    public Font titleImpact = font.getImpact(Police.BOLD, 64);
    
    public HomeView(){
        this.setSize(Gen.WIDTH, Gen.HEIGHT);
        this.setLayout(null);
        
        
        this.titleLabel.setFont(this.titleImpact);
        
        this.titleLabel.setBounds(35, 20, 508, 81);
        this.iconStock.setBounds(35, 272, 128, 128);
        this.iconComptable.setBounds(254, 272, 128, 128);
        this.iconAdd.setBounds(473, 272, 128, 128);
        this.iconFire.setBounds(685, 272, 128, 128);
        this.iconUser.setBounds(892, 272, 128, 128);
        
        this.stock.setBounds(50, 413, 148, 23);
        this.comptable.setBounds(280, 413 ,126, 23);
        this.adding.setBounds(500, 413 ,121, 23);
        this.fire.setBounds(715, 413 ,103, 23);
        this.utilisateur.setBounds(920, 413 ,103, 23);
        
        
        this.iconStock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.iconComptable.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.iconAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.iconFire.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.iconUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Events
        this.iconAdd.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new AddStocks(), AddStocks.TITLE);
            }
        });
        this.iconStock.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new Gestion(), Gestion.TITLE);
            }
        });
        this.iconComptable.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new Comptable(), Comptable.TITLE);
            }
        });
        this.iconUser.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Gen.changeFrame(new GestionUser(), GestionUser.TITLE);
            }
        });
        
        this.add(this.titleLabel);
        this.add(this.iconStock);
        this.add(this.iconComptable);
        this.add(this.iconAdd);
        this.add(this.iconFire);
        this.add(this.iconUser);
        this.add(this.stock);
        this.add(this.comptable);
        this.add(this.adding);
        this.add(this.fire);
        this.add(this.utilisateur);
    }
    
}
