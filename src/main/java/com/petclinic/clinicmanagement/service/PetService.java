package com.petclinic.clinicmanagement.service;

import com.petclinic.clinicmanagement.model.Pet;
import com.petclinic.clinicmanagement.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(int id) {
        petRepository.deleteById(id);
    }
}
