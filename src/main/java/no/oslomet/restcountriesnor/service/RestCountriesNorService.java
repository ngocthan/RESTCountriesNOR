package no.oslomet.restcountriesnor.service;

import no.oslomet.restcountriesnor.data.RestCountriesNorApi;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RestCountriesNorService {
    @Autowired
    private RestCountriesNorApi restCountriesNorApi;

    public String getNorData() throws IOException {
        JSONArray norDataArray = restCountriesNorApi.getNorData();
        if(norDataArray.length() > 0){
            JSONObject norData = norDataArray.getJSONObject(0);
            return norData.toString();
        }
        return null;
    }

}
