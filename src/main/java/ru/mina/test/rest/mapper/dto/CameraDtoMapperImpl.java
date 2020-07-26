package ru.mina.test.rest.mapper.dto;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import ru.mina.test.rest.dto.camera.CameraInfo;
import ru.mina.test.rest.dto.camera.SourceData;
import ru.mina.test.rest.dto.camera.TokenData;
import ru.mina.test.rest.model.CameraModel;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:47
 */
@Component
public class CameraDtoMapperImpl implements CameraDtoMapper {

  @Override
  public @NotNull CameraModel map(@NotNull CameraInfo cameraInfo) {
    return new CameraModel(cameraInfo.getId(), cameraInfo.getSourceDataUrl(), cameraInfo.getTokenDataUrl());
  }

  @Override
  public @NotNull CameraModel map(@NotNull SourceData sourceData, @NotNull CameraModel cameraModel) {
    cameraModel.setUrlType(sourceData.getUrlType());
    cameraModel.setVideoUrl(sourceData.getVideoUrl());
    return cameraModel;
  }

  @Override
  public @NotNull CameraModel map(@NotNull TokenData tokenData, @NotNull CameraModel cameraModel) {
    cameraModel.setToken(tokenData.getValue());
    cameraModel.setTtl(tokenData.getTtl());
    return cameraModel;
  }
}
