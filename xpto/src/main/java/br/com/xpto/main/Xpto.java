package br.com.xpto.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import br.com.xpto.model.Maquina;
import br.com.xpto.rest.RequestCliente;

//Tarefa 1:
//Verificar se a máquina já está cadastrada

//Tarefa 2:
//Caso não exista fazer com que a maquina seja cadastrada 

public class Xpto {
	
	public static void main(String[] args) {
		
		//Teste
		/*RequestCliente rc = new RequestCliente();
		if(!rc.verificaExistenciaMaquina("PE02DEC3")) {
			
			String hostname = "";
			try {
				hostname = InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rc.insereMaquina(new Maquina("WRTYAAA",hostname));
		}*/
	}
}
