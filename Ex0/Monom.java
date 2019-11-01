import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	
	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative() {
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
	public double f(double x) {
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 
	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************

	
	/**The monot constractor. make a monom out of string, there are two main casses in the first one where the String has at list
	 * an x with power of one, and the second case is where we have only real numbers...........matanya feel this up pleas ;)
	 * 
	 * @param s
	 */
	public Monom(String s) {
	double coff=0;
	int pow=0;
	String sCoff="";
	String sPow="";

	if (!s.contains("x")){
//        Double.parseDouble(s)>=0||Double.parseDouble(s)<0)
            coff=Double.parseDouble(s);
            this.set_power(0);
            this.set_coefficient(coff);
    }

		if (s.charAt(0)=='x') {
		    this.set_coefficient(1);
			if (s.length()==1) {this.set_power(1);}
			else {
				sPow=s.substring(s.indexOf('^')+1);
				pow=Integer.parseInt(sPow);
				this.set_power(pow);
			}
		}

		if (s.charAt(0)=='-'&&s.charAt(1)=='x') { this.set_coefficient(-1);
			if (s.length()==2) {this.set_power(1);}
			else {
				sPow=s.substring(s.indexOf('^')+1);
				pow=Integer.parseInt(sPow);
				this.set_power(pow);
			}
		}

//        else if (Double.parseDouble(s)>=0||Double.parseDouble(s)<0){
//                this.set_power(0);
//                this.set_coefficient(Double.parseDouble(s));
//        }

        else if (s.charAt(s.length()-1)=='x'){
            this.set_power(1);
                sCoff=s.substring(0,'x');
                coff=Double.parseDouble(sCoff);
                this.set_coefficient(coff);
        }
        else{
            sCoff=s.substring(0,'x');
            coff=Double.parseDouble(sCoff);
            this.set_coefficient(coff);
            sPow=s.substring(s.indexOf('^')+1);
            pow=Integer.parseInt(sPow);
            this.set_power(pow);
        }







	}
	
	public void add(Monom m) {
	
		//case 1 they have same coeficent
		if (this._coefficient==m._coefficient) {
			this._coefficient+=m._coefficient; // adding bouth coeficient 
		}
		
		
		// when the user tries to add a difrrent coeficent monoms that woud have make a polynom
		else {
			{throw new RuntimeException("your addind a diffrent coeficent monom, use the polynom function ! "+p);}
			
		}
		
		
		
		
		
	}
	
	public void multipy(Monom d) {
		
		//case 1 they have same coeficent * the coeficent's 
		if (this._coefficient==m._coefficient) {
			this._coefficient*=m._coefficient; // multyplieng bouth coeficient 
		}
		
		
		// when the user tries to add a difrrent coeficent monoms that woud have make a polynom
		else {
			{throw new RuntimeException("your addind a diffrent coeficent monom, use the polynom function ! "+p);}
			
		}	
		
		
		
		
		
		
		
	}
	
	public String toString() {
		String ans = this._coefficient+"x^"+this._power;
		return ans;
	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************
	

	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;
	
	
}
