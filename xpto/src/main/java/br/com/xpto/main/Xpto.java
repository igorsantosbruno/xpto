package br.com.xpto.main;

import br.com.xpto.model.Cadastro;
import br.com.xpto.model.GravarMonitoramento;
import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.Hardware;
import br.com.xpto.util.SistemaOperacional;

//Igor
//Tarefa 1:
//	- Verificar se a máquina já está cadastrada

//Igor
//Tarefa 2:
//	- Caso não exista fazer com que a maquina seja cadastrada (serial e hostname atrelado ao cliente)

//Igor
//Tarefa 3:
//	- Carregar informações estaticas da maquina  caso a maquina não esteja cadastrada, sendo estas:
//Fabricante:
//	nome
// 	modelo
//	Data de fabricação
// 	Modelo específico
//------------------------------------------------------------------------------------------------
//CPU:
//	descricao
//	Quantidade fisica 
//	Quantidade lógica
// 	Identificador
//	Código

// Fábio
//Tarefa 4:
//	- Criar processo de monitoramento
//	* Parametrizar as informações de acordo com a monitoração
//	* Criar condição de alerta quando estiver fora da parametrização

public class Xpto {

	public static void main(String[] args) throws InterruptedException {

		Hardware hardware = new Hardware();
		RequestCliente rc = new RequestCliente();
		String resposta = rc.retornaExistenciaMaquina(hardware.obterCodigoCPU());
		switch (resposta) {

		case "erro":
			System.exit(0);
			break;

		case "null":
			cadastro();
			envioInfoHardware();
			break;
		default:
			// inicia
			System.out.println("Inicia");
			envioInfoHardware();

			break;
		}
	}

	public static void cadastro() {

		Hardware hardware = new Hardware();
		SistemaOperacional so = new SistemaOperacional();
		RequestCliente rc = new RequestCliente();
		String hostname = so.obterHostName();
		if(hostname.contains("HSL"))
			hostname = "HSL";
		Cadastro cadastro = new Cadastro(hardware.obterCodigoCPU(), hostname, hardware.obterDataFabricao(),
				hardware.obterFabricante(), hardware.obterModelo(), hardware.obterModeloEspecifico(),
				hardware.obterCodigoCPU(), hardware.obterDescricaoCPU(), hardware.obterIdentificadorCPU(),
				hardware.obterQuantidadeCPUFisica(), hardware.obterQuantidadeCPULogica(), hardware.obterTotalRAM(),
				so.obterArquitetura(), so.obterDescricao(), so.obterNomeDeUsuarioLogado());
		rc.cadastro(cadastro);
	}

/*public static void envioInfoHardware() throws InterruptedException {

		while (true) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					Hardware hardware = new Hardware();
					System.out.println(hardware.obterCodigoCPU());
					System.out.println(hardware.retornaPercentualRamUtilizado());
					System.out.println(hardware.retornaTemperaturaProcessador());
					GravarMonitoramento monitoramento = new GravarMonitoramento(
							hardware.retornaTemperaturaProcessador(), hardware.retornaPercentualRamUtilizado(),
							hardware.obterCodigoCPU(), hardware.retornaDiscos());
					RequestCliente rc = new RequestCliente();
					rc.gravarMonitoramento(monitoramento);
					// Post
				}

			}).start();
			Thread.sleep(10000);
		}
	}*/
	public static void envioInfoHardware() throws InterruptedException {
		for (;;) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (;;) {
						Hardware hardware = new Hardware();
						System.out.println(hardware.obterCodigoCPU());
						System.out.println(hardware.retornaPercentualRamUtilizado());
						System.out.println(hardware.retornaTemperaturaProcessador());
						GravarMonitoramento monitoramento = new GravarMonitoramento(
								hardware.retornaTemperaturaProcessador(), hardware.retornaPercentualRamUtilizado(),
								hardware.obterCodigoCPU(), hardware.retornaDiscos());
						RequestCliente rc = new RequestCliente();
						rc.gravarMonitoramento(monitoramento);
						// Post
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							return;
						}
					}
				}
				
			});
			thread.start();
			thread.join();
			Thread.sleep(10000);
		}
	}
}
