public class Statistics{

	private double data[];
	private int n;
	private final int BLOCK = 16;
	
	public Statistics(){
		
		data= new double[BLOCK];
		n=0;
	}
	
	private void resize(int delta){
		
		if(data.length>=n+delta)
			return;
		
					// correto
		double copy[] = data;
		
		data = new double [n+delta+BLOCK];
		
						// correto
		for(int i=0; i<data.length; i++)
			data[i]=copy[i];
			
	}
	
	public int add(double x){
		// correto
		resize(1);
		
		data[n++]=x;
		
		return n;
	}
							// correto
	public int add(double [] x) throws IllegalArgumentException{
		// correto
		if(x==null)		// correto
			throw new IllegalArgumentException("Null reference");	
	
		resize(x.length);
		
		for(int i=0; i<x.length; i++)
			data[n++]=x[i];
	
		return n;
	}
						// correto
	public double average() throws IllegalArgumentException{
		// correto
		if(n==0)		// correto
			throw new IllegalArgumentException("Empty data set");
			//correto
		double sum=0;
		
		for(int i=0; i<n; i++)
			sum+=data[i];
	
		return sum/n;
			
	}
	
}
	
