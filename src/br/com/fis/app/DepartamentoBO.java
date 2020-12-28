//PROJECT NAME: prjRH
package br.com.fis.app;

import br.com.fis.model.Departamento;
import br.com.fis.model.Gerente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 14/12/2019
 */
public class DepartamentoBO {
    
    private long cpf;
    private List<Departamento> listaDepartamentos;
    private Gerente objGerente = new Gerente(this.cpf, "");
    
    public DepartamentoBO(){
        this.listaDepartamentos = new ArrayList<>();
    }

    public void gravarDepartamento(String nome, int numero){
        
        List<Departamento> listDepartamentos = objGerente.getListaDepartamentos();
        
        Departamento objDepartamento = new Departamento();
        objDepartamento.setNome(nome);
        objDepartamento.setNumero(numero);
        listDepartamentos.add(objDepartamento);
        this.listaDepartamentos = listDepartamentos;
    }
    
    private String getAllListaDeDepartamentos() {
        String departamentos = "Lista de Todos os Departamentos \n";
        for (int i = 0; i < objGerente.getListaDepartamentos().size() ; i++) {
            departamentos += "\n::::::::::::::::DEPARTAMENTO " + (i + 1) + ":::::::::::::::::" + this.listaDepartamentos.get(i) + "\n"
                    + ":::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return departamentos;
    }
    
    public void processos(){
        if (this.listaDepartamentos.isEmpty()){
            System.out.println("Não Há Departamentos Cadastrados");
        } else {
            System.out.println("Departamentos Cadastrados: \n" + getAllListaDeDepartamentos());
        }
    }
}