package it.wallet.pojo;

import java.util.Objects;

public class Movimenti {

	private String tipo;
	private double importo;
	private String data;
	private int ibanMov;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getIbanMov() {
		return ibanMov;
	}
	public void setIbanMov(int ibanMov) {
		this.ibanMov = ibanMov;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ibanMov);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimenti other = (Movimenti) obj;
		return ibanMov == other.ibanMov;
	}
	
	
}
