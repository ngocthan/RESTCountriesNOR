package no.oslomet.restcountriesnor.service;

import no.oslomet.restcountriesnor.data.RestCountriesNorApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestCountriesNorServiceTest {
    @InjectMocks
    private RestCountriesNorService restCountriesNorService;

    @Mock
    private RestCountriesNorApi restCountriesNorApi;

    @Test
    public void getNorData_returnsJsonObject() throws Exception {
        JSONArray norDataArray = createNorDataArrayTestData();
        when(restCountriesNorApi.getNorData()).thenReturn(norDataArray);

        String norData = restCountriesNorService.getNorData();
        JSONObject json = new JSONObject(norData);

        assertTrue(json.get("name").equals("Norway"));
        assertTrue(json.get("topLevelDomain").equals(".no"));
        assertTrue(json.get("capital").equals("Oslo"));
    }

    private JSONArray createNorDataArrayTestData() throws JSONException {
        JSONArray norDataArray = new JSONArray();
        JSONObject norData = new JSONObject();
        norData.put("name", "Norway");
        norData.put("topLevelDomain", ".no");
        norData.put("alpha2Code", "NO");
        norData.put("alpha3Code", "NOR");
        norData.put("capital", "Oslo");
        norData.put("region", "Europe");
        norData.put("subregion", "Northern Europe");
        norData.put("population", 5223256);
        norData.put("area", "323802");
        norData.put("nativeName", "Norge");
        norData.put("flag", "https://restcountries.eu/data/nor.svg");
        norDataArray.put(norData);
        return norDataArray;
    }
}
