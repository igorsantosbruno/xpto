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

	// RAM info:
	public long obterTotalRAM() {
		return memory.getSwapTotal();
	}

	public long obterTotalDisponivelRAM() {
		return memory.getAvailable();
	}

	public long obterRamEmUso() {
		return memory.getSwapUsed();
	}

	public void obterRamEmUsoPorcentagem() {
		float ramTotal = (float) memory.getSwapTotal();
		float ramDisponivel = (float) memory.getAvailable();
		float ramUtilizada = (ramTotal / ramDisponivel) * 100;
		DecimalFormat fmt = new DecimalFormat("0");
		String str = fmt.format(ramUtilizada);
		System.out.println(str + "%");
		if (ramUtilizada >= 80) {
			System.out.println("RAM com pouco espaço");
		} else {
			System.out.println("Ok");
		}
	}
}
