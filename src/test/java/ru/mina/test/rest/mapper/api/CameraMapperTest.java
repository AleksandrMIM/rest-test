package ru.mina.test.rest.mapper.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mina.test.rest.AbstractTest;
import ru.mina.test.rest.annotation.ModelTest;
import ru.mina.test.rest.api.camera.Camera;
import ru.mina.test.rest.model.CameraModel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 3:17
 */
@ModelTest
class CameraMapperTest extends AbstractTest {

  @Autowired
  private CameraMapper cameraMapper;

  @Test
  void map_nullValue_nullResult() {
    assertNull(cameraMapper.map(null));
  }

  @Test
  void map_correctValue_correctResult() {
    CameraModel cameraModel = new CameraModel(42, "432912030120512", "512491294912");
    cameraModel.setTtl(320);
    cameraModel.setToken("token");
    cameraModel.setVideoUrl("reirie");
    cameraModel.setUrlType("rueuiuwrw");

    Camera camera = cameraMapper.map(cameraModel);

    assertNotNull(camera);
    assertEquals(camera.getId(), cameraModel.getId());
    assertEquals(camera.getToken(), cameraModel.getToken());
    assertEquals(camera.getTtl(), cameraModel.getTtl());
    assertEquals(camera.getUrlType(), cameraModel.getUrlType());
    assertEquals(camera.getVideoUrl(), cameraModel.getVideoUrl());
  }
}