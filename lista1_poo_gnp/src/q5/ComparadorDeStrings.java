package q5;

import java.util.Scanner;

//CESAR School - By Giovanni Procida

public class ComparadorDeStrings {
	boolean equalsOrNot(String a, String b) {
		boolean result = true;
		if(a.length() == b .length()) {
			int count = 0;
			for(int i = a.length() - 1;i >=0;i--) {
				if(b.charAt(i) != a.charAt(count++)) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		ComparadorDeStrings comp = new ComparadorDeStrings();
		boolean rep = true;
		System.out.println("Insira um texto seguido do seu palindromo:");
		while (rep) {
			System.out.println("(Para sair da execução, digite q)");
			String a = s.next();
			if(a.equals("q")) {
				break;
			}
			String b = s.next();
			if(b.equals("q")) {
				break;
			}
			System.out.println(comp.equalsOrNot(a, b));
		}
		System.out.println("Fim de execucao");
		s.close();
	}

}
