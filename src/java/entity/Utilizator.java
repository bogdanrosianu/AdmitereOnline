package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UTILIZATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilizator.findAll", query = "SELECT u FROM Utilizator u")
    , @NamedQuery(name = "Utilizator.findByIdUtilizator", query = "SELECT u FROM Utilizator u WHERE u.idUtilizator = :idUtilizator")
    , @NamedQuery(name = "Utilizator.findByNumeDeUtilizator", query = "SELECT u FROM Utilizator u WHERE u.numeDeUtilizator = :numeDeUtilizator")
    , @NamedQuery(name = "Utilizator.findByParola", query = "SELECT u FROM Utilizator u WHERE u.parola = :parola")
    , @NamedQuery(name = "Utilizator.findByEmail", query = "SELECT u FROM Utilizator u WHERE u.email = :email")
    , @NamedQuery(name = "Utilizator.findByNume", query = "SELECT u FROM Utilizator u WHERE u.nume = :nume")
    , @NamedQuery(name = "Utilizator.findByPrenume", query = "SELECT u FROM Utilizator u WHERE u.prenume = :prenume")
    , @NamedQuery(name = "Utilizator.findByTip", query = "SELECT u FROM Utilizator u WHERE u.tip = :tip")
   })
public class Utilizator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UTILIZATOR")
    private Integer idUtilizator;
    @Size(max = 40)
    @Column(name = "NUME_DE_UTILIZATOR")
    private String numeDeUtilizator;
    @Size(max = 40)
    @Column(name = "PAROLA")
    private String parola;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 40)
    @Column(name = "NUME")
    private String nume;
    @Size(max = 40)
    @Column(name = "PRENUME")
    private String prenume;
    @Column(name = "TIP")
    private Short tip;

    public Utilizator() {
    }

    public Utilizator(Integer idUtilizator, String numeDeUtilizator, String parola, String email, String nume, String prenume, Short tip) {
        this.idUtilizator = idUtilizator;
        this.numeDeUtilizator = numeDeUtilizator;
        this.parola = parola;
        this.email = email;
        this.nume = nume;
        this.prenume = prenume;
        this.tip = tip;
    }

    public Utilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public Integer getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(Integer idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getNumeDeUtilizator() {
        return numeDeUtilizator;
    }

    public void setNumeDeUtilizator(String numeDeUtilizator) {
        this.numeDeUtilizator = numeDeUtilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Short getTip() {
        return tip;
    }

    public void setTip(Short tip) {
        this.tip = tip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilizator != null ? idUtilizator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizator)) {
            return false;
        }
        Utilizator other = (Utilizator) object;
        if ((this.idUtilizator == null && other.idUtilizator != null) || (this.idUtilizator != null && !this.idUtilizator.equals(other.idUtilizator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Utilizator[ idUtilizator=" + idUtilizator + " ]";
    }
    
}
