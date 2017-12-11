package session;

import entity.Utilizator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class SessionUtilizator implements SessionUtilizatorLocal {
    private EntityManagerFactory efm = Persistence.createEntityManagerFactory("Admitere_OnlinePU");
    private EntityManager em = efm.createEntityManager();
    
    @Override
    public void adaugaUtilizator(String numeDeUtilizator, String parola, String email, String nume, String prenume) {
      Integer contor = 0;
      try{
            File file = new File("C:\\Users\\MARIU\\Desktop\\Admitere_Online\\src\\java\\session\\contorBD.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
           contor = Integer.parseInt(dis.readLine());
           fis.close();
           bis.close();
           dis.close();
       }
       catch(FileNotFoundException fnfe){
           fnfe.printStackTrace();
       }
       catch(IOException ioe){
           ioe.printStackTrace();
       }
       
       contor++;
       
        try{
           BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\MARIU\\Desktop\\Admitere_Online\\src\\java\\session\\contorBD.txt"));
           bw.write(contor.toString());
           bw.close();
       }
       catch(Exception e){
           e.printStackTrace();
       }
       
      
        Utilizator user = new Utilizator(contor,numeDeUtilizator,parola,email,nume,prenume,(short)4);
        try{
             em.getTransaction().begin();
             em.persist(user);
             em.flush();
             em.getTransaction().commit();
             em.close();
         }catch(Exception ex){
             em.getTransaction().rollback();
             em.close();
         }
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Utilizator login(String nume_de_utilizator, String parola) {
        Utilizator user = null;
        try{
            TypedQuery<Utilizator> query = em.createQuery("SELECT u FROM Utilizator u WHERE u.numeDeUtilizator=:nume AND u.parola=:parola", Utilizator.class);
            user = query.setParameter("nume", nume_de_utilizator)
                    .setParameter("parola", parola)
                    .getSingleResult();
          
        return user; 
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
}
