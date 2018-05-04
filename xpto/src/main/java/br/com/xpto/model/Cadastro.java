package br.com.xpto.model;

import java.io.Serializable;

public class Cadastro implements Serializable{
	
	private static final long serialVersionUID = 1L;

    private String serial;
    private String hostname;
    private String dataFabricacao;
    private String descricaoFabricante;
    private String modeloFabricante;
    private String modeloEspecificoFabricante;
    private String codigoProcessador;
    private String descricaoProcessador;
    private String identificadorProcessador;
    private String quantidadeFisicaProcessador;
    private String quantidadeLogicaProcessador;
    private String espacoTotalRam;
    private String arquiteturaSistemaOperacional;
    private String descricaoSistemaOperacional;
    private String usuarioLogado;

    public Cadastro(){

    }

    public Cadastro(String serial,
                           String hostname,
                           String dataFabricacao,
                           String descricaoFabricante,
                           String modeloFabricante,
                           String modeloEspecificoFabricante,
                           String codigoProcessador,
                           String descricaoProcessador,
                           String identificadorProcessador,
                           String quantidadeFisicaProcessador,
                           String quantidadeLogicaProcessador,
                           String espacoTotalRam,
                           String arquiteturaSistemaOperacional,
                           String descricaoSistemaOperacional,
                           String usuarioLogado) {

        this.serial = serial;
        this.hostname = hostname;
        this.dataFabricacao = dataFabricacao;
        this.descricaoFabricante = descricaoFabricante;
        this.modeloFabricante = modeloFabricante;
        this.modeloEspecificoFabricante = modeloEspecificoFabricante;
        this.codigoProcessador = codigoProcessador;
        this.descricaoProcessador = descricaoProcessador;
        this.identificadorProcessador = identificadorProcessador;
        this.quantidadeFisicaProcessador = quantidadeFisicaProcessador;
        this.quantidadeLogicaProcessador = quantidadeLogicaProcessador;
        this.espacoTotalRam = espacoTotalRam;
        this.arquiteturaSistemaOperacional = arquiteturaSistemaOperacional;
        this.descricaoSistemaOperacional = descricaoSistemaOperacional;
        this.usuarioLogado = usuarioLogado;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(String dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getDescricaoFabricante() {
        return descricaoFabricante;
    }

    public void setDescricaoFabricante(String descricaoFabricante) {
        this.descricaoFabricante = descricaoFabricante;
    }

    public String getModeloFabricante() {
        return modeloFabricante;
    }

    public void setModeloFabricante(String modeloFabricante) {
        this.modeloFabricante = modeloFabricante;
    }

    public String getModeloEspecificoFabricante() {
        return modeloEspecificoFabricante;
    }

    public void setModeloEspecificoFabricante(String modeloEspecificoFabricante) {
        this.modeloEspecificoFabricante = modeloEspecificoFabricante;
    }

    public String getCodigoProcessador() {
        return codigoProcessador;
    }

    public void setCodigoProcessador(String codigoProcessador) {
        this.codigoProcessador = codigoProcessador;
    }

    public String getDescricaoProcessador() {
        return descricaoProcessador;
    }

    public void setDescricaoProcessador(String descricaoProcessador) {
        this.descricaoProcessador = descricaoProcessador;
    }

    public String getIdentificadorProcessador() {
        return identificadorProcessador;
    }

    public void setIdentificadorProcessador(String identificadorProcessador) {
        this.identificadorProcessador = identificadorProcessador;
    }

    public String getQuantidadeFisicaProcessador() {
        return quantidadeFisicaProcessador;
    }

    public void setQuantidadeFisicaProcessador(String quantidadeFisicaProcessador) {
        this.quantidadeFisicaProcessador = quantidadeFisicaProcessador;
    }

    public String getQuantidadeLogicaProcessador() {
        return quantidadeLogicaProcessador;
    }

    public void setQuantidadeLogicaProcessador(String quantidadeLogicaProcessador) {
        this.quantidadeLogicaProcessador = quantidadeLogicaProcessador;
    }

    public String getEspacoTotalRam() {
        return espacoTotalRam;
    }

    public void setEspacoTotalRam(String espacoTotalRam) {
        this.espacoTotalRam = espacoTotalRam;
    }

    public String getArquiteturaSistemaOperacional() {
        return arquiteturaSistemaOperacional;
    }

    public void setArquiteturaSistemaOperacional(String arquiteturaSistemaOperacional) {
        this.arquiteturaSistemaOperacional = arquiteturaSistemaOperacional;
    }

    public String getDescricaoSistemaOperacional() {
        return descricaoSistemaOperacional;
    }

    public void setDescricaoSistemaOperacional(String descricaoSistemaOperacional) {
        this.descricaoSistemaOperacional = descricaoSistemaOperacional;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    @Override
    public String toString() {
        return "RequestCadastro{" +
                "serial='" + serial + '\'' +
                ", hostname='" + hostname + '\'' +
                ", dataFabricacao='" + dataFabricacao + '\'' +
                ", descricaoFabricante='" + descricaoFabricante + '\'' +
                ", modeloFabricante='" + modeloFabricante + '\'' +
                ", modeloEspecificoFabricante='" + modeloEspecificoFabricante + '\'' +
                ", codigoProcessador='" + codigoProcessador + '\'' +
                ", descricaoProcessador='" + descricaoProcessador + '\'' +
                ", identificadorProcessador='" + identificadorProcessador + '\'' +
                ", quantidadeFisicaProcessador='" + quantidadeFisicaProcessador + '\'' +
                ", quantidadeLogicaProcessador='" + quantidadeLogicaProcessador + '\'' +
                ", espacoTotalRam='" + espacoTotalRam + '\'' +
                ", arquiteturaSistemaOperacional='" + arquiteturaSistemaOperacional + '\'' +
                ", descricaoSistemaOperacional='" + descricaoSistemaOperacional + '\'' +
                ", usuarioLogado='" + usuarioLogado + '\'' +
                '}';
    }
}
