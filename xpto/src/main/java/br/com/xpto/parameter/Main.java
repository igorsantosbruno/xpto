package br.com.xpto.parameter;

import java.lang.Runnable;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// Informa��o do HD
					ParameterHD HD = new ParameterHD();
					HD.obterInfoHD();

					// Informa��o da RAM
					ParameterRAM Ram = new ParameterRAM();
					Ram.obterRamEmUsoPorcentagem();
					
					// Informa��o CPU
					ParameterCPU Cpu = new ParameterCPU();
					Cpu.obterTemperaturaProcessador();
				}
			}).start();
			Thread.sleep(10000);
		}
	}
}
