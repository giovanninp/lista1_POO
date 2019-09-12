package q3;

import java.util.Scanner;

import q3.ConversorDeMedidas;

//CESAR School - By Giovanni Procida

public class Medidas {
	private String unidadeDeDistancia;
	private double distancia;
	private String unidadeDeMassa;
	private double massa;
	private String unidadeDeTemperatura;
	private int temperatura;
	
	public Medidas() {
		this.unidadeDeDistancia = "km";
		this.distancia = 0;
		this.unidadeDeMassa = "kg";
		this.massa = 0;
		this.unidadeDeTemperatura = "c";
		this.temperatura = 0;
	}
	public Medidas(String unidDeDist,double dist,String unidDeMassa,
			double massa, String unidDeTemp, int temp) {
		
		if(unidDeDist.equalsIgnoreCase("Km") || unidDeDist.equalsIgnoreCase("mi")) {
			this.unidadeDeDistancia = unidDeDist;
			this.distancia = dist;
		}
		else {
			System.out.println("Unidade de distancia nao disponivel!");
			this.unidadeDeDistancia = "km";
			this.distancia = 0;
		}
		if(unidDeMassa.equalsIgnoreCase("kg") || unidDeMassa.equalsIgnoreCase("lb")) {
			this.unidadeDeMassa = unidDeMassa;
			this.massa = massa;
		}
		else {
			System.out.println("Unidade de massa nao disponivel!");
			this.unidadeDeMassa = "kg";
			this.massa = 0;
		}
		if(unidDeTemp.equalsIgnoreCase("C") || unidDeTemp.equalsIgnoreCase("F")) {
			this.unidadeDeTemperatura = unidDeTemp;
			this.temperatura = temp;
		}
		else {
			System.out.println("Unidade de temperatura nao disponivel!");
			this.unidadeDeTemperatura = "c";
			this.temperatura = 0;
		}
		
	}
	
	public void setUnidadeDeDistancia(String unidDeDist) {
		this.unidadeDeDistancia = unidDeDist;
	}
	
	public void setDistancia(double dist) {
		this.distancia = dist;
	}
	
	public void setUnidadeDeMassa(String unidDeMass) {
		this.unidadeDeMassa = unidDeMass;
	}
	
	public void setMassa(double massa) {
		this.massa = massa;
	}
	
	public void setUnidadeDeTemperatura(String unidTemp) {
		this.unidadeDeTemperatura = unidTemp;
	}
	
	public void setTemperatura(int temp) {
		this.temperatura = temp;
	}
	
	public String getUnidadeDeDistancia() {
		return this.unidadeDeDistancia;
	}
	
	public double getDistancia() {
		return this.distancia;
	}
	
	public String getUnidadeDeMassa() {
		return this.unidadeDeMassa;
	}
	
	public double getMassa() {
		return this.massa;
	}
	
	public String getUnidadeDeTemperatura() {
		return this.unidadeDeTemperatura;
	}
	
	public int getTemperatura() {
		return this.temperatura;
	}
	
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		boolean rep = true;
		while(rep){
			try {
				System.out.println("Medidas");
				System.out.println("Digite a unidade de distancia (km/mi)");
				String unidDista = s.next();
				System.out.println("Digite a distancia desejada");
				double dist = s.nextDouble();
				System.out.println("Digite a unidade de massa(kg/lb)");
				String unidMasssa = s.next();
				System.out.println("Digite a massa desejada");
				double mass = s.nextDouble();
				System.out.println("Digite a unidade de temperatura(c/f)");
				String unidTemp = s.next();
				System.out.println("Digite a temperatura desejada");
				int temp = s.nextInt();
				
				Medidas med = new Medidas(unidDista,dist,unidMasssa,mass,unidTemp,temp);
				ConversorDeMedidas conv = new ConversorDeMedidas();
				
				System.out.println("Valores convertidos:");
				conv.converterDistancia(med);
				conv.converterMassa(med);
				conv.converterTemperatura(med);
				System.out.println("Deseja continuar?(s/n)");
				String exit = s.next();
				if(exit.equalsIgnoreCase("n")) {
					rep = false;
				}
				else if(!exit.equalsIgnoreCase("s")) {
					System.out.println("Opcao invalida");
				}
			} catch (Exception InputMismatchException) {
				break;
			}
		}
		System.out.println("Fim de execucao");
		s.close();
	}
}
