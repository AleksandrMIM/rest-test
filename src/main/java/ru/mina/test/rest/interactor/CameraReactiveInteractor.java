package ru.mina.test.rest.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mina.test.rest.gateway.CameraReactiveGateway;
import ru.mina.test.rest.model.CameraModel;

import java.util.ArrayList;
import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:21
 */
@Service
@RequiredArgsConstructor
public class CameraReactiveInteractor implements CameraInteractor {

  private final CameraReactiveGateway cameraReactiveGateway;

  @Override
  public List<CameraModel> getCameras() {
    List<CameraModel> cameraList = new ArrayList<>();

    cameraReactiveGateway.createCameraInfo()
        .parallel()
        .flatMap(cameraReactiveGateway::updateCameraModelBySourceData)
        .flatMap(cameraReactiveGateway::updateCameraModelByTokenData)
        .sequential()
        .map(cameraList::add)
        .blockLast();

    return cameraList;
  }
}
