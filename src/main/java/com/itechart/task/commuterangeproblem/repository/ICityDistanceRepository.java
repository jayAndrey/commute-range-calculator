package com.itechart.task.commuterangeproblem.repository;


public interface ICityDistanceRepository {
    int getNumberOfCities();

    int getCommuteBetweenCities(String origin, String destination);

    int getCommuteBetweenCities(int origin, int destination);

    Integer getIdOfCity(String city);

    String getCityById(int cityId);

}
