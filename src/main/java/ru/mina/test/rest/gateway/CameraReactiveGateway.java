package ru.mina.test.rest.gateway;

import org.jetbrains.annotations.NotNull;
import reactor.core.publisher.Flux;
import ru.mina.test.rest.model.CameraModel;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:54
 */
public interface CameraReactiveGateway {

  /**
   * Создание информации по камерам
   *
   * @return Flux
   */
  Flux<CameraModel> createCameraInfo();

  /**
   * Обновление информации по камерам информацией о источнике данных
   *
   * @param cameraModel информация по камерам
   * @return Flux
   */
  Flux<CameraModel> updateCameraModelBySourceData(@NotNull CameraModel cameraModel);

  /**
   * Обновление информации по камерам информацией о токенах
   *
   * @param cameraModel информация по камерам
   * @return Flux
   */
  Flux<CameraModel> updateCameraModelByTokenData(@NotNull CameraModel cameraModel);
}
