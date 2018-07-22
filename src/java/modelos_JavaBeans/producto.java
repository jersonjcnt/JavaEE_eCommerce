
package modelos_JavaBeans;
import java.io.Serializable;
public class producto implements Serializable {
    
    private int idPro;
    private String nom;
    private String des;
    private double pre;
    private double preNue;
    private int sto;
    private int idMar;
    private int idCat;
    private int nue; // Nuevo
    private int rec; // Recomendado
    private int est; // Estado
    private String img;
    
    public producto() {        
    }

    public producto(int idPro, String nom, String des, double pre, double preNue, int sto, int idMar, int idCat, int nue, int rec, int est, String img) {
        this.idPro = idPro;
        this.nom = nom;
        this.des = des;
        this.pre = pre;
        this.preNue = preNue;
        this.sto = sto;
        this.idMar = idMar;
        this.idCat = idCat;
        this.nue = nue;
        this.rec = rec;
        this.est = est;
        this.img = img;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
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

    public int getSto() {
        return sto;
    }

    public void setSto(int sto) {
        this.sto = sto;
    }

    public int getIdMar() {
        return idMar;
    }

    public void setIdMar(int idMar) {
        this.idMar = idMar;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public int getNue() {
        return nue;
    }

    public void setNue(int nue) {
        this.nue = nue;
    }

    public int getRec() {
        return rec;
    }

    public void setRec(int rec) {
        this.rec = rec;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }           
    
}
