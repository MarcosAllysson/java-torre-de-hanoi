/*
1ª Etapa:
Implemente um programa que calcule quanto tempo é necessário para que os sacerdotes con-
sigam movimentar n discos, onde n será definido pelo usuário.

2ª Etapa:
Implemente um programa que indique qual deve ser a movimentação dos n discos (em ordem)
para que os discos sejam transferidos da primeira para a terceira haste.
n deverá ser definido pelo usuário.
*/
package Trabalho03_MarcosAllysson_TSI_Vespertino;
import javax.swing.JOptionPane;

public class TorreDeHanoi {
    public static void printMovimento(int Origem, int Destino) { // método para imprimir movimento entre os discos
        System.out.println("Mova de " +Origem+ " para " + Destino);
    }
    
    static void hanoi(int n, int Origem, int Destino, int Auxiliar) { // método recursivo para fazer a chamada.
        if (n == 1){ // caso base
            printMovimento (Origem, Destino);
        }
        
        else if (n > 0) {
            hanoi(n - 1, Origem, Auxiliar, Destino); 
            printMovimento(Origem, Destino);
            hanoi(n - 1, Auxiliar, Destino, Origem);
        }
    }
    
    public static void main(String[] args) {
        long tempoInicio = System.currentTimeMillis();
        int minutos=0, segundos=0;
        int n; // número de discos
        
        n = Integer.parseInt(JOptionPane.showInputDialog("Quantos discos? "));
    
        TorreDeHanoi.hanoi(n, 1, 3, 2);
        
        // Calcular tempo necessário
        long tempoFinal = System.currentTimeMillis();
        long tempo = (tempoFinal - tempoInicio) / 1000; // de milisegundos para segundo
        if (tempo < 60){
            segundos = (int) tempo;
        }
        else if (tempo > 60){
            minutos = (int) tempo / 60;
            segundos = (int) tempo % 60;
        }
        
        System.out.println("\n Tempo necessário: " +minutos+ " minutos e " +segundos+ " segundos.");
    }
}
