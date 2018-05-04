package br.com.xpto.parameter;

import java.io.File;
import java.text.DecimalFormat;

public class ParameterHD {
	public void obterInfoHD() {

		// Classe onde coleta as informações do HD e faz a comparação do valor total
		// menos o valor em uso
		// depois multiplicado por 100 para se obter o valor da porcentagem disponível
		// do HD e assim fazer
		// respectivamente o envio de mensagem caso aconteça da quantidade disponível
		// esteja quase "nula".

		File[] discos = File.listRoots();

		for (File disco : discos) {
			if (disco.getTotalSpace() != 0) {
				float teste = (float) disco.getUsableSpace();
				float teste2 = (float) disco.getTotalSpace();
				float resultado = (teste / teste2) * 100;
				DecimalFormat fmt = new DecimalFormat("0");
				String str = fmt.format(resultado);
				System.out.println(str + "%");
				if (resultado < 10) {
					System.out.println("Espaço de armazenamento insuficiente");
				} else {
					System.out.println("Espaço de armazenamento ok");
				}
			}
		}
	}
}