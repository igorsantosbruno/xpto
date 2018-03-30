package teste;

import java.util.List;

import br.com.xpto.util.Hardware;

public class TesteHardware {

	public static void main(String[] args) {

		Hardware hardware = new Hardware();
		// Fabricante info:
		System.out.println("Fabricante:" + hardware.obterFabricante());
		System.out.println("Data de fabricação:" + hardware.obterDataFabricao());
		System.out.println("Modelo:" + hardware.obterModelo());
		System.out.println("Modelo específico:" + hardware.obterModeloEspecifico());

		// CPU info:
		System.out.println("Descrição CPU:" + hardware.obterDescricaoCPU());
		System.out.println("Quantidade de CPU(s) física:" + hardware.obterQuantidadeCPUFisica());
		System.out.println("Quantidade de CPU(s) lógica:" + hardware.obterQuantidadeCPULogica() + " CPU(s)");
		System.out.println("Identificador CPU:" + hardware.obterIdentificadorCPU());
		System.out.println("Código CPU:" + hardware.obterCodigoCPU());
		System.out.println("Consumo geral CPU:" + hardware.obterConsumoCPU() + "%");
		System.out.println("Temperatura CPU:" + hardware.obterTemperaturaProcessador() + "°C");
		List<String> processos = hardware.obterProcessos();
		System.out.println("Lista de Processo:");
		processos.forEach(processo -> System.out.println(processo));

		// RAM info:
		System.out.println("Total RAM:" + hardware.obterTotalRAM());
		System.out.println("Total disponível RAM:" + hardware.obterTotalDisponivelRAM());

		// HD info:
		List<String> discos = hardware.obterInfoHD();
		System.out.println("Disco(s) info:");
		discos.forEach(disco -> System.out.println(disco));
	}
}
