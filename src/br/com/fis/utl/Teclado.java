//PROJECT NAME: prjRH
package br.com.fis.utl;

import java.util.Scanner;
/**
 *
 * @author Bruno Gressler da Silveira
 * @version 1.0
 * @since 14/12/2019
 */
public class Teclado {
    
    private String nome;
    private int numero;
    private long cpf;
    private static byte op;
    
    Scanner leia = new Scanner(System.in);
    
    public  String lerString(){
        this.nome = leia.next();
        return this.nome;
    }
    
    public long lerLong(){
        this.cpf = leia.nextLong();
        return this.cpf;
    }
    
    public int lerInt(){
        this.numero = leia.nextInt();
        return this.numero;
    }
    
    public static void setOp(byte op) {
        Teclado.op = op;
    }

    public static byte getOp() {
        return Teclado.op;
    }
}