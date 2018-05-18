package br.com.xpto.rest;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.xpto.model.Cadastro;
import br.com.xpto.model.GravarMonitoramento;

public class RequestCliente {

	private final String hostWebService = "http://10.0.1.212:8080/xptoservice";
	private final String requestRetornaExistenciaMaquina = "/maquina/retornaExistenciaMaquina?serial=";
	private final String requestCadastro = "/maquina/cadastro";
	private final String requestGravarMonitoramento = "/maquina/gravarMonitoramento";

	public String retornaExistenciaMaquina(String serial) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(this.hostWebService + this.requestRetornaExistenciaMaquina + serial);
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		HttpResponse response = null;
		try {
			response = httpClient.execute(request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resposta = "";
		try {
			resposta = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposta;
	}
	
	public boolean cadastro(Cadastro cadastro) {
		
		HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        HttpPost request = new HttpPost(this.hostWebService + this.requestCadastro);
        StringEntity params = null;
		params = new StringEntity(gson.toJson(cadastro),"UTF-8");
        request.addHeader("content-type","application/json");
        request.addHeader("Accept","application/json");
        request.setHeader("Content-Type", "application/json;charset=UTF-8");
        request.setEntity(params);
        try {
        	//void
			httpClient.execute(request);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			httpClient.getConnectionManager().shutdown();
		}
        return false;
	}
	
	public boolean gravarMonitoramento(GravarMonitoramento monitoramento) {
		
		HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        HttpPost request = new HttpPost(this.hostWebService + this.requestGravarMonitoramento);
        StringEntity params = null;
		params = new StringEntity(gson.toJson(monitoramento),"UTF-8");
        request.addHeader("content-type","application/json");
        request.addHeader("Accept","application/json");
        request.setHeader("Content-Type", "application/json;charset=UTF-8");
        request.setEntity(params);
        try {
        	//void
			httpClient.execute(request);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			httpClient.getConnectionManager().shutdown();
		}
        return false;
	}
}








