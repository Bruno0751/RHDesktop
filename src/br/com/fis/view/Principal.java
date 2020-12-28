//PROJECT NAME: prjRH
package br.com.fis.view;

import br.com.fis.app.DepartamentoBO;
import br.com.fis.app.EmpregadoBO;
import br.com.fis.app.GerenteBO;
import br.com.fis.model.Departamento;
import br.com.fis.model.Empregado;
import br.com.fis.model.Gerente;
import br.com.fis.utl.Teclado;
import java.util.Scanner;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 10/12/2019
 */
public class Principal {
   
    public static void main(String[] args) {

        try{
            Scanner leia = new Scanner(System.in);
            Teclado objTeclado = new Teclado();
            
            EmpregadoBO objEmpregadoBO = new EmpregadoBO();
            DepartamentoBO objDepartamentoBO = new DepartamentoBO();
            GerenteBO objGerenteBO = new GerenteBO();
            
            Departamento objDepartament = new Departamento();
            Empregado objEmpregado = new Empregado(Tela.getCpf(), "");
            Gerente objGerente = new Gerente(Tela.getCpf(), "");
            
            do{
                System.out.print("\n:::::::::::::::::::::MENU:::::::::::::::::::::::\n"
                                + "::     0 - SAIR                               ::\n"
                                + "::     1 - CADASTRAR DEPARTAMENTO             ::\n"
                                + "::     2 - CADASTRAR FUNCIONARIO              ::\n"
                                + "::     3 - CADATRAR GERENTE                   ::\n"
                                + "::     4 - MOSTRAR DEPARTAMENTO/S CADASTRADOS ::\n"
                                + "::     5 - MOSTRAR FUNCIONARIOO/S CADASTRADOS ::\n"
                                + "::     6 - MOSTRAR GERENTE/S CADASTRADOS      ::\n"
                                + "::::::::::::::::::::::::::::::::::::::::::::::::\n"
                                + "Escolha a Opção: ");
                Teclado.setOp(leia.nextByte());   
                switch(Teclado.getOp()){
                    case 0:
                        Tela.limparTela();
                        System.out.println("Sistema Encerrado");
                        System.exit(0);
                        break;
                    case 1:
                        Tela.limparTela();
                        
                        System.out.println("Cadastro de Departamento \n");   
                        System.out.print("Digite o Nome do Departamento: ");
                        objDepartament.setNome(leia.next());
                        System.out.print("Digite o Número do Departamento: ");
                        objDepartament.setNumero(leia.nextInt());
                        objDepartamentoBO.gravarDepartamento(objDepartament.getNome(), objDepartament.getNumero());
                        
                        Tela.limparTela(); 
                        break;
                    case 2:
                        Tela.limparTela();
                        
                        do{
                            System.out.println("Cadastro de Empregado \n");
                            System.out.print("Digite o Nome do Empregado: ");
                            objEmpregado.setNome(leia.next());
                            System.out.print("Digite o CPF do Empregado: ");
                            objEmpregado.setCpf(leia.nextLong());
                            
                            objEmpregadoBO.setVerifica(objEmpregadoBO.verificarCPF(objEmpregado.getCpf()));
                            
                            if (objEmpregadoBO.getVerifica() != null) {
                                System.err.println("\n CPF já cadastrado \n Reiniciando o Cadastro \n");
                            }
                        }while(objEmpregadoBO.getVerifica() != null); 
                        
                        objEmpregadoBO.gravarFuncionario(objEmpregado.getNome(), objEmpregado.getCpf());
                        
                        Tela.limparTela();
                        break;
                    case 3:
                        Tela.limparTela();

                        do{
                            System.out.println("Cadastro de Gerente \n");
                            System.out.print("Digite o Nome do Gerente: ");
                            objGerente.setNome(objTeclado.lerString());
                            System.out.print("Digite o CPF do Gerente: ");
                            objGerente.setCpf(objTeclado.lerLong());
                            objEmpregadoBO.setVerifica(objEmpregadoBO.verificarCPF(objGerente.getCpf()));
                            if (objEmpregadoBO.getVerifica() != null){
                                System.err.println("\n CPF já cadastrado \n Reiniciando o Cadastro \n");
                            }
                        }while(objEmpregadoBO.getVerifica() != null);
                        objGerenteBO.gravarGerente(objGerente.getNome(), objGerente.getCpf());
                        
                        Tela.limparTela();
                        break;    
                    case 4:
                        Tela.limparTela();
                        
                        objDepartamentoBO.processos();
                        break;
                    case 5:
                        Tela.limparTela();
                        objEmpregadoBO.processos();
                        break;
                    case 6:
                        Tela.limparTela();
                        
                        objGerenteBO.processos();
                        break;
                    default:
                        Tela.limparTela();
                        
                        System.out.println("Opção Inválida");
                        break;     
                }
            }while(Teclado.getOp() != 0);   
        }catch(Exception erro){
             System.out.println("Houve Algum Erro: \n"
                    + "      tipo: " + erro);
        }finally{
             System.out.println("Fim de Sistema");
        }    
    }   
}
