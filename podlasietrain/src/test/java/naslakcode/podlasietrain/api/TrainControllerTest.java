package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class TrainControllerTest {

    @Test
    void shouldAddNewTrain() {
        //given
        TrainController trainController = mock(TrainController.class);
        given(trainController
            .addTrain(Mockito.any(Train.class)))
                .willReturn(preparedTrainMock());
        //when
        Train train = trainController.addTrain(preparedTrainMock());
        //then
        ??
    }

    public void exampleTrain

    @Test
    Train preparedTrainMock(){
        Town zakopane = new Town("ZAK", "Zakopane");
        Town wroclaw = new Town("WRO", "Wrocław");
        Train mockTrain = new Train("zakwro", zakopane, wroclaw, 8);
    }

}