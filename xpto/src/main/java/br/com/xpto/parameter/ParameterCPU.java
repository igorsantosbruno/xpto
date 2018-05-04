package br.com.xpto.parameter;

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
		System.out.println(cpuTemperatura);
		if (cpuTemperatura > 80) {
			System.out.println("Aquecendo!");
		} else {
			System.out.println("OK");
		}
	}
}
