package org.example.keaturistguiden.repo;

import org.example.keaturistguiden.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepo {
    private List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepo() {
        touristAttractions.add(new TouristAttraction( "Tivoli","park"));
        touristAttractions.add(new TouristAttraction( "Amalienborg","slot"));
        touristAttractions.add(new TouristAttraction("Nationalmuseet","museum"));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }


    public TouristAttraction addTouristAttraction(TouristAttraction attraction) {
        touristAttractions.add(attraction);
        return attraction;
    }

    public boolean deleteTouristAttraction(String name) {
        return touristAttractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        for (int i =0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getName().equalsIgnoreCase(touristAttraction.getName())){
                touristAttractions.set(i, touristAttraction);
            }
        }
        return touristAttraction;
    }


}
