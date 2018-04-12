package br.com.xpto.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import br.com.xpto.model.CadastroComponente;
import br.com.xpto.model.Maquina;
import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.Hardware;

//Tarefa 1:
//	- Verificar se a máquina já está cadastrada

//Tarefa 2:
//	- Caso não exista fazer com que a maquina seja cadastrada (serial e hostname atrelado ao cliente)

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

public class Xpto {

	public static void main(String[] args) {

		Hardware hardware = new Hardware();
		RequestCliente rc = new RequestCliente();
		String codigoCPU = hardware.obterCodigoCPU();
		if (!rc.verificaExistenciaMaquina(codigoCPU)) {

			String hostname = "";
			try {
				hostname = InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rc.insereMaquina(new Maquina(codigoCPU, hostname));
			rc.cadastroInicial(construirCadastroComponente());
		}
	}

	public static CadastroComponente construirCadastroComponente() {

		Hardware util = new Hardware();
		return new CadastroComponente(util.obterFabricante(), util.obterModelo(), util.obterDataFabricao(),
				util.obterModeloEspecifico(), util.obterDescricaoCPU(),
				Integer.parseInt(util.obterQuantidadeCPUFisica()), Integer.parseInt(util.obterQuantidadeCPULogica()),
				util.obterIdentificadorCPU(), util.obterCodigoCPU());
	}
}






