package ru.mina.test.rest.dto.camera;

import lombok.Getter;
import lombok.Setter;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:48
 */
@Getter
@Setter
public class SourceData {
  /**
   * Тип ссылки на видеопоток
   */
  private String urlType;
  /**
   * Ссылка на видеопоток
   */
  private String videoUrl;
}
