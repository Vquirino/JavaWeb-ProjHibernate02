package persistence;

import java.util.*;
import org.hibernate.*;
import model.Turma;

public class TurmaDao {
    
    public void salvar(Turma t) throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(t);
        tx.commit();
    }
    
    public List<Turma> listar() throws Exception{
        Session s = HibernateUtil.getSessionFactory().openSession();
        return s.createCriteria(Turma.class).list();
    }
    
}
