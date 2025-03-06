package com.auth;

public class Usuario {
	private static final int MAX_NUM_INTENTOS = 3;
	private String nombre;
	private String apellidos;
	private String email;
	private int intentos;
	private Credencial credencial;
	
	public Usuario(String nombre, String apellidos, String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.intentos = 0;
		this.credencial = new Credencial(nombre, apellidos, password);
	}
	
	public Usuario(String nombre, String apellidos, String email, String password) {
		this(nombre, apellidos, password);
		this.email = email;
	}
	
	public boolean esCuentaBloqueada() {
		return this.intentos >= MAX_NUM_INTENTOS;
	}
	
	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public boolean modificarPassword(String oldpass, String oldpassVerif, String newpass, String newPassVerif) {
		boolean resultado = (oldpass.equals(oldpassVerif) && newpass.equals(newPassVerif) && !oldpass.equals(newpass))?true:false;
		if (resultado) {
			this.credencial.setPassword(newpass);
		}
		return resultado;
	}
	
	public boolean esPasswordSegura() {
		return this.credencial.esPasswordSegura();
	}
	
	public boolean hacerLogin(String username, String password) {
		boolean resultado = (this.credencial.getUsername().equals(username) && this.credencial.comprobarPassword(password) && !esCuentaBloqueada());
		this.intentos += resultado?-this.intentos:1;
		return resultado;
	}

	@Override
	public String toString() {
		return "Usuari@: " + this.nombre + " " + this.apellidos + " con email=" + this.email + ", " + this.credencial.toString();
	}
	
	
	public String getNombre() {
	    return nombre;
	}

	public String getApellidos() {
	    return apellidos;
	}

	public String getEmail() {
	    return email;
	}
	
	
	
	
	
}
