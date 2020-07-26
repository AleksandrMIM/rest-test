package ru.mina.test.rest.interactor;

import ru.mina.test.rest.model.CameraModel;

import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.07.2020
 * Time: 2:18
 */
public interface CameraInteractor {

  /**
   * Получение информации по камерам
   *
   * @return информация по камерам
   */
  List<CameraModel> getCameras();
}
