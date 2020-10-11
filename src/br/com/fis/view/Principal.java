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
    
    private Empregado verifica;
    private byte op;
    private static long cpf = 0;

    public Empregado getVerifica() {
        return verifica;
    }

    public void setVerifica(Empregado verifica) {
        this.verifica = verifica;
    }

    public byte getOp() {
        return op;
    }

    public void setOp(byte op) {
        this.op = op;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public static void main(String[] args) {
        //INICIO DE TRY CATCH PARA TRATAMENTOS DE ERRO
        try{
            //ESTANCIANDO A CLASSE SCANNER PARA RECEBER O MÉTODO OP
            Scanner leia = new Scanner(System.in);
            
            //ESTANCIANDO A CLASSE PRINCIPAL
            Principal principal = new Principal();
            
            /*
            //ESTANCIANDO A CLASSE TECLADO PARA lerString(), lerInt() e 
            lerLong()
            */
            Teclado tecla = new Teclado();
            
            /*
            //ESTANCIANDO CLASSES  DO PACOTE br.com.fis.app, PARA CONTROLE 
            DAS CLASSES E PROCESSOS
            */
            EmpregadoBO objEmpregadoBO = new EmpregadoBO();
            DepartamentoBO objDepartamentoBO = new DepartamentoBO();
            GerenteBO objGerenteBO = new GerenteBO();
            
            /*
            //OBJ ESTANCIADO AQUI PARA VERIFICARARA O CPF DO GERENTE E DO 
            FUNCIONÁRIO QUE SÃO OS MESMOS
            */
            Empregado objEmpregado = new Empregado(principal.getCpf(), "");
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
                principal.setOp(leia.nextByte());
                switch(principal.getOp()){
                    case 0:
                        Tela.limparTela();
                        System.out.println("Sistema Encerrado");
                        System.exit(0);
                        break;
                    case 1:
                        Tela.limparTela();
                        //ESTANCIANDO DEPARTAMENTO
                        Departamento objDepartament = new Departamento();
                        
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
                            
                            principal.setVerifica(objEmpregadoBO.verificarCPF(objEmpregado.getCpf()));
                            
                            if (principal.getVerifica() != null) {
                                System.err.println("\n CPF já cadastrado \n Reiniciando o Cadastro \n");
                            }
                        }while(principal.getVerifica() != null); 
                        
                        objEmpregadoBO.gravarFuncionario(objEmpregado.getNome(), objEmpregado.getCpf());
                        Tela.limparTela();
                        break;
                    case 3:
                        Tela.limparTela();
                        Gerente objGerente = new Gerente(principal.getCpf(), "");
                        do{
                            System.out.println("Cadastro de Gerente \n");
                            System.out.print("Digite o Nome do Gerente: ");
                            objGerente.setNome(tecla.lerString());
                            System.out.print("Digite o CPF do Gerente: ");
                            objGerente.setCpf(tecla.lerLong());
                            principal.setVerifica(objEmpregadoBO.verificarCPF(objGerente.getCpf()));
                            if (principal.getVerifica() != null){
                                System.err.println("\n CPF já cadastrado \n Reiniciando o Cadastro \n");
                            }
                        }while(principal.getVerifica() != null);
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
                }//FECHA SWITCH CASE
            }while(principal.getOp() != 0);   
        }catch(Exception erro){
             System.out.println("Houve Algum Erro: \n"
                    + "      tipo: " + erro);
        }finally{
             System.out.println("Fim de Sistema");
        }//FECHA FINALLY    
    }//FECHA METODO MAIN   
}//FECHA CLASSE PRINCIPAL
