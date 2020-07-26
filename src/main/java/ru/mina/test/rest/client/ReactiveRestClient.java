package ru.mina.test.rest.client;

import reactor.core.publisher.Flux;
import ru.mina.test.rest.model.CameraModel;

import java.util.function.Function;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:33
 */
public interface ReactiveRestClient {

  /**
   * Отправка информации по сети
   *
   * @param tClass класс ответа
   * @param mapper маппинг ответа в модель
   * @param <T>    тип класса ответа
   * @return Flux
   */
  <T> Flux<CameraModel> get(String url, Class<T> tClass, Function<? super T, CameraModel> mapper);
}
