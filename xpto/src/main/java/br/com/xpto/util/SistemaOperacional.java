package br.com.xpto.util;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SistemaOperacional {
	
	public SistemaOperacional() {
		
	}
	
	public String obterDescricao() {
		
		SystemInfo si = new SystemInfo();
		OperatingSystem os = si.getOperatingSystem();
		return os.toString();
	}
	
	public String obterNomeDeUsuarioLogado() {
		
		return System.getProperty("user.name");
	}
	
	public String obterArquitetura() {
		
		return System.getProperty("os.arch");
	}
}










