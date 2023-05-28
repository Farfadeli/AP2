
package ahm23.bdd;

import ahm23.User;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Query {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String BDD = "ahm23";
    public Connection connect;
    private Statement state;
    
    public Query(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahm23", USERNAME, PASSWORD);
            state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
    
    public User connexion(String username, String password){
        if(canConnect(username, password)){
            try {
                ResultSet res = this.getState().executeQuery("SELECT utilisateurs.id, droits.niveau from utilisateurs inner join droits on utilisateurs.idPrivilege = droits.id WHERE pseudo ='"+username+"';");
                while(res.next()){
                    
                    return this.getUser(res.getInt(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        else{
            return null;
        }
    }
    
    public boolean canConnect(String username, String password){
        try {
            ResultSet res = this.state.executeQuery("SELECT COUNT(id) FROM utilisateurs WHERE pseudo = '" + username + "' AND mdp = '" + password + "';");
            while(res.next()){
                return res.getInt(1) == 1 ? true: false;
            }
        } catch (SQLException ex) {
            System.out.println("hey");
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public User getUser(int id){
        try{
            User utils = new User(id);
            ResultSet res = this.getState().executeQuery("Select prenom, nom, mail, tel, pseudo,droits.niveau from utilisateurs inner join droits on utilisateurs.idPrivilege = droits.id where utilisateurs.id = " + id + " ;");
            while(res.next()){
               utils.setPrenom(res.getString(1)); 
               utils.setNom(res.getString(2));
               utils.setMail(res.getString(3));
               utils.setTel(res.getLong(4));
               utils.setUsername(res.getString(5));
               utils.setVip(res.getInt(6));
            }
            return utils;
        }catch(SQLException e){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void addStocks(String name, String longeur, String largeur, String epaisseur, String essence, String qte){
        try{
            boolean have_essence = false;
            int id_essence = 0;
            
            int nb = Integer.parseInt(qte);
            float l = Float.parseFloat(longeur);
            float L = Float.parseFloat(largeur);
            float E = Float.parseFloat(epaisseur);
            
            // Creation requete
            String requete_essence = "SELECT id FROM essencebois WHERE libelle = '" + essence + "' ;";
            String requete_insertEssence = "INSERT INTO essencebois(libelle) values( ? ) ;";
            String requete_matiere = "SELECT COUNT(id) FROM matierepremiere WHERE libelle = '"+name+"' AND longeur ="+l+" AND largeur = "+L+" AND epaisseur = "+E+" AND idEssence = "+id_essence+ " ;";
            String requete_addQte = "UPDATE matierepremiere SET stockActuel = stockActuel + ? where libelle = ? AND longeur = ? AND largeur= ? AND epaisseur = ? AND idEssence = ?;";
            String requete_ajout = "INSERT INTO matierepremiere(idEssence, libelle,longeur,largeur,epaisseur,stockActuel) values(?,?,?,?,?,?)";
            
            // Vérification Essence
            ResultSet res = this.getState().executeQuery(requete_essence);
            while(res.next()){
                have_essence = true;
                id_essence = res.getInt(1);
            }
        
            if(have_essence){
                res = this.getState().executeQuery(requete_matiere);
                while(res.next()){
                    if(res.getInt(1) == 0){
                        PreparedStatement statement = this.connect.prepareStatement(requete_ajout);
                        statement.setInt(1, id_essence);
                        statement.setString(2, name);
                        statement.setFloat(3, l);
                        statement.setFloat(4, L);
                        statement.setFloat(5, E);
                        statement.setInt(6, nb);
                        System.out.println("ohoh");
                        statement.execute();
                    }
                    else{
                        PreparedStatement prep = this.connect.prepareStatement(requete_addQte);
                        prep.setInt(1, nb);
                        prep.setString(2, name);
                        prep.setFloat(3, l);
                        prep.setFloat(4, L);
                        prep.setFloat(5, E);
                        prep.setInt(6, id_essence);
                        System.out.println("hey");
                        prep.execute();
                    }
                    
                }
            }
            else{
                PreparedStatement res_insertEssence = this.connect.prepareStatement(requete_insertEssence);
                res_insertEssence.setString(1, essence);
                res_insertEssence.execute();
                addStocks(name, longeur, largeur, epaisseur, essence, qte);
            }
         
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object[]> getStock(String elem){
        try{
            ArrayList<Object[]> toreturn = new ArrayList<Object[]>();
            ResultSet res = this.getState().executeQuery("SELECT libelle ,longeur, largeur, epaisseur, stockActuel ,stockAlerte from matierepremiere where libelle like '%"+elem+"%'");
            while(res.next()){
                float m3 = ((res.getFloat(2)/1000) * (res.getFloat(3)/1000) * (res.getFloat(4) / 1000)) * res.getInt(5);
                toreturn.add(new Object[]{res.getString(1), m3, res.getInt(6)});
            }
            return toreturn;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ArrayList<Object[]> getPalette(String args){
        try{
            ArrayList<Object[]> toReturn = new ArrayList<>();
            String requete = "SELECT designation, quantiteCommandee , coutRevient from modelepalette inner join ligneCommande on modelepalette.id = lignecommande.idModele"
                    + " inner join commande on lignecommande.idCommande = commande.id where commande.dateLIvraisonReel is NULL AND designation like '%"+args+"%';";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                toReturn.add(new Object[]{res.getString(1), res.getInt(2), res.getFloat(3)});
            }
            return toReturn;
            
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    public ArrayList<Object[]> getPalette(){
        try{
           ArrayList<Object[]> toReturn = new ArrayList<>();
            String requete = "SELECT designation, quantiteCommandee , coutRevient from modelepalette inner join ligneCommande on modelepalette.id = lignecommande.idModele"
                    + " inner join commande on lignecommande.idCommande = commande.id where commande.dateLIvraisonReel is NULL";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                toReturn.add(new Object[]{res.getString(1), res.getInt(2), res.getFloat(3)});
            }
            return toReturn;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public double getTotal(String args){
        try{
            float total = 0 ;
            String requete = "SELECT quantiteCommandee , coutRevient from modelepalette inner join ligneCommande on modelepalette.id = lignecommande.idModele"
                    + " inner join commande on lignecommande.idCommande = commande.id where commande.dateLivraisonReel is NULL AND designation like '%"+args+"%';";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                total += res.getInt(1) * res.getFloat(2);
            }
            return Math.round(total * 100.0) / 100.0;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
       return -1;  
    }
    public double getTotal(){
        try{
            float total = 0 ;
            String requete = "SELECT quantiteCommandee , coutRevient from modelepalette inner join ligneCommande on modelepalette.id = lignecommande.idModele"
                    + " inner join commande on lignecommande.idCommande = commande.id where commande.dateLIvraisonReel is NULL";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                total += res.getInt(1) * res.getFloat(2);
            }
            return Math.round(total * 100.0) / 100.0;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
       return -1;  
    }
    
    public ArrayList<Object[]> getUsers(){
        try{
            ArrayList<Object[]> toReturn = new ArrayList<Object[]>();
            String requete = "SELECT nom,prenom,mail FROM utilisateurs";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                toReturn.add(new Object[]{res.getString(1), res.getString(2), res.getString(3)});
            }
            return toReturn;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Object[]> getUsers(String args){
        try{
            ArrayList<Object[]> toReturn = new ArrayList<Object[]>();
            String requete = "SELECT nom,prenom,mail FROM utilisateurs WHERE nom like '%"+args+"%' OR prenom like '%"+args+"%' OR mail like '%"+args+"%' ;";
            ResultSet res = this.getState().executeQuery(requete);
            while(res.next()){
                toReturn.add(new Object[]{res.getString(1), res.getString(2), res.getString(3)});
            }
            return toReturn;
        }
        catch(SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Statement getState(){
        return this.state;
    }
}
