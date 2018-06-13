package br.com.xpto.parameter;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.xpto.model.MonitoramentoHd;
import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.SistemaOperacional;



public class ParameterHD {
	public void obterInfoHD() {
				

		File[] discos = File.listRoots();

		for (File disco : discos) {
			
			List<MonitoramentoHd> HD = new ArrayList<>();
			
			if (disco.getTotalSpace() != 0) {
				float SpaceUsed = (float) disco.getUsableSpace();
				float SpaceTotal = (float) disco.getTotalSpace();
				float resultado = (SpaceUsed / SpaceTotal) * 100;
				DecimalFormat fmt = new DecimalFormat("0");
				String str = fmt.format(resultado);
				String teste = str + "% " + disco.getAbsolutePath();
				if (resultado < 10) {
					RequestCliente rc = new RequestCliente();
					SistemaOperacional so = new SistemaOperacional();
					rc.enviarMensagemSlack(rc.retornaCanal(so.obterHostName()), teste + " Espaço de armazenamento do HD insuficiente");
				} else {
					System.out.println(teste + " - Espaço de armazenamento ok");
				}
				HD.add(new MonitoramentoHd(resultado,str));
				
			}

		}
	}
}