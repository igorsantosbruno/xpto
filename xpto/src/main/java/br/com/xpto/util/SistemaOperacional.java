package br.com.xpto.util;

import java.net.InetAddress;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class SistemaOperacional {

	public SistemaOperacional() {

	}

	public String obterDescricao() {

		SystemInfo si = new SystemInfo();
		OperatingSystem os = si.getOperatingSystem();
		return os.toString();
	}

	public String obterNomeDeUsuarioLogado() {

		return System.getProperty("user.name");
	}

	public String obterArquitetura() {

		return System.getProperty("os.arch");
	}

	public String obterHostName() {

		try {

			return InetAddress.getLocalHost().getHostName();
		} catch (java.net.UnknownHostException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
