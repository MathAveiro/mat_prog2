public class Switch{

	private Switch ports[];
	private int nrPorts;
	
	
		public int nrPorts(){
			return nrPorts;
		}
		
		public Switch(int nrPorts){
						// correto
			assert nrPorts > 0: "Invalid number of ports for a switch";
						
			ports=new Switch[nrPorts];
			
		}
		
		public int freePort(){
				// correto
			assert freePorts()!=0: "No free ports";
			
			int port= -1;
						// correto
			for(int i=0; i<ports.length; i++){
				if(ports[i] == null){ // correto
					port =i;
					break;
				}
			}
			
			assert port >=0 && port<nrPorts: "Internal error!"; //  está errado mas nao sei o que usar
			
			return port;
		}
		
		public int freePorts(){
		
			int result =0;
							// correto
			for(int i=0; i<ports.length; i++){
				if(ports[i]==null){
					result++;
				}
			}
			
			return result;
		}
		
		public boolean connect(Switch s){
		
			assert s!=null: "Invalid argument";
			assert s!=this: "Switches should not connect to themselves";
				// asserts corretos
			
			if(freePorts()==0 || s.freePort()==0) // correto
				return false;
				
			int totalFreePorts= freePorts() + s.freePorts();
			
			ports[freePort()]=s;
			
			s.ports[s.freePort()] = s; // não tenho a certeza se é s 
			
			assert totalFreePorts == freePorts() + s.freePorts(): "Internal error";
			
			return true;
		}
}
