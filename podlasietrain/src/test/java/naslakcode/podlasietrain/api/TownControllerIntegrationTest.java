package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.services.TownService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TownController.class)
@ExtendWith(SpringExtension.class)
public class TownControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TownController townController;

    @MockBean
    private  TownService townService;



    @Test
    public void getTownByNameTest() throws Exception {
        Town town = new Town();
        town.setId("LOD");
        town.setName("Lodz");

        when(townService.findById(anyString())).thenReturn(town);

        mockMvc.perform(get("/towns/Lodz"))
                .andDo(print())
                .andExpect(jsonPath("$.id").value("LOD"))
                .andExpect(jsonPath("$.name").value("Lodz"))
                .andExpect(status().isOk());
    }

}
