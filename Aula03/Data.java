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
	public boolean igualA(Data a){
		if(a.ano()==ano()) {
			if(a.mes()==mes()) {
				if(a.dia()==dia()) {
					return true;
				}
				else return false;
			}
			else return false;
		}
		else return false;
	}
	public boolean maiorDoQue(Data a){
   		if(ano()<a.ano()) return false;
   		else if (ano()>a.ano()) return true;
   		else {
   			if(mes()<a.mes()) return false;
   			else if (mes()>a.mes()) return true;
   			else {
   				if(dia()>a.dia()) return true;
   				else return false;
   			}
   		}
   		
	}
	public boolean menorDoQue(Data a){
    	if(ano()>a.ano()) return false;
    	else if(ano()<a.ano()) return true;
    	else {
    		if(mes()>a.mes()) return false;
    		else if (mes()<a.mes()) return true;
    		else {
    			if(dia()<a.dia()) return true;
    			else return false;
    		}
    	}
   		
	}
	public void escreve() {
		 System.out.printf("%02d-%02d-%04d", dia(), mes(), ano());
	}
	public String getData() {
		 String data=dia()+"-"+mes()+"-"+ano();
		 return data;
	}
}