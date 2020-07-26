package ru.mina.test.rest.dto.camera;

import lombok.Getter;
import lombok.Setter;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:49
 */
@Getter
@Setter
public class TokenData {
  /**
   * Токен безопасности
   */
  private String value;
  /**
   * Время жизни токена
   */
  private int ttl;
}
