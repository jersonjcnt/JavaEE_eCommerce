
package modelos_JavaBeans;
import java.io.Serializable;
public class marca implements Serializable {
    
    private int idmar;
    private String nom;    
    private int est;

    public marca() {        
    }

    public marca(int idmar, String nom, int est) {
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

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }
    
}
