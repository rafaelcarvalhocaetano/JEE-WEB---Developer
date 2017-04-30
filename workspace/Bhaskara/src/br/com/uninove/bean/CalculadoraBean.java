package br.com.uninove.bean;

import com.sun.org.apache.regexp.internal.recompile;

public class CalculadoraBean {

	private String a, b, c;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public double delta() {

		try {
			double da, db, dc;

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
			dc = Double.parseDouble(c);

			double delta = (db * db) - 4 * da * dc;
			return delta;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
	
	public String raizPositiva(){
		try {
			double da, db, dc;

			da = Double.parseDouble(a);
			db = Double.parseDouble(b);
			dc = Double.parseDouble(c);

			if(delta() < 0 ){
				return "Delta é negativo";
			}else{
				double raizPositiva;
				raizPositiva = ( -db + Math.sqrt(delta()) ) / (2 * da);
				return String.valueOf(raizPositiva);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}

	}

}
