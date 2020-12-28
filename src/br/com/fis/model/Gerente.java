//PROJECT NAME: prjRH
package br.com.fis.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 09/12/2019
 */
public class Gerente extends Empregado {

    private List<Departamento> listaDepartamentos;    
    
    public Gerente(long cpf, String nome) {
        super(cpf, nome);
        this.listaDepartamentos = new ArrayList<>();
    } 
    
    @Override
    public long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public void setListaDepartamentos(List<Departamento> listaDepartamento){
        this.listaDepartamentos = listaDepartamento;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
    
    
    @Override
    public String toString(){
        return "\n"
                + "::  Nome: " + this.nome + "\n"
                + "::  CPF: " + this.cpf;
    }
}