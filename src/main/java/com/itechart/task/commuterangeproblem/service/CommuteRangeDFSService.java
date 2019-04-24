package com.itechart.task.commuterangeproblem.service;

        import com.itechart.task.commuterangeproblem.repository.ICityDistanceRepository;
        import org.springframework.cache.annotation.Cacheable;
        import org.springframework.stereotype.Service;

        import java.util.List;


@Service
public class CommuteRangeDFSService implements ICommuteRangeService{


    private final ICityDistanceRepository repository;

    public CommuteRangeDFSService(ICityDistanceRepository repository) {
        this.repository = repository;
    }

    @Override
    @Cacheable("reachable")
    public List<String> getReachableCitiesInSpecifiedTime(String startCityS, int time) throws IllegalArgumentException{
        CommuteRangeWorker worker = CommuteRangeWorker.builder().city(startCityS).time(time).repository(repository).build();
        return worker.execute();
    }
}
