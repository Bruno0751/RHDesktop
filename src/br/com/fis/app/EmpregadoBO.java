//PROJECT NAME: prjRH
package br.com.fis.app;
import br.com.fis.model.Empregado;
import br.com.fis.view.Principal;
import java.util.ArrayList;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 14/12/2019
 */
public class EmpregadoBO {
    
    private ArrayList<Empregado> listaDeEmpregados;
    private ArrayList<Empregado> arrayEmpregado;   
    
    public EmpregadoBO(){
        this.listaDeEmpregados = new ArrayList<>();
        this.arrayEmpregado = new ArrayList<>();      
    }
    
    public Empregado verificarCPF(long cpf){
        for(int i = 0;i < this.listaDeEmpregados.size();i++){
            if(this.listaDeEmpregados.get(i).getCpf() == cpf){
                return this.listaDeEmpregados.get(i);
            }
        }
        return null;
    }

    public ArrayList<Empregado> getListaDeEmpregados() {
        return listaDeEmpregados;
    }

    public void setListaDeEmpregados(ArrayList<Empregado> listaDeEmpregados) {
        this.listaDeEmpregados = listaDeEmpregados;
    }
    
    public void gravarFuncionario(String nome, long cpf){
        Principal principal = new Principal();
        ArrayList<Empregado> arrayEmpregados = getListaDeEmpregados();
        
        Empregado objEmpregado = new Empregado(cpf, "");
        objEmpregado.setNome(nome);
        objEmpregado.setCpf(cpf);
        arrayEmpregados.add(objEmpregado);
        this.arrayEmpregado = arrayEmpregados;
    }
    
    private String getAllListaDeEmpregados() {
        String empregados = "Lista de Todos os Funcionarios \n";
        for (int i = 0; i < this.listaDeEmpregados.size(); i++) {
            empregados += "\n::::::::::::::::FUNCIONARIO " + (i + 1) + " :::::::::::::::::" + this.listaDeEmpregados.get(i) + "\n"
                    + "::::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return empregados;
    }
    
    public void processos(){
        if (!arrayEmpregado.isEmpty()){
            System.out.println("Empregados Cadastrados: \n" + getAllListaDeEmpregados());
        } else {
            System.out.println("Não Há Funcionarios Cadastrados");
        }
    }
}
