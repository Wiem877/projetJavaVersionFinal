package ClassesPrincipaux;

public class Client {
	private int cin;
    private String nom;
    private String prenom;
    private int tel;
    public Client(int cin,String nom, String prenom, int tel)
    {
    	this.cin=cin;
    	this.nom=nom;
    	this.prenom=prenom;
    	this.tel=tel;
    }
    public int getCin()
    {
    	return cin;
    }
    public String getNom()
    {
    	return nom;
    }
    public String getPrenom()
    {
    	return prenom;
    }
    public int getTel()
    {
    	return tel;
    }
    public void setCin(int val)
    {
    	cin=val;
    }
    public void setNom(String val)
    {
    	nom=val;
    }
    public void setPrenom(String  val)
    {
    	prenom=val;
    }
    public void setTel(int val)
    {
    	tel=val;
    }
}
