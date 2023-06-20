package programacaodinamica;

import java.util.Scanner;

/**
 * Classe que executa a Técnica de Programação Dinâmica
 * para o problema da mochila
 * @author Estéfani Ferlin  
 */
public class ProblemaMochila {
    
    /**
     * Método que recebe um vetor de pesos, valores e a capacidade da mochila.
     * É inicializado um vetor (ou tabela) chamado "dp" que será preenchido com 
     * os valores máximos para todas as capacidades possíveis da mochila, 
     * considerando os itens disponíveis. O primeiro laço for é itera sobre os
     * itens existentes, e cada interação representa a consideração de um novo
     * item para ser colocado na mochila. O laço for interno é executado apenas
     * se o item puder ser acomodado na mochila. Dentro do for, o valor máximo
     * para a capacidade é atualizado no vetor dp, selecionando o maior valor
     * entre incluir ou não o item na mochila. No final, o valor máximo obtido
     * para a capacidade total é retornado.
     * @param pesos int, valores int, capacidade int
     * @return tipo int
     */
    public static int mochila(int[] pesos, int[] valores, int capacidade) {
        int[] dp = new int[capacidade + 1];

        for (int i = 0; i < pesos.length; i++) {
            for (int w = capacidade; w >= pesos[i]; w--) {
                dp[w] = Math.max(dp[w], valores[i] + dp[w - pesos[i]]);
            }
        }

        return dp[capacidade];
    }

    /**
    * Método main onde os valores de número de itens, peso e seus valores são
    * preenchidos a partir da interação com o usuário. Aqui é chamado o método
    * mochila que vai encontrar o valor máximo possível de capacidade, e depois
    * mostra ao usuário.
    * @param args
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de itens: ");
        int n = scanner.nextInt();

        int[] pesos = new int[n];
        int[] valores = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Informe o peso e o valor do item " + (i + 1) + ":");
            pesos[i] = scanner.nextInt();
            valores[i] = scanner.nextInt();
        }

        System.out.print("Informe a capacidade da mochila: ");
        int capacidade = scanner.nextInt();

        int valorMaximo = mochila(pesos, valores, capacidade);

        System.out.println("Valor máximo: " + valorMaximo);
    }  
    
}
