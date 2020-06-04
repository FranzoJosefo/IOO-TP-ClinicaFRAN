package clases;

public class Edad {

	  private final int edad;
	  
	  private Edad(int value) {
	    edad = value;
	  }
		  
	  
	  public static Edad valueOf(int value) throws Exception {
	     if(value < 0) {
	        throw new Exception("Edad inválida");
	     }
	     return new Edad(value);
	  }
	  
	  public int edadAsInteger() {
		  return edad;
	  }
	
}
