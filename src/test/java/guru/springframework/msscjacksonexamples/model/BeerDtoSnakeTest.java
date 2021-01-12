package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("snake")
@JsonTest
class BeerDtoSnakeTest extends BaseTest {

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
        var json = "{\"id\":\"14004ba6-64f2-4645-943d-ad8a241f5a30\",\"beer_name\":\"Beer1\",\"beer_style\":\"PALE_ALE\",\"upc\":123456789012,\"price\":\"12.99\",\"created_date\":\"2021-01-12T17:46:26+0100\",\"last_updated_date\":\"2021-01-12T17:46:26.126051+01:00\"}\n";

        var beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);
    }
}