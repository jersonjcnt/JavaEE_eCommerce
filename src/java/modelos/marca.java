
package modelos;
import java.io.Serializable;
public class marca implements Serializable {
    
    private int idmar;
    private String nom;    
    private boolean est;

    public marca() {        
    }
    
    public marca(int idmar, String nom, boolean est) {
        this.idmar = idmar;
        this.nom = nom;
        this.est = est;
    }

    public int getIdmar() {
        return idmar;
    }

    public void setIdmar(int idmar) {
        this.idmar = idmar;
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
        
}