package naslakcode.podlasietrain.api;

import naslakcode.podlasietrain.entities.Town;
import naslakcode.podlasietrain.entities.Train;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class TrainControllerTest {

    @Test
    public Train preparedTrainMock(){
        Town zakopane = new Town("ZAK", "Zakopane");
        Town wroclaw = new Town("WRO", "Wrocław");
        Train mockTrain = new Train("zakwro", zakopane, wroclaw, 8);
        return mockTrain;
    }


    @Test
    void shouldAddNewTrain() {
        //given
        TrainController trainController = mock(TrainController.class);
        given(trainController
            .addTrain(Mockito.any(Train.class)))
                .willReturn(preparedTrainMock());
        //when
        Train train = trainController.addTrain(new Train());
        //then

    }



}