package naslakcode.podlasietrain.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import naslakcode.podlasietrain.entities.DijkstraAlgorithm;
import naslakcode.podlasietrain.entities.Graph;
import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import naslakcode.podlasietrain.repositories.TownRepository;
import naslakcode.podlasietrain.services.TownService;
import naslakcode.podlasietrain.services.TrainService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrainController.class)
@ExtendWith(SpringExtension.class)
public class TrainControllerIntegrationTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TrainController trainController;
    @Mock
    private TownController townController;

    @MockBean
    private TrainService trainService;
    @MockBean
    private TownRepository townRepository;
    @MockBean
    private TownService townService;

    @Test
    public void shouldFindTrainById() throws Exception {
        Town zakopane = new Town("ZAK", "Zakopane");
        Town gdansk = new Town("GDA", "Gdansk");
        Train train = new Train("zakgda", zakopane, gdansk, 10);

        when(trainService.findById(anyString())).thenReturn(train);

        mockMvc.perform(MockMvcRequestBuilders.get("/trains/gordol"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.source.name").value("Zakopane"))
                .andExpect(jsonPath("$.destination.name").value("Gdansk"))
                .andExpect(jsonPath("$.id").value("zakgda"))
                .andExpect(jsonPath("$.weight").value(10))
                .andExpect(status().isOk());

    }

    @Test
    public void shouldFindAllTrainsById() throws Exception {
        Town zakopane = new Town("ZAK", "Zakopane");
        Town gdansk = new Town("GDA", "Gdansk");
        Town katowice = new Town("KAT", "Katowice");
        Train train = new Train("zakgda", zakopane, gdansk, 10);
        Train train2 = new Train("zakkat", zakopane, katowice, 5);
        List<Train> trainsList = Arrays.asList(train, train2);

        when(trainService.findALl()).thenReturn(trainsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/trains"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].id").value("zakgda"))
                .andExpect(jsonPath("$[1].id").value("zakkat"))
                .andExpect(jsonPath("$[0].source.name").value("Zakopane"))
                .andExpect(jsonPath("$[1].destination.name").value("Katowice"))
                .andExpect(jsonPath("$[0].weight").value(10))
                .andExpect(status().isOk());

    }
    @Test
    public void shouldAddNewTrain() throws Exception {
        Town zakopane = new Town("ZAK", "Zakopane");
        Town gdansk = new Town("GDA", "Gdansk");
        Train train = new Train("zakgda", zakopane, gdansk, 10);


        when(trainService.save(any(Train.class))).thenReturn(train);

        mockMvc.perform(MockMvcRequestBuilders.post("/trains/add")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(train)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id", is("zakgda")))
                .andExpect(jsonPath("$.source.name").value("Zakopane"))
                .andExpect(jsonPath("$.destination.name").exists());
    }

    @Test
    public void shouldUploadDestinationTrain() throws Exception {
        Town zakopane = new Town("ZAK", "Zakopane");
        Town gdansk = new Town("GDA", "Gdansk");
        Town kolobrzeg = new Town("KOL", "Kolobrzeg");
        Train train = new Train("zakgda", zakopane, gdansk, 10);
        Train newTrain = new Train("zakkol", zakopane, kolobrzeg, 11);
        when(trainService.uploadById(train.getId(),newTrain)).thenReturn(newTrain);

        mockMvc.perform(MockMvcRequestBuilders.post("/trains/patch/zakgda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newTrain)))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.id").value("zakkol"))
            .andExpect(jsonPath("$.destination.name").value("Kolobrzeg"));

    }

    @Test
    public void shouldDeleteTrainByGivenId() throws Exception {
        Town zakopane = new Town("ZAK", "Zakopane");
        Town gdansk = new Town("GDA", "Gdansk");
        Train train = new Train("zakgda", zakopane, gdansk, 10);
        Train train2 = new Train("gdazak", gdansk, zakopane, 10);
        trainService.save(train);
        trainService.save(train2);

        doNothing().when(trainService).deleteById(anyString());

        mockMvc.perform(MockMvcRequestBuilders.delete("/trains/delete/zakgda"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("zakgda").doesNotExist());


    }
}
