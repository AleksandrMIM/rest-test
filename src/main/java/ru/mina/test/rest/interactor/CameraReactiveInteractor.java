package ru.mina.test.rest.interactor;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.mina.test.rest.client.ReactiveRestClient;
import ru.mina.test.rest.dto.camera.CameraInfo;
import ru.mina.test.rest.dto.camera.SourceData;
import ru.mina.test.rest.dto.camera.TokenData;
import ru.mina.test.rest.mapper.dto.CameraDtoMapper;
import ru.mina.test.rest.model.CameraModel;
import ru.mina.test.rest.properties.RestApiProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:21
 */
@Service
@EnableConfigurationProperties(RestApiProperties.class)
@RequiredArgsConstructor
public class CameraReactiveInteractor implements CameraInteractor {

  private final ReactiveRestClient reactiveRestClient;
  private final RestApiProperties restApiProperties;
  private final CameraDtoMapper cameraDtoMapper;

  @Override
  public List<CameraModel> getCameras() {
    List<CameraModel> cameraList = new ArrayList<>();

    reactiveRestClient
        .get(restApiProperties.getUrl(), CameraInfo.class, cameraDtoMapper::map)
        .parallel()
        .flatMap(cameraModel -> reactiveRestClient.get(cameraModel.getSourceDataUrl(), SourceData.class, sourceData -> cameraDtoMapper.map(sourceData, cameraModel)))
        .flatMap(cameraModel -> reactiveRestClient.get(cameraModel.getTokenDataUrl(), TokenData.class, tokenData -> cameraDtoMapper.map(tokenData, cameraModel)))
        .sequential()
        .map(cameraList::add)
        .blockLast();

    return cameraList;
  }
}
