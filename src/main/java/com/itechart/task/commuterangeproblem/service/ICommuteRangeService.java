package com.itechart.task.commuterangeproblem.service;

import java.util.List;

public interface ICommuteRangeService {

    List<String> getReachableCitiesInSpecifiedTime(String startCityS, int time) throws IllegalArgumentException;
}
