package ru.mina.test.rest.controller.camera;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mina.test.rest.api.camera.Camera;
import ru.mina.test.rest.interactor.CameraInteractor;
import ru.mina.test.rest.mapper.api.CameraMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:44
 */
@Slf4j
@RestController
@RequestMapping("/v1/camera")
@RequiredArgsConstructor
public class CameraController {

  private final CameraInteractor cameraInteractor;
  private final CameraMapper cameraMapper;

  @GetMapping("/all")
  public List<Camera> getCameras() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    List<Camera> cameraList = cameraInteractor.getCameras()
        .stream()
        .map(cameraMapper::map)
        .collect(Collectors.toList());

    stopWatch.stop();
    logger.info("Запрос был выполнен за {} мс", stopWatch.getTotalTimeMillis());

    return cameraList;
  }
}
