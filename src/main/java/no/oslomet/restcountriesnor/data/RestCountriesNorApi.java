package no.oslomet.restcountriesnor.data;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RestCountriesNorApi {
    private HttpClient httpClient;
    private static final String REST_COUNTRIES_NOR_ENDPOINT = "https://restcountries.eu/rest/v2/name/norway?fullText=true";

    public JSONArray getNorData() throws IOException {
        HttpClient httpClient = getHttpClient();
        HttpGet getRequest = new HttpGet(REST_COUNTRIES_NOR_ENDPOINT);
        HttpResponse response = httpClient.execute(getRequest);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("Failed with HTTP error code : " + statusCode);
        }
        HttpEntity httpEntity = response.getEntity();
        JSONArray jsonArray = new JSONArray(EntityUtils.toString(httpEntity));
        return jsonArray;
    }

    private HttpClient getHttpClient(){
        if(httpClient == null){
            httpClient = HttpClientBuilder.create().build();
        }
        return httpClient;
    }
}
