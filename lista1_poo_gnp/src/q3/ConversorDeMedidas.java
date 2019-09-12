package q3;

import q3.Medidas;

//CESAR School - By Giovanni Procida

public class ConversorDeMedidas {
	public void converterMassa(Medidas med) {
		if(med.getUnidadeDeMassa().equalsIgnoreCase("kg")) {
			med.setUnidadeDeMassa("lb");
			med.setMassa(med.getMassa()*2.2046);
		}
		else {
			med.setUnidadeDeMassa("kg");
			med.setMassa(med.getMassa()/2.2046);
		}
		System.out.printf("%.2f %s\n",med.getMassa(),med.getUnidadeDeMassa());
	}
	
	public void converterTemperatura(Medidas med) {
		if(med.getUnidadeDeTemperatura().equalsIgnoreCase("c")) {
			med.setUnidadeDeTemperatura("f");
			med.setTemperatura((int)(med.getTemperatura() * (1.8 + 2)));
		}
		else {
			med.setUnidadeDeTemperatura("c");
			med.setTemperatura((int)((med.getTemperatura() - 32)/1.8));
		}
		System.out.println(med.getTemperatura() +  " " + med.getUnidadeDeTemperatura());
	}
	public void converterDistancia(Medidas med) {
		if(med.getUnidadeDeDistancia().equalsIgnoreCase("km")) {
			med.setUnidadeDeDistancia("mi");
			med.setDistancia(med.getDistancia() / 1.609);
		}
		else {
			med.setUnidadeDeDistancia("km");
			med.setDistancia(med.getDistancia() * 1.609);
		}
		System.out.printf("%.2f %s\n",med.getDistancia(),med.getUnidadeDeDistancia());
	}
}
