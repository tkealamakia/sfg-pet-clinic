package com.tsunazumi.sfgpetclinic.service;

import com.tsunazumi.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

@Service
public interface PetService extends CrudService<Pet, Long> {

}
