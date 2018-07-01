public class CalculoDP{
	
	public float gradosCF(float c){
		
		float f = (float)9/5*c+32;
		return f; 
	}
	
	public float gradosFC(float f){
		
		float c = (float)5/9*f-32;
		return c; 
	}
	
	public int factorial(int n){
		
		int f=1;
		
		for(int i=1;i<=n;i++){
			f=f*i;
		}
		return f;
	}
	
	public int exponencial(int n,int e){
		
		int r=1;
		
		for(int i=1;i<=e;i++)
		{
			r=r*n;
		}
		return r;
	}
	
	public double lineal(double a,double b ,double c){
		
		double x = -c/b;
		return x;
	}
	
	public double resultadoI(double a,double b ,double c){
		
		double i = (b*b)-(4*a*c);
		return i;
		
	}
	
	public double raizUno(double a,double b ,double c, double i){
		
		double x = ((-(b)) + Math.sqrt(i))/(2*a);
		return x;
	}
	
	public double raizDos(double a,double b ,double c, double i){
		
		double x = ((-(b)) - Math.sqrt(i))/(2*a);
		return x;
	}
	
	
	 public int tabla1(int n)
    { 	
  
			
			int x1; 
 			
 			x1 = n*1;
 			
 			return x1;
    	}
    	
    public int tabla2(int n)
    { 	
  
			
			int x2;
 			
 			x2 = n*2;
 			
 			return x2;
    }
    
    public int tabla3(int n)
    { 	
  
			
			int x3; 
 			
 			x3 = n*3;
 			
 			return x3;
    }
    
    public int tabla4(int n)
    { 	
  
			
			int x4; 
 			
 			x4 = n*4;
 			
 			return x4;
    }
    
    public int tabla5(int n)
    { 	
  
			
			int x5; 
 			
 			x5 = n*5;
 			
 			return x5;
    }
    
    public int tabla6(int n)
    { 	
  
			
			int x6; 
 			
 			x6 = n*6;
 			
 			return x6;
    }
    
    public int tabla7(int n)
    { 	
  
			int x7; 
 			
 			x7 = n*7;
 			
 			return x7;
    }
    
    public int tabla8(int n)
    { 	
  
			
			int x8; 
 			
 			x8 = n*8;
 			
 			return x8;
    }
    
    public int tabla9(int n)
    { 	
  
			
			int x9; 
 			
 			x9 = n*9;
 			
 			return x9;
    }
    
    public int tabla10(int n)
    { 	
  
			
			int x10;
 			
 			x10 = n*10;
 			
 			return x10;
    }
	
}