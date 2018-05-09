package br.com.xpto.parameter;

import br.com.xpto.util.Hardware;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// Informa��o do HD
					ParameterHD hd = new ParameterHD();
					hd.obterInfoHD();

					// Informa��o da RAM
					Hardware Ram = new Hardware();
					Ram.obterRamEmUsoPorcentagem();
					
					// Informa��o CPU
					Hardware Cpu = new Hardware();
					Cpu.obterTemperaturaProcessador();
				}
			}).start();
			Thread.sleep(10000);
		}
	}
}
