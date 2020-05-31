package com.fravega.ejercicio;

import java.io.IOException;
import static org.junit.Assert.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class BackendTest {

	@Test
	public void test() throws Exception {
		// obtener listado de cerveceria lagunitas
		String response = getURL("https://api.openbrewerydb.org/breweries/autocomplete?query=lagunitas");
		JSONArray listaCerveceriaLagunita = new JSONArray(response);
		
		// filtrar por el name =Lagunitas Brewing Co
		List<JSONObject> listaCerveceriaLagunitaFiltrada = new ArrayList<JSONObject>();
		for(int i=0; i < listaCerveceriaLagunita.length(); ++i) {
			JSONObject jo = listaCerveceriaLagunita.getJSONObject(i);
			
			if(jo.getString("name").equals("Lagunitas Brewing Co")) {
				listaCerveceriaLagunitaFiltrada.add(jo);
			}
		}
		
		// de la lista de Lagunitas Brewings C filtrar las que tiene state=california
		List<JSONObject> listaCerveceriaLagunitaFiltradaCalifornia = new ArrayList<JSONObject>();
		for (JSONObject jsonObject : listaCerveceriaLagunitaFiltrada) {
			response = getURL("https://api.openbrewerydb.org/breweries/" + jsonObject.getInt("id"));
			JSONObject jo = new JSONObject(response);
			
			if(jo.getString("state").equals("California")) {
				listaCerveceriaLagunitaFiltradaCalifornia.add(jo);
			}
		}
		
		// sobre el ultimo resultado hacer un assertar los siguientes datos: id=761
		for (JSONObject jsonObject : listaCerveceriaLagunitaFiltradaCalifornia) {
			assertEquals(jsonObject.getInt("id"), 761);
			assertEquals(jsonObject.getString("name"), "Lagunitas Brewing Co");
			assertEquals(jsonObject.getString("street"),"1280 N McDowell Blvd");
			assertEquals(jsonObject.getString("phone"), "7077694495");
		}
	}

	

	private String getURL(String url) throws Exception {
		String responseBody = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			HttpGet httpget = new HttpGet(url);

			System.out.println("Executing request " + httpget.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				@Override
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};

			responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			httpclient.close();
		}

		return responseBody;
	}
}
