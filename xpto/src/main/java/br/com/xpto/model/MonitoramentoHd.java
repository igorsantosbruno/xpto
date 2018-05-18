package br.com.xpto.model;


public class MonitoramentoHd{

    private float percentualUtilizado;

    private String caminhoAbsoluto; 
    
    public MonitoramentoHd() {
    	
    	this.percentualUtilizado = 0;
    	
    	this.caminhoAbsoluto = "";
    }
    
    public MonitoramentoHd(float percentualUtilizado,
                           String caminhoAbsoluto) {

        this.percentualUtilizado = percentualUtilizado;
        this.caminhoAbsoluto = caminhoAbsoluto;
    }

    public double getPercentualUtilizado() {
        return percentualUtilizado;
    }

    public void setPercentualUtilizado(float percentualUtilizado) {
        this.percentualUtilizado = percentualUtilizado;
    }

    public String getCaminhoAbsoluto() {
        return caminhoAbsoluto;
    }

    public void setCaminhoAbsoluto(String caminhoAbsoluto) {
        this.caminhoAbsoluto = caminhoAbsoluto;
    }
}