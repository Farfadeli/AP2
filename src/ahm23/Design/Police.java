package ahm23.Design;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Police {
    
    public static final int BOLD = 1;
    public static final int PLAIN = 0;
    
    public Font setImpactFont = null;
    public Font impact = null;
    public Font setInterFont = null;
    public Font inter = null;
    public static InputStream myImpactStream = null;
    public static InputStream myInterStream = null;
    
    public Police(){
        try{
            // Imppact Font
            myImpactStream = new BufferedInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "/src/ahm23/Design/Font/Impact.ttf")
            );
            this.setImpactFont = Font.createFont(Font.TRUETYPE_FONT, myImpactStream);
            
            // Inter Font
            myInterStream = new BufferedInputStream(
                    new FileInputStream(System.getProperty("user.dir") + "/src/ahm23/Design/Font/Inter.ttf")
            );
            
            this.setInterFont = Font.createFont(Font.TRUETYPE_FONT, myInterStream);
        }catch(Exception ex){
            ex.printStackTrace();
            System.err.println("Font not loaded.");
        }
    }
    
    public Font getImpact(int wheight,int size){
        this.impact = this.setImpactFont.deriveFont(wheight, size);
        return this.impact;
    }
    public Font getInter(int wheight,int size){
        this.inter = this.setInterFont.deriveFont(wheight, size);
        return this.inter;
    }
    
}
