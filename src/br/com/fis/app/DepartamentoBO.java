//PROJECT NAME: prjRH
package br.com.fis.app;
import br.com.fis.model.Departamento;
import br.com.fis.model.Gerente;
import java.util.ArrayList;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 14/12/2019
 */
public class DepartamentoBO {
    
    private long cpf;
    private ArrayList<Departamento> arrayLDepartamento;
    Gerente objGerente = new Gerente(this.cpf, "");
    
    public DepartamentoBO(){
        this.arrayLDepartamento = new ArrayList<>();
    }

    public void gravarDepartamento(String nome, int numero){
        
        ArrayList<Departamento> arrayLDepartamentos = objGerente.getListaDeDepartamentos();
        
        Departamento objDepartamento = new Departamento();
        objDepartamento.setNome(nome);
        objDepartamento.setNumero(numero);
        arrayLDepartamentos.add(objDepartamento);
        this.arrayLDepartamento = arrayLDepartamentos;
    }
    
    private String getAllListaDeDepartamentos() {
        String departamentos = "Lista de Todos os Departamentos \n";
        for (int i = 0; i < objGerente.getListaDeDepartamentos().size() ; i++) {
            departamentos += "\n::::::::::::::::DEPARTAMENTO " + (i + 1) + ":::::::::::::::::" + this.arrayLDepartamento.get(i) + "\n"
                    + ":::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return departamentos;
    }
    
    public void processos(){
        if (arrayLDepartamento.isEmpty()){
            System.out.println("Não Há Departamentos Cadastrados");
        } else {
            System.out.println("Departamentos Cadastrados: \n" + getAllListaDeDepartamentos());
        }
    }
}
