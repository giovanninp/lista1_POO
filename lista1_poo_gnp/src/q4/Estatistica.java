package q4;

import java.lang.Math;
import java.util.Scanner;

//CESAR School - By Giovanni Procida

public class Estatistica {
	int maiorValor;

	public Estatistica(int value) {
		this.maiorValor = value;
	}
	public int somatorioTotal() {
		int result = 0;
		for(int i = 0; i <= this.maiorValor;i++ ) {
			result +=i;
		}
		return result;
	}
	public double mediaTotal() {
		double resultDouble = ( (double) somatorioTotal() / (double) (this.maiorValor + 1));
//		double rest = resultDouble % 1;
//		if(rest >= 0.5) {
//			resultDouble += 1 - rest;
//		}
//		else {
//			resultDouble -= rest;
//		}
		return resultDouble;
	}
	public double variancia() {
		double result = 0;
		double sum = 0;
		int count = 0;
		while(count <= this.maiorValor) {
			sum += Math.pow((count -  ( double ) this.mediaTotal()),2);
			count++;
		}
		result = sum / this.maiorValor;
		return result;
	}
	
	public void parOuNao() {
		int count = 0;
		do {
			if(count % 2 == 0) {
				System.out.printf("%d é par\n",count);
			}
			else {
				System.out.printf("%d é impar\n",count);
			}
			count++;
		}while(count <= this.maiorValor);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		String input = "";
		boolean rep = true;
		System.out.println("Estatistica:\nDigite um numero de entrada:");
		while(rep) {
			try {
				input = s.nextLine();
				int value = Integer.parseInt(input);
//				int value = s.nextInt();
				Estatistica estatistica = new Estatistica(value);
				System.out.println("Valor: " + estatistica.maiorValor);
				System.out.println("Somatorio: " + estatistica.somatorioTotal());
				System.out.println("Media: " + estatistica.mediaTotal());
				System.out.printf("Variancia: %.2f\n", estatistica.variancia());
				System.out.println("Pares e impares:");
				estatistica.parOuNao();
				System.out.println("(Digite 'q' para sair)");
			} catch (Exception InputMismatchException) {
				if(input.equalsIgnoreCase("q")) {
					System.out.println("Saindo.");
					break;
				}
				else {
					System.out.println("Elemento nao autorizado");
				}
			}
		}
		s.close();
		
	}
	
}
