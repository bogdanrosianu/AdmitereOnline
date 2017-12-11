package session;

import entity.Utilizator;
import javax.ejb.Local;

@Local
public interface SessionUtilizatorLocal {
    public void adaugaUtilizator(String numeDeUtilizator, String parola, String email, String nume, String prenume);
    public Utilizator login(String email, String password);
}
