package br.com.xpto.parameter;

import java.text.DecimalFormat;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class ParameterRAM {

	private final SystemInfo si;
	private final HardwareAbstractionLayer hal;
	private final GlobalMemory memory;

	public ParameterRAM() {

		this.si = new SystemInfo();
		this.hal = si.getHardware();
		this.memory = hal.getMemory();
	}

	public void obterRamEmUsoPorcentagem() {
		float ramTotal = (float) memory.getSwapTotal();
		float ramDisponivel = (float) memory.getAvailable();
		float ramUtilizada = (ramTotal / ramDisponivel) * 100;
		DecimalFormat fmt = new DecimalFormat("0");
		String str = fmt.format(ramUtilizada);
		if (ramUtilizada >= 80) {
			System.out.println(str + "%" + " - RAM com pouco espaço");
		} else {
			System.out.println(str + "%" + " - Ok");
		}
	}

}
