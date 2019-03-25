package br.com.uol.platcorpv1.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.uol.platcorpv1.dto.IpVigilanteDTO;
import br.com.uol.platcorpv1.dto.MetaWeatherDTO;

@Service
public class ClienteEventosService {
	
	@Value("${ipvigilante.url}")
	private String latilong;

	@Value("${metaweather.url}")
	private String temperature;

	//validate ip public search
	public String validaSite() {
		String[] site = { "http://ifconfig.me/ip", "http://checkip.amazonaws.com/", "https://canihazip.com/s",
				"http://icanhazip.com/" };
		String siteValido = "";
		for (int i = 0; i < site.length; i++) {
			try {
				URL url = new URL(site[i]);
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
				int codigo = conexao.getResponseCode();
				if (codigo == 200) {
					siteValido = site[i];
				}
			} catch (Exception e) {
			}
		}
		return siteValido;
	}

	//public ip search
	public String ipMaquina() throws IOException {
		String ip = "";
		try {
			URL url2 = new URL(validaSite());
			BufferedReader in = new BufferedReader(new InputStreamReader(url2.openStream()));
			ip = in.readLine();
			in.close();
		} catch (IOException e) {
		}
		return ip;
	}

	//search georeferencing of public ip
	public IpVigilanteDTO buscaGeolocalizacao() throws IOException {
		IpVigilanteDTO ipVigilante = null;
		try {
			URL url3 = new URL(latilong.concat(ipMaquina()));
			BufferedReader in2 = new BufferedReader(new InputStreamReader(url3.openStream()));
			ipVigilante = new Gson().fromJson(in2, IpVigilanteDTO.class);
			in2.close();
		} catch (IOException e) {
		}
		return ipVigilante;
	}

	//local ip search
	public String IpInterno() throws UnknownHostException {
		String ipI = "";
		try {
			InetAddress[] addresses = InetAddress.getAllByName(InetAddress.getLocalHost().getHostAddress());
			for (InetAddress address : addresses) {
				ipI = address.getHostAddress();
			}
		} catch (IOException e) {
		}
		return ipI;
	}

	//temperature search
	@SuppressWarnings("unchecked")
	public List<MetaWeatherDTO> buscaClima(String search) throws IOException {
		List<MetaWeatherDTO> metaWeather = null;
		try {
			URL url4 = new URL(temperature.concat(search));
			BufferedReader in3 = new BufferedReader(new InputStreamReader(url4.openStream()));
			Type listType = new TypeToken<ArrayList<MetaWeatherDTO>>(){}.getType();
			metaWeather = (List<MetaWeatherDTO>) new Gson().fromJson(in3, listType);
			in3.close();
		} catch (IOException e) {
		}
		return metaWeather;
	}
}