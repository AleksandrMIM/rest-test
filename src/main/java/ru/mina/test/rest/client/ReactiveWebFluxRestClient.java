package ru.mina.test.rest.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.mina.test.rest.model.CameraModel;

import java.util.function.Function;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:36
 */
@Service
@RequiredArgsConstructor
public class ReactiveWebFluxRestClient implements ReactiveRestClient {

  private final WebClient webClient;

  @Override
  public <T> Flux<CameraModel> get(String url, Class<T> tClass, Function<? super T, CameraModel> mapper) {
    return webClient
        .get()
        .uri(url)
        .retrieve()
        .bodyToFlux(tClass)
        .map(mapper);
  }
}
