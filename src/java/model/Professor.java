package model;

import javax.persistence.*;

@Entity
@Table(name="professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codprofessor")
    private Integer idProfessor;
    
    @Column(name="nome", length=50, nullable=false)
    private String nome;

    public Professor() {
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
