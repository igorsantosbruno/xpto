package br.com.xpto.model;

import java.util.ArrayList;
import java.util.List;

public class GravarMonitoramento {
	
	private double temperaturaCpu;
	private double percentualRam;
	
	private String serial;
	
	private List<MonitoramentoHd> listaDisco;
	
	public GravarMonitoramento() {
		
		this.temperaturaCpu = 0;
		this.percentualRam = 0;
		
		this.listaDisco = new ArrayList<>();
	}
	
	public GravarMonitoramento(double consumoCpu, double percentualRam, String serial, List<MonitoramentoHd> listaDisco) {
		
		this.temperaturaCpu = consumoCpu;
		this.percentualRam = percentualRam;
		this.serial = serial;
		this.listaDisco = listaDisco;
	}

	public double getPercentualRam() {
		return percentualRam;
	}

	public void setPercentualRam(double percentualRam) {
		this.percentualRam = percentualRam;
	}

	public double getTemperaturaCpu() {
		return temperaturaCpu;
	}

	public void setTemperaturaCpu(double temperaturaCpu) {
		this.temperaturaCpu = temperaturaCpu;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public List<MonitoramentoHd> getListaDisco() {
		return listaDisco;
	}

	public void setListaDisco(List<MonitoramentoHd> listaDisco) {
		this.listaDisco = listaDisco;
	}

	
}
