class Data {
	private int dia, mes, ano;
	public Data(int day, int month, int year) {
		dia=day;
		mes=month;
		ano=year;
	}
	public int dia(){
		return dia;
	}
	public int mes(){
		return mes;
	}
	public int ano(){
		return ano;
	}
	public boolean igualA(Data datas){
		if(datas.ano==ano) {
			if(datas.mes==mes) {
				if(datas.dia==dia) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
	public boolean menorDoQue(Data datas){
		if(ano < datas.ano) {
			if (mes < datas.mes) {
				if(dia < datas.dia) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return true;
	}
	public boolean maiorDoQue(Data datas){
		if (ano > datas.ano) {
			if(mes > datas.mes) {
				if(dia > datas.dia) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
	public void escreve() {
		 System.out.printf("%02d-%02d-%04d\n", dia(), mes(), ano());
	}
}