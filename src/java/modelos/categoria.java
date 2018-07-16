
package modelos;
import java.io.Serializable;
public class categoria implements Serializable { // Para que una clase sea un JavaBean debe implementar la interfaz serializabe
    
    private int idcat;      
    private String nom;    
    private boolean est;
    private int catsup;    
    
    public categoria () {        
    }         

    public categoria(int idcat, String nom, boolean est, int catsup) {
        this.idcat = idcat;
        this.nom = nom;
        this.est = est;
        this.catsup = catsup;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isEst() {
        return est;
    }

    public void setEst(boolean est) {
        this.est = est;
    }

    public int getCatsup() {
        return catsup;
    }

    public void setCatsup(int catsup) {
        this.catsup = catsup;
    }
        
}