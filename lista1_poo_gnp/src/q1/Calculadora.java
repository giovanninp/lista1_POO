package q1;

import java.util.Scanner;

//CESAR School - By Giovanni Procida

public class Calculadora {
	public double somar(double value1,double value2) {
		return value1 + value2;
	}
	public double subtrair(double value1,double value2) {
		return value1 - value2;
	}
	public double multiplicar(double value1,double value2) {
		return value1 * value2;
	}
	public double dividir(double value1,double value2) {
		return value1/value2;
	}
	public double elevarAPotencia(double value1,double value2) {
		double result = 1;
		if (value2 != 0) {
			if(value2 % 1 != 0) {
				double rest = value2 % 2;
				if(rest >= 0.5) {
					value2 += 1 - rest;
				}
				else {
					value2 -= rest;
				}
			}
			if (value2 < 0) {
				value2 *= -1;
				result = elevarAPotencia(this.dividir(1, value1), value2);
			}
			else {
				for(int i = (int)value2;i > 0;i--) {
					result *= value1;
				}
			}
		}
		return result;
	}
	
	public static void main(String [] args) {
		Calculadora calculadora = new Calculadora();
		
		int crashCount = 0;
		
		String command = null;
		boolean rep = true;
		String [] operations =  new String [] {"+","^","/","*","-"}; 
		
		Scanner s = new Scanner(System.in);
		
		while (rep){
			System.out.println("Digite a expressao:\n(ex:2*2)");
			command = s.nextLine();
			command = command.replaceAll("\\s", "");
			double v1,v2;
			if (command.equals("")) {
				rep = false;
				System.out.println("Fim de execucao.");
			}
			
			else {
				int optI = -1;
				int indice = -1;

				for(int i = 0; i < operations.length;i++) {
					indice = command.indexOf(operations[i]);
					if(indice > -1) {
						optI = i;
						break;
					}
				}
				//Try catch caso o a entrada seja um caracter
				try {
					//Tratamento das variaveis, caso o char selecionado seja reservado no regex
					v1 = Double.parseDouble(command.split("\\".concat(operations[optI]))[0]);
					v2 = Double.parseDouble(command.split("\\".concat(operations[optI]))[1]);
				} catch (Exception  NumberFormatException) {
					crashCount++;
					if(crashCount > 3) {
						System.out.println("To magoado!");
						break;
					}
					else {
						System.out.println("Tente me quebrar nao mano!!\n");
						continue;
					}
				}
				
				if(optI > -1) {
					System.out.println("x: "+ v1+ " y: " +v2);
					switch (optI) {
						case 0:
							System.out.println(calculadora.somar(v1, v2));	
							break;
						case 1:
							System.out.println(calculadora.elevarAPotencia(v1, v2));
							break;
						case 2:
							System.out.println(calculadora.dividir(v1, v2));
							break;
						case 3:
							System.out.println(calculadora.multiplicar(v1, v2));
							break;
						case 4:
							System.out.println(calculadora.subtrair(v1, v2));
							break;
						default:
							System.out.println("Out of bagulhetes");
							break;
					}
				}
				
			}
		}
		s.close();
	}
}
