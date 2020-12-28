//PROJECT NAME: prjRH
package br.com.fis.model;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 09/12/2019
 */
public class Departamento  {
    
    private int numero;
    private String nome;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
                + "::  Nome do Departamento: " + this.nome + "\n"
                + "::  Número do Departamento " + this.numero;
    }
}