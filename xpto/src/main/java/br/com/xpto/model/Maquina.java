package br.com.xpto.model;

public class Maquina {
	
	private String serial;
	private String clienteHostname;
	
	public Maquina() {
		
		this.serial = "";
		this.clienteHostname = "";
	}
	
	

	public Maquina(String serial, String clienteHostname) {
		
		this.serial = serial;
		this.clienteHostname = clienteHostname;
	}



	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getClienteHostname() {
		return clienteHostname;
	}

	public void setClienteHostname(String clienteHostname) {
		this.clienteHostname = clienteHostname;
	}

	@Override
	public String toString() {
		return "Maquina [serial=" + serial + ", clienteHostname=" + clienteHostname + "]";
	}
}