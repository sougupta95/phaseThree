package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.Season;
import com.phaseThreeAssesment.eCommerceAssesment.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    @Autowired
    SeasonRepository seasonRepository;
    public Season create(Season season) {
       return seasonRepository.save(season);
    }

    public List<Season> fetchList() {
        return seasonRepository.findAll();
    }

    public Season getById(long id) {
        return seasonRepository.findById(id).orElse(null);
    }

    public Season update(Season season, long id) {
        Season seasonEntity = seasonRepository.findById(id).orElse(null);
        if(seasonEntity != null){
            seasonEntity.setName(season.getName());
            return seasonRepository.save(seasonEntity);
        }
        return null;
    }

   public void deleteById(long id) {
        Season season = seasonRepository.findById(id).orElse(null);
        if(season != null) seasonRepository.delete(season);
    }
}
