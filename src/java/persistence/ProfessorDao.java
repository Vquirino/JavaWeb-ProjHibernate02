package persistence;

import java.util.*;
import org.hibernate.*;
import model.Professor;

public class ProfessorDao {
    
    public List<Professor> listar() throws Exception{
        //acesso ao banco de dados
        Session s = HibernateUtil.getSessionFactory().openSession();
        //consulta de Professores
        return s.createCriteria(Professor.class).list();
    }
    
}
