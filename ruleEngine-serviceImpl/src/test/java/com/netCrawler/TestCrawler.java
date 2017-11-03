package com.netCrawler;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.*;
import java.net.URL;

public class TestCrawler {

    @Test
    public void worn() throws IOException {

        URL url = new URL("http://www.iqiyi.com");
        InputStream inputStream = url.openStream();
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        while((line = bufferedReader.readLine()) != null ){
            System.out.println(line);
        }

    }

    @Test
    public void testHttpClient() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        httpGet.releaseConnection();
    }
}