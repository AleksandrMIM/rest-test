package ru.mina.test.rest.gateway;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.mina.test.rest.client.ReactiveRestClient;
import ru.mina.test.rest.dto.camera.CameraInfo;
import ru.mina.test.rest.dto.camera.SourceData;
import ru.mina.test.rest.dto.camera.TokenData;
import ru.mina.test.rest.mapper.dto.CameraDtoMapper;
import ru.mina.test.rest.model.CameraModel;
import ru.mina.test.rest.properties.RestApiProperties;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 3:01
 */
@Service
@EnableConfigurationProperties(RestApiProperties.class)
@RequiredArgsConstructor
public class CameraReactiveRestGateway implements CameraReactiveGateway {

  private final ReactiveRestClient reactiveRestClient;
  private final RestApiProperties restApiProperties;
  private final CameraDtoMapper cameraDtoMapper;

  @Override
  public Flux<CameraModel> createCameraInfo() {
    return reactiveRestClient.get(restApiProperties.getUrl(), CameraInfo.class, cameraDtoMapper::map);
  }

  @Override
  public Flux<CameraModel> updateCameraModelBySourceData(@NotNull CameraModel cameraModel) {
    return reactiveRestClient.get(cameraModel.getSourceDataUrl(), SourceData.class, sourceData -> cameraDtoMapper.map(sourceData, cameraModel));
  }

  @Override
  public Flux<CameraModel> updateCameraModelByTokenData(@NotNull CameraModel cameraModel) {
    return reactiveRestClient.get(cameraModel.getTokenDataUrl(), TokenData.class, tokenData -> cameraDtoMapper.map(tokenData, cameraModel));
  }
}
