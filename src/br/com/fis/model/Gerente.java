//PROJECT NAME: prjRH
package br.com.fis.model;
import java.util.ArrayList;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 09/12/2019
 */
public class Gerente extends Empregado {

    private ArrayList<Departamento> listaDeDepartamentos;    
    
    public Gerente(long cpf, String nome) {
        super(cpf, nome);
        this.listaDeDepartamentos = new ArrayList<>();
    } 
    public void Gerente(){}
    
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
 
    public void setListaDeDepartamentos(ArrayList<Departamento> listaDeDepartamento){
        this.listaDeDepartamentos = listaDeDepartamento;
    }

    public ArrayList<Departamento> getListaDeDepartamentos() {
        return listaDeDepartamentos;
    }
    
    
    @Override
    public String toString(){
        return "\n"
                + "::  Nome: " + this.nome + "\n"
                + "::  CPF: " + this.cpf;
    }

}
