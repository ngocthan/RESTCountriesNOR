package no.oslomet.restcountriesnor.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getNorData_returnsHttpStatus200Ok() throws Exception {
        mvc.perform(get("/api/getNorData"))
                .andExpect(status().isOk());
    }

    @Test
    public void getNorData_returnsExpectedContentType() throws Exception {
        mvc.perform(get("/api/getNorData"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void getNorData_returnsExpectedJsonModel() throws Exception {
        mvc.perform(get("/api/getNorData"))
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$[\"name\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"alpha2Code\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"alpha3Code\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"callingCodes\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"capital\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"altSpellings\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"region\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"subregion\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"population\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"latlng\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"demonym\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"area\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"gini\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"timezones\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"borders\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"nativeName\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"numericCode\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"currencies\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"languages\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"translations\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"flag\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"regionalBlocs\"]").isNotEmpty())
                .andExpect(jsonPath("$[\"cioc\"]").isNotEmpty());
    }
}
