package ru.mina.test.rest.mapper.api;

import org.mapstruct.Mapper;
import ru.mina.test.rest.api.camera.Camera;
import ru.mina.test.rest.model.CameraModel;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:16
 */
@Mapper(componentModel = "spring")
public interface CameraMapper {

  Camera map(CameraModel cameraModel);
}
