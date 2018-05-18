package br.com.xpto.parameter;


public class Main {

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					// Informação do HD
					ParameterHD hd = new ParameterHD();
					hd.obterInfoHD();

					// Informação da RAM
					ParameterRAM Ram = new ParameterRAM();
					Ram.obterRamEmUsoPorcentagem();
					
					// Informação CPU
					ParameterCPU Cpu = new ParameterCPU();
					Cpu.obterTemperaturaProcessador();
					
				}
			}).start();
			Thread.sleep(10000);
		}
	}
}
