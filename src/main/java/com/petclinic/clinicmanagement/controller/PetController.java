package com.petclinic.clinicmanagement.controller;

import com.petclinic.clinicmanagement.model.Pet;
import com.petclinic.clinicmanagement.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping
    public Pet addPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable int id) {
        petService.deletePet(id);
    }
}
