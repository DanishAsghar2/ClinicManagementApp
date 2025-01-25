package com.petclinic.clinicmanagement.repository;

import com.petclinic.clinicmanagement.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
