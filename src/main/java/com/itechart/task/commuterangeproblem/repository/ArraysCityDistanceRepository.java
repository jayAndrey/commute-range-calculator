package com.itechart.task.commuterangeproblem.repository;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.springframework.stereotype.Repository;

@Repository
public class ArraysCityDistanceRepository implements ICityDistanceRepository {
    private BiMap<String, Integer> cities = HashBiMap.create();
    private int[][] graph;

    public ArraysCityDistanceRepository() {
        initAll();
    }

    /**
     * Get number of available cities
     * @return
     */
    public int getNumberOfCities() {
        return cities.size();
    }

    /**
     * Get time between 2 cities by names
     * @param origin origin
     * @param destination destination
     * @return time
     */
    public int getCommuteBetweenCities(String origin, String destination) {
        return getCommuteBetweenCities(getIdOfCity(origin), getIdOfCity(destination));
    }

    /**
     * Get time between 2 cities by id
     * @param origin originId
     * @param destination destinationId
     * @return time
     */
    public int getCommuteBetweenCities(int origin, int destination) {
        return graph[origin][destination];
    }

    /**
     * Get ID of city by name
     * @param city city name
     * @return id
     */
    public Integer getIdOfCity(String city) {
        return cities.get(city);
    }

    /**
     * Get city name by id
     * @param cityId city name
     * @return id
     */
    public String getCityById(int cityId) {
        return cities.inverse().get(cityId);
    }

    private void initAll() {
        cities.put("Gomel", 0);
        cities.put("Zlobin", 1);
        cities.put("Bobruisk", 2);
        cities.put("Minsk", 3);
        cities.put("Baranovichi", 4);
        cities.put("Bereza", 5);
        cities.put("Kobrin", 6);
        cities.put("Brest", 7);
        cities.put("Borisov", 8);
        cities.put("Orsha", 9);
        cities.put("Mogilev", 10);
        cities.put("Vitebsk", 11);
        cities.put("Lepel", 12);
        cities.put("Polotsk", 13);
        cities.put("Slytsk", 14);
        cities.put("Mozyr", 15);
        cities.put("Zytkovichi", 16);
        cities.put("Pinsk", 17);
        cities.put("Lida", 18);
        cities.put("Grodno", 19);
        graph = new int[][] {{0, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0},
                {9, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 7, 0, 15, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 12, 0, 0, 0, 0, 0},
                {0, 0, 15, 0, 15, 0, 0, 0, 8, 0, 0, 0, 16, 0, 10, 0, 0, 0, 17, 0},
                {0, 0, 0, 15, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 10, 0, 6, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 6, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0},
                {0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26},
                {0, 0, 0, 8, 0, 0, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 12, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 7, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 12, 10, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 0, 0, 0},
                {14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 12, 0, 14, 0, 0},
                {0, 0, 0, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 0, 0},
                {0, 0, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11},
                {0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0}};
    }

}
