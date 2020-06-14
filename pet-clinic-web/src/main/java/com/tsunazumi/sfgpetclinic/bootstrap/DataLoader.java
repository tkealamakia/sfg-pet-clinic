package com.tsunazumi.sfgpetclinic.bootstrap;

import com.tsunazumi.sfgpetclinic.model.*;
import com.tsunazumi.sfgpetclinic.service.OwnerService;
import com.tsunazumi.sfgpetclinic.service.PetTypeService;
import com.tsunazumi.sfgpetclinic.service.SpecialtyService;
import com.tsunazumi.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }

  @Override
  public void run(String... args) throws Exception {
    int count = petTypeService.findAll().size();
    if (count == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);
    System.out.println("Loaded Pet Types...");

    Specialty radiology = new Specialty();
    radiology.setDescription("Radiology");
    Specialty savedRadiology = specialtyService.save(radiology);

    Specialty surgery = new Specialty();
    radiology.setDescription("Surgery");
    Specialty savedSurgery = specialtyService.save(surgery);

    Specialty dentistry = new Specialty();
    radiology.setDescription("Dentistry");
    Specialty savedDentistry = specialtyService.save(dentistry);

    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("James");
    owner1.setLastName("Bond");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("London");
    owner1.setTelephone("800-007-0007");
    ownerService.save(owner1);

    Pet bondsPet = new Pet();
    bondsPet.setPetType(savedDogPetType);
    bondsPet.setOwner(owner1);
    bondsPet.setBirthDate(LocalDate.now());
    bondsPet.setName("Rosco");
    owner1.getPets().add(bondsPet);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Austin");
    owner2.setLastName("Powers");
    owner2.setAddress("123 Groovy");
    owner2.setCity("London");
    owner2.setTelephone("800-123-2343");
    ownerService.save(owner2);

    Pet austinsPet = new Pet();
    austinsPet.setPetType(savedCatPetType);
    austinsPet.setOwner(owner2);
    austinsPet.setBirthDate(LocalDate.now());
    austinsPet.setName("Puddy");
    owner2.getPets().add(austinsPet);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Sam");
    vet1.setLastName("Ford");
    vet1.getSpecialtySet().add(savedRadiology);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Ron");
    vet2.setLastName("Swanson");
    vet2.getSpecialtySet().add(savedSurgery);
    vetService.save(vet2);

    System.out.println("Loaded Vets...");
  }
}
