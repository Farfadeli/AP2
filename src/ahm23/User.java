package ahm23;

public class User {
   
    private int id;
    private String prenom;
    private String nom;
    private String mail;
    private long tel;
    private String username;
    private int vip;
    
    public User(int identifiant){
        this.id = identifiant;
    }
    
    public String toString(){
       return String.format(
               "id -> %d  \nprenom -> %s \nnom -> %s \nmail -> %s \ntel -> %d \nusername -> %s \ndroits -> %s", 
               this.id, this.prenom, this.nom,this.mail, this.tel, this.username, this.vip);
    }
    
    
    public int getId(){
        return this.id;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public String getNom(){
        return this.nom;
    }
    public String getMail(){
        return this.mail;
    }
    public long getTel(){
        return this.tel;
    }
    public String getUsername(){
        return this.username;
    }
    public int getVip(){
        return this.vip;
    }
    
    public void setPrenom(String name){
        this.prenom = name;
    }
    public void setNom(String name){
        this.nom = name;
    }
    public void setMail(String mel){
        this.mail = mel;
    }
    public void setTel(long telephone){
        this.tel = telephone;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public void setVip(int droits){
        this.vip = droits;
    }
}
