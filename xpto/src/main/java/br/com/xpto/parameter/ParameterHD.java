package br.com.xpto.parameter;

import java.io.File;
import java.text.DecimalFormat;

public class ParameterHD {
	public void obterInfoHD() {

		File[] discos = File.listRoots();
		//List<Float> list = new ArrayList<Float>();

		for (File disco : discos) {
			if (disco.getTotalSpace() != 0) {
				float teste = (float) disco.getUsableSpace();
				float teste2 = (float) disco.getTotalSpace();
				float resultado = (teste / teste2) * 100;
				DecimalFormat fmt = new DecimalFormat("0");
				String str = fmt.format(resultado);
				if (resultado < 10) {
					System.out.println(str + "% " + disco.getAbsolutePath() + " - Espaço de armazenamento insuficiente");
				} else {
					System.out.println(str + "% " + disco.getAbsolutePath() + " - Espaço de armazenamento ok");
				}
			}
		}
	}
}