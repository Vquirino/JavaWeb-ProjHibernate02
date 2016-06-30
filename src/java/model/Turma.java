package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="turma")
public class Turma {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="codturma")
    private Integer idTurma;
    
    @Column(name="nome", length=35, nullable=false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Column(name="datainicio", nullable=false)
    private Date dataInicio;
    
    @Column(name="descricao", length=1000, nullable=false)
    private String descricao;
    
    @ManyToOne //cardinalidade - MUITAS turmas para UM professor
    @JoinColumn(name="codprofessor", nullable=false) //foreign key
    private Professor professor;

    public Turma() {
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
    
}
