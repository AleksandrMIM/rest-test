package ru.mina.test.rest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 3:17
 */
@Component
@Aspect
@Slf4j
public class WatchAspect {


  @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
  public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    StopWatch stopWatch = new StopWatch(joinPoint.getSignature().getDeclaringTypeName());
    stopWatch.start(joinPoint.getSignature().getName());

    try {
      return joinPoint.proceed();
    } finally {
      stopWatch.stop();
      logger.info("Запрос был выполнен за {} мс", stopWatch.getTotalTimeMillis());
    }
  }
}
