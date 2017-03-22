package Lab3;

public class Data {
	
	private int dia, mes, ano;
	
	
	public void setData (int a, int b, int c) throws Exception {

	
		if (testaData(a, b, c) == 1) {
			this.dia = a;
			this.mes = b;
			this.ano = c;	
			dataValida();
		}
		
		else throw new Exception ("Data inválida");
	}
	
	
	public String toString () {
		return ("Sua data é: " + dia + " / " + mes + " / " + ano);
	}
	
	public boolean dataValida() {
		if (testaData(dia, mes, ano) == 1) {
			System.out.println("Data valida");
			return true;
		}
		else return false;
	}
	
	
	public static int testaData (int dia, int mes, int ano) {
		
		//testa se o dia é menor do que 1 ou maior do que 31
		if (dia < 1 || dia > 31)
			return 0;
		
		if (testaMes(mes) == 0) return 0;
		
		if (testaAno(ano) == 0) return 0;
		
		if (seFevereiro(dia,mes,ano) == 0) return 0;
		
		if (seMesDeTrintaDias(dia,mes) == 0) return 0;
		
		
		return 1;
			
	}

	
	
	public static int testaMes (int mes) {
		if (mes < 1 || mes > 12)
			return 0;
		else return 1;
	}
	
	
	
	public static int testaAnoBissexto(int ano) {
		if (ano <= 0) return 0;
		
		else if(ano % 4 == 0 || ano % 400 == 0 ) {
			if(ano % 100 == 0) return 0;
			return 1;
		}
		return 0;
	}
	
	
	
	
	public static int seFevereiro (int dia, int mes, int ano) {

		if (mes == 2) {
			
			if (testaAnoBissexto(ano) == 1) {
				if (dia <= 29) return 1;
				return 0;
			}
			
			if (testaAnoBissexto(ano) == 0) {
				if (dia <=28) return 1;
				else return 0;
			}
			
		}
		return 1;
		
	}
	
	
	
	public static int seMesDeTrintaDias(int dia, int mes) {
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia < 31) return 1;
			else return 0;
		}
		return 1;
	}
	
	
	public static int testaAno(int ano) {
		if (ano <= 0)
			return 0;
		return 1;
	}
	
}