package org.example.keaturistguiden.controller;


import org.example.keaturistguiden.model.TouristAttraction;
import org.example.keaturistguiden.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    //getting everything works
    @GetMapping("")
    public ResponseEntity<List<TouristAttraction>> getAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    //name works
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return new ResponseEntity<>(attraction, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //add works
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        return new ResponseEntity<>(touristService.addAttraction(touristAttraction), HttpStatus.CREATED);
    }

    //works
    @PostMapping("/delete/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name){
        boolean deleted = touristService.deleteAttraction(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/edit")
    public ResponseEntity<TouristAttraction> editAttraction(@RequestBody TouristAttraction touristAttraction){
        return new ResponseEntity<>(touristService.updateAttraction(touristAttraction), HttpStatus.OK);
    }








}
