package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
class BeerDtoKebabTest extends BaseTest {

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
        var json = "{\"id\":\"f1813195-f100-495e-820a-8b7d3985d028\",\"beer-name\":\"Beer1\",\"beer-style\":\"PALE_ALE\",\"upc\":123456789012,\"price\":\"12.99\",\"created-date\":\"2021-01-12T17:53:09+0100\",\"last-updated-date\":\"2021-01-12T17:53:09.831696+01:00\",\"my-local-date\":\"20210112\"}";

        var beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}