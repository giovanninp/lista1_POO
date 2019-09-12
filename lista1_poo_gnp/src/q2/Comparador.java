package q2;

import java.util.Scanner;

public class Comparador {
	private Scanner s;
	private int [] nums = new int [8];
	
	void swap(int [] list,int a,int b) {
		int aux = list[a];
		list[a] = list[b];
		list[b] = aux;
	}
	
	void selection_sort(int [] list) {
		for(int i = 0;i < list.length;i++) {
			for(int j = (1+i);j < list.length;j++) {
				if(list[i] > list[j]) {
					swap(list, i, j);
				}
			}
		}
	}
	
	public void setNums() {
		this.s = new Scanner(System.in);
		
		for(int i = 0; i < nums.length;i++) {
			
			try {
				this.nums[i] = this.s.nextInt();
			} catch (Exception InputMismatchException) {
				System.out.println("Quebrou o brinquedo");
				this.setNums();
				break;
			}
			
		}
		selection_sort(this.nums);
	}
	
	public void showNums() {
		System.out.print("\n");
		for(int i = 0;i < this.nums.length;i++) {
			System.out.printf("%d",this.nums[i]);
		}
	}
	
	public String getMaiores() {
		String [] mainText = {"Os dois maiores numeros sao "," e "};
		String fullMessage = (mainText[0] + this.nums[this.nums.length - 1] 
				+ mainText[1] + this.nums[this.nums.length - 2]);
		return fullMessage;
	}
	
	public static void main(String [] args) {
		System.out.println("Digite uma serie de 8 numeros:");
		Comparador comp = new Comparador();
		comp.setNums();
//		comp.showNums();
		System.out.println(comp.getMaiores());
	}
}
