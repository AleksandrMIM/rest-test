package ru.mina.test.rest.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Информация о камерах
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:41
 */
@Getter
@Setter
@RequiredArgsConstructor
public class CameraModel {
  /**
   * Идентификатор камеры
   */
  private final long id;
  /**
   * Ссылка для получения данных источника
   */
  private final String sourceDataUrl;
  /**
   * Ссылка для получения токенов безопасности по камере
   */
  private final String tokenDataUrl;
  /**
   * Тип ссылки на видеопоток
   */
  private volatile String urlType;
  /**
   * Ссылка на видеопоток
   */
  private volatile String videoUrl;
  /**
   * Токен безопасности
   */
  private volatile String token;
  /**
   * Время жизни токена
   */
  private volatile Integer ttl;
}
