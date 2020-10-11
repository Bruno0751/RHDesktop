//PROJECT NAME: prjRH
package br.com.fis.app;
import br.com.fis.model.Departamento;
import br.com.fis.model.Gerente;
import br.com.fis.view.Principal;
import java.util.ArrayList;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 15/12/2019
 */
public class GerenteBO {
    
    private ArrayList<Gerente> arrayLGerente;
    private ArrayList<Gerente> listaDeGerentes;
    
    public GerenteBO(){
        this.arrayLGerente = new ArrayList<>();
        this.listaDeGerentes = new ArrayList<>();
    }

    public ArrayList<Gerente> getListaDeGerentes() {
        return listaDeGerentes;
    }

    public void setListaDeGerentes(ArrayList<Gerente> listaDeGerentes) {
        this.listaDeGerentes = listaDeGerentes;
    }
   
    public void gravarGerente(String nome, long cpf){
        Gerente objGerente = new Gerente(cpf, "");
        ArrayList<Gerente> arrayLGerentes = getListaDeGerentes();
        
        objGerente.setNome(nome);
        objGerente.setCpf(cpf);
        arrayLGerentes.add(objGerente);
        this.arrayLGerente = arrayLGerentes;
    }
    
    private String getAllListaDeGerentes() {
        String gerentes = "Lista de Todos os GERENTES \n";
        for (int i = 0; i < getListaDeGerentes().size() ; i++) {
            gerentes += "\n::::::::::::::::GERENTE " + (i + 1) + ":::::::::::::::::" + this.arrayLGerente.get(i) + "\n"
                    + ":::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return gerentes;
    }
    
    public void processos(){
        if (arrayLGerente.isEmpty()){
            System.out.println("Não Há Gerentes Cadastrados");
        } else {
            System.out.println("Gerentes Cadastrados: \n" + getAllListaDeGerentes());
        }
    }
}
