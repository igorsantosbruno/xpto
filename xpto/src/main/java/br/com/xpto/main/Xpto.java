package br.com.xpto.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import br.com.xpto.model.Cadastro;
import br.com.xpto.parameter.Main;
import br.com.xpto.parameter.ParameterHD;
import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.Hardware;
import br.com.xpto.util.SistemaOperacional;
import java.lang.Runnable;

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

	public static void main(String[] args) {

		Hardware hardware = new Hardware();
		RequestCliente rc = new RequestCliente();
		String resposta = rc.retornaExistenciaMaquina(hardware.obterCodigoCPU());
		switch (resposta) {

		case "erro":
			System.exit(0);
			break;

		case "null":
			cadastro();
			break;
		default:
			// inicia
			System.out.println("Inicia");
			break;
		}
	}

	public static void cadastro() {

		Hardware hardware = new Hardware();
		SistemaOperacional so = new SistemaOperacional();
		RequestCliente rc = new RequestCliente();
		Cadastro cadastro = new Cadastro(hardware.obterCodigoCPU(), so.obterHostName(), hardware.obterDataFabricao(),
				hardware.obterFabricante(), hardware.obterModelo(), hardware.obterModeloEspecifico(),
				hardware.obterCodigoCPU(), hardware.obterDescricaoCPU(), hardware.obterIdentificadorCPU(),
				hardware.obterQuantidadeCPUFisica(), hardware.obterQuantidadeCPULogica(), hardware.obterTotalRAM(),
				so.obterArquitetura(), so.obterDescricao(), so.obterNomeDeUsuarioLogado());
		rc.cadastro(cadastro);
	}

}

