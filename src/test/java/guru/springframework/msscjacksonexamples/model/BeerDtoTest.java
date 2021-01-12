package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws Exception {
        var dto = getDto();

        var jsonString = objectMapper.writeValueAsString(dto);

        System.out.println(jsonString);
    }

    @Test
    void deserialize() throws Exception {
        var json = "{\"id\":\"5edc332c-e905-4542-8367-592f05aa479f\",\"beerName\":\"Beer1\",\"beerStyle\":\"PALE_ALE\",\"upc\":123456789012,\"price\":12.99,\"createdDate\":\"2021-01-12T17:27:22.599419+01:00\",\"lastUpdatedDate\":\"2021-01-12T17:27:22.599968+01:00\"}\n";

        var beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}