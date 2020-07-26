package ru.mina.test.rest.api.camera;

import lombok.Getter;
import lombok.Setter;

/**
 * Информация о камерах
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:41
 */
@Getter
@Setter
public class Camera {
  /**
   * Идентификатор камеры
   */
  private long id;
  /**
   * Тип ссылки на видеопоток
   */
  private String urlType;
  /**
   * Ссылка на видеопоток
   */
  private String videoUrl;
  /**
   * Токен безопасности
   */
  private String token;
  /**
   * Время жизни токена
   */
  private Integer ttl;
}
