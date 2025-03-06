package com.auth;

public class Credencial {
	private String username;
	private String password;
	private static int secuencia = 99;
	
	public Credencial(String nombre, String apellidos, String password) {
		super();
		this.username = (nombre.substring(0, 3)+apellidos.substring(0, 3)).toLowerCase()+String.valueOf(secuencia++);
		this.password = password;
	}
	
	public boolean comprobarPassword(String password) {
		return password.equals(this.password);
	}

	public String getUsername() {
		return this.username;
	}
	
	public boolean esPasswordSegura() {
		boolean verdaderoNum = false;
		boolean verdaderoMay = false;
		boolean verdaderoMin = false;
		for(int i=0; i<=this.password.length() || (verdaderoNum && verdaderoMay && verdaderoMin); i++) {
			verdaderoNum = Character.isDigit(this.password.charAt(i))?true:verdaderoNum;
			verdaderoMay = Character.isUpperCase(this.password.charAt(i))?true:verdaderoMay;
			verdaderoMin = Character.isLowerCase(this.password.charAt(i))?true:verdaderoMin;
		}
		return this.password.length() >= 8 && verdaderoNum && verdaderoMay && verdaderoMin;
	}

	public void setPassword(String newpass) {
		this.password = newpass;
	}

	@Override
	public String toString() {
		return "username " + username + " y password=" + "*".repeat(password.length())+ ".";
	}
}
