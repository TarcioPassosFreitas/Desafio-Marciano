package CodigoDoDesafio;

import java.util.Locale;
import java.util.Scanner;

public class Codigo {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Desafio dos colonos Marcianos");
		
		
		
		System.out.println("Insira a quantidade de candidatos que serão selecionados:");
		int N = sc.nextInt();
		System.out.println("Insira a quantidade de candidatos:");
		int Q = sc.nextInt();
		
		int[] NQi = new int[Q];
		int[] IdQi = new int[Q];
		for(int i = 0; i < Q; i++) {
			System.out.println("Qual a nota do candidato " + i + "?");
			NQi[i] = sc.nextInt();
			System.out.println("Qual é o ID do cadidato " + i + "?");
			IdQi[i] = sc.nextInt();
		}
		
		selectionSort(NQi, IdQi);
		
		int result = buscaBinaria(IdQi);
		
		if(result <= N) {
			System.out.println("O id foi selecionado. Parabéns!");
		}else {
			System.out.println("O id não foi selecionado. Mais sorte na próxima.");
		}
		
		

		
		sc.close();
	}
	
	public static void selectionSort(int[] k, int[] l) {
		int menor_i, aux1, aux2;
		
		for(int i = 0; i < k.length; i++) {
			menor_i = i;
			for(int j = i + 1; j < k.length; j++) {
				if(k[j] < k[menor_i]) {
					menor_i = j;
				}
			}
			aux1 = k[i];
			aux2 = l[i];
			k[i] = k[menor_i];
			l[i] = l[menor_i];
			k[menor_i] = aux1;
			l[menor_i] = aux2;
		}
		
		for(int i = 0; i < l.length; i++) {
			menor_i = i;
			for(int j = i+1; j < l.length; j++) {
				if(k[j] == k[menor_i]) {
					if(l[j] > l[menor_i]) {
						menor_i = j;
					}
				}
			}
			aux2 = l[i];
			l[i] = l[menor_i];
			l[menor_i] = aux2;
			
		}
	}
	
	public static int buscaBinaria(int[] vetor) {
		System.out.println("Qual número Id deseja pesquisar?");
		Scanner sc = new Scanner(System.in);
		
		int buscado = sc.nextInt();
		
		int count = 0;
		int inicio = 0;
		int meio = 0;
		int fim = vetor.length - 1;
		
		while(inicio <= fim) {
			meio = (int) (inicio + fim)/2;
			count++;
		
			if(vetor[meio] == buscado) {
                sc.close();
				return count;
			}else if(vetor[meio] < buscado) {
				inicio = meio + 1;
			}else {
				fim = meio - 1;
			}
		}
		
		sc.close();
		return -1;
		
		
		
    }
}
