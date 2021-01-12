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
        var json = "{\"id\":\"98986fe5-f90d-415c-ae69-a59b9d88f8a2\",\"beerName\":\"Beer1\",\"beerStyle\":\"PALE_ALE\",\"upc\":123456789012,\"price\":\"12.99\",\"createdDate\":\"2021-01-12T17:52:37+0100\",\"lastUpdatedDate\":\"2021-01-12T17:52:37.173943+01:00\",\"myLocalDate\":\"20210112\"}";

        var beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}