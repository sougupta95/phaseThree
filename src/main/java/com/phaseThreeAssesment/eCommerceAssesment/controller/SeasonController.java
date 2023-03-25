package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.model.Season;
import com.phaseThreeAssesment.eCommerceAssesment.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phaseThree/seasons")
public class SeasonController {

    @Autowired
    SeasonService seasonService;

    @GetMapping("/")
    public List<Season> findAllSeasons(){
        return seasonService.fetchList();
    }

    @GetMapping("/{id}")
    public Season findById(@PathVariable(value = "id") long id){
        return seasonService.getById(id);
    }

    @PostMapping("/")
    public Season createSeason(@RequestBody Season season){
        return seasonService.create(season);
    }

    @PutMapping("/{id}")
    public Season updateSeason(@PathVariable(value = "id") long id, @RequestBody Season season){
        return seasonService.update(season,id);
    }
    @DeleteMapping("/{id}")
    public String deleteSeason(@PathVariable(value = "id") long id){
        seasonService.deleteById(id);
        return "Deleted";
    }
}
