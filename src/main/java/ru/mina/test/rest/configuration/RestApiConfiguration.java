package ru.mina.test.rest.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.util.concurrent.TimeUnit;

/**
 * User: @AleksandrMIM
 * Date: 26.07.2020
 * Time: 23:59
 */
@Configuration
public class RestApiConfiguration {

  @Value("${rest.api.connect-timeout}")
  private int connectTimeout;
  @Value("${rest.api.read-timeout}")
  private int readTimeout;
  @Value("${rest.api.write-timeout}")
  private int writeTimeout;

  @Bean("restApiWebClient")
  public WebClient webClient() {
    TcpClient tcpClient = TcpClient
        .create()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout)
        .doOnConnected(connection -> {
          connection.addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS));
          connection.addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS));
        });

    return WebClient
        .builder()
        .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }
}
