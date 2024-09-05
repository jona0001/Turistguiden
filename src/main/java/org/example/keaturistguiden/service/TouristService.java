package org.example.keaturistguiden.service;

import org.example.keaturistguiden.model.TouristAttraction;
import org.example.keaturistguiden.repo.TouristRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

private final TouristRepo touristRepo;

    public TouristService(TouristRepo touristRepo){
        this.touristRepo = touristRepo;
    }

   public List<TouristAttraction>getAllAttractions(){
        return touristRepo.getTouristAttractions();
   }

    public TouristAttraction addAttraction(TouristAttraction attraction){
        return touristRepo.addTouristAttraction(attraction);
    }

    public boolean deleteAttraction(String name){
        return touristRepo.deleteTouristAttraction(name);
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction){
        return touristRepo.updateTouristAttraction(touristAttraction);
    }






}
