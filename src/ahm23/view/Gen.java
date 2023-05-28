package ahm23.view;

import ahm23.User;
import ahm23.view.panel.ConnexionPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gen{
    public static JFrame frame = new JFrame();
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    
    private User user = null;
    
    public static JPanel actPanel = new ConnexionPanel();
    
    public Gen(){
        
        frame.setTitle("ahm23 | Connexion");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);
        
        frame.setContentPane(actPanel);
        
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void changeFrame(JPanel newPan, String newTitle){
        frame.setContentPane(newPan);
        frame.setTitle((newTitle));
        frame.revalidate();
    }
    
    public void setUser(User utils){
        this.user = utils;
    }
    public User getUser(){
        return this.user;
    }
    
}
