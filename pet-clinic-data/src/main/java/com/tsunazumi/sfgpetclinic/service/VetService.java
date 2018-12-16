package com.tsunazumi.sfgpetclinic.service;

import com.tsunazumi.sfgpetclinic.model.Pet;
import com.tsunazumi.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

  Vet findById(Long id);

  Vet save(Vet vet);

  Set<Vet> findAll();

}
