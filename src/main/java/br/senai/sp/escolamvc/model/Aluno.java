package br.senai.sp.escolamvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@DiscriminatorValue(value="A")
@Entity
public class Aluno extends Pessoa{

    @NotEmpty(message = "O campo Matricula deve ser preenchido")
    private String matricula;

    @NotEmpty(message = "O campo Nome deve ser preenchido")


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
    