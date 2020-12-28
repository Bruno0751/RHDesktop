//PROJECT NAME: prjRH
package br.com.fis.app;

import br.com.fis.model.Gerente;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 15/12/2019
 */
public class GerenteBO {
    
    private List<Gerente> listGerentes;
    private List<Gerente> listingGerentes;
    
    public GerenteBO(){
        this.listGerentes = new ArrayList<>();
        this.listingGerentes = new ArrayList<>();
    }

    public List<Gerente> getListingGerentes() {
        return listingGerentes;
    }

    public void setListingGerentes(List<Gerente> listingGerentes) {
        this.listingGerentes = listingGerentes;
    }
   
    public void gravarGerente(String nome, long cpf){
        Gerente objGerente = new Gerente(cpf, "");
        List<Gerente> gerentes = getListingGerentes();
        
        objGerente.setNome(nome);
        objGerente.setCpf(cpf);
        gerentes.add(objGerente);
        this.listGerentes = gerentes;
    }
    
    private String getAllListaDeGerentes() {
        String gerentes = "Lista de Todos os GERENTES \n";
        for (int i = 0; i < getListingGerentes().size() ; i++) {
            gerentes += "\n::::::::::::::::GERENTE " + (i + 1) + ":::::::::::::::::" + this.listGerentes.get(i) + "\n"
                    + ":::::::::::::::::::::::::::::::::::::::::::::::";
        }
        return gerentes;
    }
    
    public void processos(){
        if (listGerentes.isEmpty()){
            System.out.println("Não Há Gerentes Cadastrados");
        } else {
            System.out.println("Gerentes Cadastrados: \n" + getAllListaDeGerentes());
        }
    }
}