package ru.mina.test.rest.mapper.dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mina.test.rest.AbstractTest;
import ru.mina.test.rest.annotation.ModelTest;
import ru.mina.test.rest.dto.camera.CameraInfo;
import ru.mina.test.rest.dto.camera.SourceData;
import ru.mina.test.rest.dto.camera.TokenData;
import ru.mina.test.rest.model.CameraModel;

import static org.junit.jupiter.api.Assertions.*;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 3:16
 */
@ModelTest
class CameraDtoMapperTest extends AbstractTest {

  @Autowired
  private CameraDtoMapper cameraDtoMapper;

  @Test
  void map_correctValue_correctResult() {
    CameraInfo cameraInfo = new CameraInfo();
    cameraInfo.setId(42);
    cameraInfo.setSourceDataUrl("412412");
    cameraInfo.setTokenDataUrl("31245124");

    CameraModel cameraModel = cameraDtoMapper.map(cameraInfo);
    assertNotNull(cameraModel);
    assertEquals(cameraInfo.getId(), cameraModel.getId());
    assertEquals(cameraInfo.getSourceDataUrl(), cameraModel.getSourceDataUrl());
    assertEquals(cameraInfo.getTokenDataUrl(), cameraModel.getTokenDataUrl());
  }

  @Test
  void map_correctSourceData_correctResult() {
    SourceData sourceData = new SourceData();
    sourceData.setUrlType("034210412");
    sourceData.setVideoUrl("49129341");

    CameraModel cameraModel = new CameraModel(42, "4324234", "4325234");
    CameraModel newCameraModel = cameraDtoMapper.map(sourceData, cameraModel);
    assertEquals(newCameraModel.getId(), cameraModel.getId());
    assertEquals(newCameraModel.getSourceDataUrl(), cameraModel.getSourceDataUrl());
    assertEquals(newCameraModel.getTokenDataUrl(), cameraModel.getTokenDataUrl());
    assertEquals(sourceData.getUrlType(), cameraModel.getUrlType());
    assertEquals(sourceData.getVideoUrl(), cameraModel.getVideoUrl());
    assertNull(newCameraModel.getTtl());
    assertNull(newCameraModel.getToken());
  }

  @Test
  void map_correctTokenData_correctResult() {
    TokenData tokenData = new TokenData();
    tokenData.setValue("034210412");
    tokenData.setTtl(30);

    CameraModel cameraModel = new CameraModel(42, "4324234", "4325234");
    CameraModel newCameraModel = cameraDtoMapper.map(tokenData, cameraModel);
    assertEquals(newCameraModel.getId(), cameraModel.getId());
    assertEquals(newCameraModel.getSourceDataUrl(), cameraModel.getSourceDataUrl());
    assertEquals(newCameraModel.getTokenDataUrl(), cameraModel.getTokenDataUrl());
    assertEquals(tokenData.getValue(), cameraModel.getToken());
    assertEquals(tokenData.getTtl(), cameraModel.getTtl());
    assertNull(newCameraModel.getUrlType());
    assertNull(newCameraModel.getVideoUrl());
  }
}