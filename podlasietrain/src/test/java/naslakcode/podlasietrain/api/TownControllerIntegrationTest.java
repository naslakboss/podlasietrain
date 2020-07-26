package naslakcode.podlasietrain.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.services.TownService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TownController.class)
@ExtendWith(SpringExtension.class)
public class TownControllerIntegrationTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TownController townController;

    @MockBean
    private  TownService townService;



    @Test
    public void shouldGetTownByName() throws Exception {
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

    @Test
    public void shouldGetAllTowns() throws Exception {
        Town town1 = new Town("CHI", "Chicago");
        Town town2 = new Town("HOU", "Houston");
        List townsList = Arrays.asList(town1, town2);

        when(townService.findAll()).thenReturn(townsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/towns")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(townsList)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value("CHI"))
                .andExpect(jsonPath("$[1].name").value("Houston"));
    }

    @Test
    public void shouldAddNewTown() throws Exception {
        Town town = new Town("ZAM", "Zamosc");
        when(townService.save(any(Town.class))).thenReturn(town);

        mockMvc.perform(MockMvcRequestBuilders.post("/towns/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(town)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value("ZAM"))
                .andExpect(jsonPath(("$.name")).value("Zamosc"));
    }

    @Test
    public void shouldPatchTownById() throws Exception {

        Town town = new Town("KON", "Konstantynopol");
        Town newTown = new Town("STA", "Stambul");
        when(townService.uploadTown(any(Town.class), anyString())).thenReturn(newTown);

        mockMvc.perform(MockMvcRequestBuilders.post("/towns/patch/Konstantynopol")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(newTown)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("STA"))
                .andExpect(jsonPath("$.name").value("Stambul"))
                .andExpect(jsonPath("KON").doesNotExist());
    }

    @Test
    public void shouldDeleteTownById() throws Exception {
        Town townToDelete = new Town("RAD", "Radom");
        townService.save(townToDelete);

        doNothing().when(townService).deleteById(anyString());

        mockMvc.perform(MockMvcRequestBuilders.delete("/towns/delete/Radom")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(townToDelete)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.name", "Radom").doesNotExist())
                .andExpect(jsonPath("$.id", "RAD").doesNotExist());

    }

}
