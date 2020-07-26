package ru.mina.test.rest.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:46
 */
@Getter
@Setter
@ConfigurationProperties("rest.api")
public class RestApiProperties {
  /**
   * URL до API с камерами
   */
  private String url;
}
