
package modelos_JavaBeans;
import java.io.Serializable;
public class moneda implements Serializable {
    
    private String nom;
    private int idPro;
    private double pre;
    private double preNue;

    public moneda() {
    }

    public moneda(String nom, int idPro, double pre, double preNue) {
        this.nom = nom;
        this.idPro = idPro;
        this.pre = pre;
        this.preNue = preNue;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public double getPre() {
        return pre;
    }

    public void setPre(double pre) {
        this.pre = pre;
    }

    public double getPreNue() {
        return preNue;
    }

    public void setPreNue(double preNue) {
        this.preNue = preNue;
    }   
    
}
