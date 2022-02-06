package it.wallet.pojo;

import it.wallet.rest.GestioneEwallet;

public class ContoCorrente {
	private int iban;
	private String dataCreazione;
	private double saldo;
	private String intestatario;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return iban == other.iban;
	}
	
	public int getIban() {
		return iban;
	}
	public void setIban(int iban) {
		this.iban = iban;
	}
	public String getDataCreazione() {
		return dataCreazione;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}
		
	
}
