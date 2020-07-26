package ru.mina.test.rest.dto.camera;

import lombok.Getter;
import lombok.Setter;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:47
 */
@Getter
@Setter
public class CameraInfo {
  /**
   * Идентификатор камеры
   */
  private long id;
  /**
   * Ссылка для получения данных источника
   */
  private String sourceDataUrl;
  /**
   * Ссылка для получения токенов безопасности по камере
   */
  private String tokenDataUrl;
}
