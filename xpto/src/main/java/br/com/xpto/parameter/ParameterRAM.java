package br.com.xpto.parameter;

import java.text.DecimalFormat;

import br.com.xpto.rest.RequestCliente;
import br.com.xpto.util.SistemaOperacional;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

public class ParameterRAM {

	private final SystemInfo si;
	private final HardwareAbstractionLayer hal;
	private final GlobalMemory memory;

	public ParameterRAM() {

		this.si = new SystemInfo();
		this.hal = si.getHardware();
		this.memory = hal.getMemory();
	}

	public void obterRamEmUsoPorcentagem() {
		float ramTotal = (float) memory.getTotal();
		float ramDisponivel = (float) memory.getAvailable();
		float ramUtilizada = (ramTotal - ramDisponivel);
		float ramUsada = (ramUtilizada / ramTotal) * 100;
		DecimalFormat fmt = new DecimalFormat("0");
		String str = fmt.format(ramUsada);
		if (ramUsada >= 80) {
			System.out.println(str + "%" + " - RAM com pouco espaço");
			RequestCliente rc = new RequestCliente();
			SistemaOperacional so = new SistemaOperacional();
			rc.enviarMensagemSlack(rc.retornaCanal(so.obterHostName()), str + "%" +" RAM sendo consumida além do estimado");
		} else {
			System.out.println(str + "%" + " - Ok");
		}
	}

}
