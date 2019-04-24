package com.itechart.task.commuterangeproblem.controller;

import com.itechart.task.commuterangeproblem.service.ICommuteRangeService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommuteRangeRESTController {

    Logger logger = LogManager.getLogger(CommuteRangeRESTController.class);
    private final ICommuteRangeService service;

    public CommuteRangeRESTController(ICommuteRangeService service) {
        this.service = service;
    }

    @GetMapping("/AllCities")
    @ApiOperation("Get list of supported cities")
    public List<String> getAllCities(){
        logger.debug("Request for all cities");
        return Arrays.asList("Gomel", "Brest", "Mogilev", "Minsk", "Vitebsk");
    }

    /**
     * REST representation method returns list of reachable cities on the specific time
     * @param city start city
     * @param time time to spend
     * @return list of cities that can be reached on this time
     */
    @GetMapping("/GetRange")
    @ApiOperation("Get list of reachable cities on the time")
    public List<String> getCitiesReachedOnTime(@RequestParam("city")String city, @RequestParam("time")int time) throws IllegalArgumentException {
        logger.debug(String.format("Request for reachable citis from %s till $d time", city, time));
        return service.getReachableCitiesInSpecifiedTime(city, time);
    }
}
