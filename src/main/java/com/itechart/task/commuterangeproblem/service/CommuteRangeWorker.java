package com.itechart.task.commuterangeproblem.service;

import com.itechart.task.commuterangeproblem.repository.ICityDistanceRepository;
import lombok.Builder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommuteRangeWorker {

    private String city;
    private int time;
    private ICityDistanceRepository repository;

    @Builder
    public CommuteRangeWorker(String city, int time, ICityDistanceRepository repository) {
        this.city = city;
        this.time = time;
        this.repository = repository;
    }

    private Set<Integer> visited = new HashSet<>();

    /**
     * Public method to perform a search for reachable cities
     * @return list of reachable cities on the specified time
     */
    public List<String> execute() throws IllegalArgumentException{
        if (repository.getIdOfCity(city) == null) {
            throw new IllegalArgumentException("City isn't found");
        }
        int cityId = repository.getIdOfCity(city);
        getReachableCitiesInSpecifiedTime(cityId, time);
        return visited
                .stream()
                    .map(id -> repository.getCityById(id))
                        .collect(Collectors.toList());
    }

    /**
     * Customized DFS that limited by time
     * @param startCity id of start city
     * @param time time limit
     */
    private void getReachableCitiesInSpecifiedTime(int startCity, int time) {
        //TODO refactor to avoid class element
        visited.add(startCity);
        for (int i = 0; i < repository.getNumberOfCities(); i++) {
            int timeBetween = repository.getCommuteBetweenCities(startCity, i);
            if (timeBetween > 0) {
                if (time >= timeBetween && !visited.contains(i)) {
                    getReachableCitiesInSpecifiedTime(i, time - timeBetween);
                }
            }
        }
    }


}
