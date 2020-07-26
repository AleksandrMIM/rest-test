package ru.mina.test.rest.mapper.dto;

import org.jetbrains.annotations.NotNull;
import ru.mina.test.rest.dto.camera.CameraInfo;
import ru.mina.test.rest.dto.camera.SourceData;
import ru.mina.test.rest.dto.camera.TokenData;
import ru.mina.test.rest.model.CameraModel;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:45
 */
public interface CameraDtoMapper {

  @NotNull
  CameraModel map(@NotNull CameraInfo cameraInfo);

  @NotNull
  CameraModel map(@NotNull SourceData sourceData, @NotNull CameraModel cameraModel);

  @NotNull
  CameraModel map(@NotNull TokenData tokenData, @NotNull CameraModel cameraModel);
}
