//PROJECT NAME: prjRH
package br.com.fis.model;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 09/12/2019
 */
public class Empregado{
    
    protected long cpf;
    protected String nome;

    public Empregado(long cpf, String nome) { }


    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "\n"
                + "::  Nome do Funcionario: " + nome + "\n"
                + "::  CPF do Funcionario: " + cpf;
    }
}
