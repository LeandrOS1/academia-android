package joeadyz.pe.academia.controller;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Celeritech Peru on 25/07/2015.
 */
public class WebClient {

    private String urlServidor;

    public WebClient(String urlServidor) {
        this.urlServidor = urlServidor;
    }


    public String post(String datosJSON) {
        try{
            URL url = new URL(urlServidor);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestMethod("POST");


            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStreamWriter printout = new OutputStreamWriter(conn.getOutputStream());
            printout.write(datosJSON);

            printout.flush();
            printout.close();

            // read the response
            System.out.println("Response Code: " + conn.getResponseCode());
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String respuestaEnJson = org.apache.commons.io.IOUtils.toString(in, "UTF-8");



            return respuestaEnJson;
        }catch(Exception ex){
           throw new RuntimeException(ex);
        }

    }
}
