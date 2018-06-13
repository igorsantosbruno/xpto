package br.com.xpto.parameter;

import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.SistemaOperacional;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;

public class ParameterCPU {
	
	private final SystemInfo si;
	private final HardwareAbstractionLayer hal;
	private final Sensors sensors;

	public ParameterCPU() {
		
		this.si = new SystemInfo();
		this.hal = si.getHardware();
		this.sensors = hal.getSensors();
	}
	
	public void obterTemperaturaProcessador() {
		double cpuTemperatura = (this.sensors.getCpuTemperature());
		if (cpuTemperatura > 80) {
			RequestCliente rc = new RequestCliente();
			SistemaOperacional so = new SistemaOperacional();
			rc.enviarMensagemSlack(rc.retornaCanal(so.obterHostName()), cpuTemperatura + "ºC" + " Processador acima da temperatura estimada!");
		} else {
			System.out.println(cpuTemperatura + "ºC - OK");
		}
	}

}
