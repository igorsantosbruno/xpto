package br.com.xpto.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

import br.com.xpto.model.CadastroComponente;
import br.com.xpto.model.Maquina;

public class RequestCliente {

	private final String hostWebService = "http://localhost:8080/xptoservice";
	private final String requestObterIdEmpresa = "/maquina/verficarExistenciaMaquina?serial=";
	private final String requestInsereMaquina = "/maquina/cadastrarMaquina";
	private final String requestCadastroInicial = "/maquina/cadastroInicial";

	public boolean verificaExistenciaMaquina(String serial) {

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(this.hostWebService + this.requestObterIdEmpresa + serial);
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
		String json = "";
		try {
			json = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.equals("true");
	}
	
	public boolean insereMaquina(Maquina maquina) {
		
		HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        HttpPost request = new HttpPost(this.hostWebService + this.requestInsereMaquina);
        StringEntity params = null;
		try {
			params = new StringEntity(gson.toJson(maquina));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.addHeader("content-type","application/json");
        request.addHeader("Accept","application/json");
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
	
	public boolean cadastroInicial(CadastroComponente cadastroComponente) {
		
		HttpClient httpClient = new DefaultHttpClient();
        Gson gson = new Gson();
        HttpPost request = new HttpPost(this.hostWebService + this.requestCadastroInicial);
        StringEntity params = null;
		params = new StringEntity(gson.toJson(cadastroComponente),"UTF-8");
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








