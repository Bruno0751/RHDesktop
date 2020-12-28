//PROJECT NAME: prjRH
package br.com.fis.app;

import br.com.fis.model.Empregado;
import br.com.fis.view.Principal;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 14/12/2019
 */
public class EmpregadoBO {
    
    private List<Empregado> listEmpregados;
    private List<Empregado> listingEmpregados;
    private Empregado verifica;
    
    public EmpregadoBO(){
        this.listEmpregados = new ArrayList<>();
        this.listingEmpregados = new ArrayList<>();      
    }
    
    public Empregado getVerifica() {
        return verifica;
    }

    public void setVerifica(Empregado verifica) {
        this.verifica = verifica;
    }
    
    public Empregado verificarCPF(long cpf){
        for(int i = 0;i < this.listEmpregados.size();i++){
            if(this.listEmpregados.get(i).getCpf() == cpf){
                return this.listEmpregados.get(i);
            }
        }
        return null;
    }

    public List<Empregado> getListEmpregados() {
        return listEmpregados;
    }

    public void setListEmpregados(List<Empregado> listEmpregados) {
        this.listEmpregados = listEmpregados;
    }
    
    public void gravarFuncionario(String nome, long cpf){
        Principal principal = new Principal();
        List<Empregado> empregados = getListEmpregados();
        
        Empregado objEmpregado = new Empregado(cpf, "");
        objEmpregado.setNome(nome);
        objEmpregado.setCpf(cpf);
        empregados.add(objEmpregado);
        this.listingEmpregados = empregados;
    }
    
    private String getAllListaDeEmpregados() {
        String empregados = "Lista de Todos os Funcionarios \n";
        for (int i = 0; i < this.listEmpregados.size(); i++) {
            empregados += "\n::::::::::::::::FUNCIONARIO " + (i + 1) + " :::::::::::::::::" + this.listEmpregados.get(i) + "\n"
                    + "::::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return empregados;
    }
    
    public void processos(){
        if (!listingEmpregados.isEmpty()){
            System.out.println("Empregados Cadastrados: \n" + getAllListaDeEmpregados());
        } else {
            System.out.println("Não Há Funcionarios Cadastrados");
        }
    }
}