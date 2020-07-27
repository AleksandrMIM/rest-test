package ru.mina.test.rest.interactor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import ru.mina.test.rest.AbstractTest;
import ru.mina.test.rest.annotation.ModelTest;
import ru.mina.test.rest.gateway.CameraReactiveGateway;
import ru.mina.test.rest.model.CameraModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 3:17
 */
@ModelTest
class CameraInteractorTest extends AbstractTest {

  @MockBean
  private CameraReactiveGateway cameraReactiveGateway;
  @Autowired
  private CameraReactiveInteractor cameraReactiveInteractor;

  @Test
  void getCameras_returnCorrectAnswer_getCorrect() {
    CameraModel cameraModelOne = new CameraModel(42, "341243321", "431241234");
    when(cameraReactiveGateway.createCameraInfo())
        .thenReturn(Flux.just(cameraModelOne));

    CameraModel cameraModelTwo = new CameraModel(cameraModelOne.getId(), cameraModelOne.getSourceDataUrl(), cameraModelOne.getTokenDataUrl());
    cameraModelTwo.setVideoUrl("491294");
    cameraModelTwo.setUrlType("482148132");
    when(cameraReactiveGateway.updateCameraModelBySourceData(cameraModelOne))
        .thenReturn(Flux.just(cameraModelTwo));

    CameraModel cameraModelThree = new CameraModel(cameraModelOne.getId(), cameraModelOne.getSourceDataUrl(), cameraModelOne.getTokenDataUrl());
    cameraModelThree.setVideoUrl(cameraModelTwo.getVideoUrl());
    cameraModelThree.setUrlType(cameraModelTwo.getUrlType());
    cameraModelThree.setToken("41235123");
    cameraModelThree.setTtl(43);
    when(cameraReactiveGateway.updateCameraModelByTokenData(cameraModelTwo))
        .thenReturn(Flux.just(cameraModelThree));

    List<CameraModel> cameraModelList = cameraReactiveInteractor.getCameras();
    assertEquals(1, cameraModelList.size());
    assertEquals(cameraModelThree, cameraModelList.get(0));
  }
}