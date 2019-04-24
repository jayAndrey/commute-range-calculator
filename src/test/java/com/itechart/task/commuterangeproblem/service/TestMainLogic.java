package com.itechart.task.commuterangeproblem.service;

import com.itechart.task.commuterangeproblem.repository.ICityDistanceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMainLogic {
    private ICityDistanceRepository repository;

    @Before
    public void setUp() {
        repository = mock(ICityDistanceRepository.class);
        when(repository.getCityById(0)).thenReturn("AA");
        when(repository.getCityById(1)).thenReturn("BB");
        when(repository.getCityById(2)).thenReturn("CC");
        when(repository.getIdOfCity("AA")).thenReturn(0);
        when(repository.getIdOfCity("BB")).thenReturn(1);
        when(repository.getIdOfCity("CC")).thenReturn(2);
        when(repository.getCommuteBetweenCities(0, 1)).thenReturn(3);
        when(repository.getCommuteBetweenCities(0, 2)).thenReturn(0);
        when(repository.getCommuteBetweenCities(1, 0)).thenReturn(3);
        when(repository.getCommuteBetweenCities(1, 2)).thenReturn(4);
        when(repository.getCommuteBetweenCities(2, 0)).thenReturn(0);
        when(repository.getCommuteBetweenCities(2, 1)).thenReturn(4);
        when(repository.getNumberOfCities()).thenReturn(3);
    }

    @Test
    public void test() {
        CommuteRangeWorker worker = CommuteRangeWorker.builder().city("AA").time(0).repository(repository).build();
        List<String> result = worker.execute();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(result.get(0), "AA");
    }

    @Test
    public void test2() {
        CommuteRangeWorker worker = CommuteRangeWorker.builder().city("AA").time(4).repository(repository).build();
        List<String> result = worker.execute();
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(result.get(0), "AA");
        Assert.assertEquals(result.get(1), "BB");
    }

}
