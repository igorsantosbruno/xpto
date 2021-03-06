package br.com.xpto.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.xpto.model.MonitoramentoHd;
import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Firmware;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.FormatUtil;

public class Hardware {

	private final SystemInfo si;
	private final HardwareAbstractionLayer hal;
	private final CentralProcessor processor;
	private final ComputerSystem computerSystem;
	private final Firmware firmware;
	private final Baseboard baseboard;
	private final Sensors sensors;
	private final OperatingSystem os;
	private final GlobalMemory memory;

	public Hardware() {

		this.si = new SystemInfo();
		this.hal = si.getHardware();
		this.processor = hal.getProcessor();
		this.computerSystem = hal.getComputerSystem();
		this.firmware = computerSystem.getFirmware();
		this.baseboard = computerSystem.getBaseboard();
		this.sensors = hal.getSensors();
		this.os = si.getOperatingSystem();
		this.memory = hal.getMemory();
	}

	// Fabricante info:
	public String obterFabricante() {

		return this.computerSystem.getManufacturer();
	}

	public String obterModelo() {

		return this.computerSystem.getModel().replace("version", "versão");
	}

	public String obterDataFabricao() {

		return (this.firmware.getReleaseDate() == null ? "restrita"
				: FormatUtil.formatDate(this.firmware.getReleaseDate()));
	}

	public String obterModeloEspecifico() {

		return this.baseboard.getModel();
	}

	// CPU info:
	public String obterDescricaoCPU() {

		return this.processor.toString();
	}

	public String obterQuantidadeCPUFisica() {

		return "" + this.processor.getPhysicalProcessorCount();
	}

	public String obterQuantidadeCPULogica() {

		return "" + this.processor.getLogicalProcessorCount();
	}

	public String obterIdentificadorCPU() {

		return this.processor.getIdentifier();
	}

	public String obterCodigoCPU() {

		return this.processor.getProcessorID();
	}

	// -------- Inicio CPU info a ser monitorada --------
	public String obterConsumoCPU() {

		DecimalFormat df = new DecimalFormat("0.#");
		String cpuConsumo = df.format(this.processor.getSystemCpuLoadBetweenTicks() * 100);
		return cpuConsumo;
	}

	public String obterTemperaturaProcessador() {

		DecimalFormat df = new DecimalFormat("0.#");
		String cpuTemperatura = df.format(this.sensors.getCpuTemperature());
		return cpuTemperatura;
	}

	public double retornaTemperaturaProcessador() {

		return this.sensors.getCpuTemperature();
	}

	// -------- FIM --------

	public List<String> obterProcessos() {

		List<OSProcess> procs = Arrays.asList(os.getProcesses(5, ProcessSort.CPU));
		List<String> processos = new ArrayList<String>();
		for (int i = 0; i < procs.size() && i < 5; i++) {

			OSProcess p = procs.get(i);
			processos.add("Memória consumida = " + FormatUtil.formatBytes(p.getResidentSetSize()) + " / Processo = "
					+ p.getName());
		}
		return processos;
	}

	// RAM info:
	public String obterTotalRAM() {

		return FormatUtil.formatBytes(memory.getTotal());
	}

	public String obterTotalDisponivelRAM() {

		return FormatUtil.formatBytes(memory.getAvailable());
	}

	public float retornaPercentualRamUtilizado() {

		float ramTotal = (float) memory.getTotal();
		float ramDisponivel = (float) memory.getAvailable();
		float ramUtilizada = (ramTotal - ramDisponivel);
		float ramUsada = (ramUtilizada / ramTotal) * 100;
		DecimalFormat fmt = new DecimalFormat("0");
		String str = fmt.format(ramUsada);
		return Float.parseFloat(str);
	}

	// HD info:
	public List<String> obterInfoHD() {

		File[] discos = File.listRoots();
		List<String> listaDisco = new ArrayList<String>();
		for (File disco : discos) {

			String nomeDisco = "Disco local";
			if (!disco.getName().equals("")) {

				nomeDisco = disco.getName();
			}
			listaDisco.add("Caminho absoluto = " + disco.getAbsolutePath() + " - " + nomeDisco + " - " + "Total:"
					+ FormatUtil.formatBytes(disco.getTotalSpace()) + " / Total disponível:"
					+ FormatUtil.formatBytes(disco.getFreeSpace()));
		}
		return listaDisco;
	}

	public List<MonitoramentoHd> retornaDiscos() {

		File[] discos = File.listRoots();
		List<MonitoramentoHd> listaDisco = new ArrayList<>();
		for (File disco : discos) {
			if (disco.getTotalSpace() != 0) {
			float SpaceUsed = (float) disco.getUsableSpace();
			float SpaceTotal = (float) disco.getTotalSpace();
			float percentualLivre = (SpaceUsed / SpaceTotal) * 100;
			DecimalFormat fmt = new DecimalFormat("0");
			String str = fmt.format(percentualLivre);
			System.out.println(str);
			listaDisco.add(new MonitoramentoHd(Float.parseFloat(str), disco.getAbsolutePath()));
			}
		}

		return listaDisco;
	}
}
