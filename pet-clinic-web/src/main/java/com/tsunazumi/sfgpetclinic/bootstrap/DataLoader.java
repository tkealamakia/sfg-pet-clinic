package com.tsunazumi.sfgpetclinic.bootstrap;

import com.tsunazumi.sfgpetclinic.model.Owner;
import com.tsunazumi.sfgpetclinic.model.Vet;
import com.tsunazumi.sfgpetclinic.service.OwnerService;
import com.tsunazumi.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final OwnerService ownerService;
  private final VetService vetService;

  public DataLoader(OwnerService ownerService, VetService vetService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner();
    owner1.setId(1L);
    owner1.setFirstName("James");
    owner1.setLastName("Bond");
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setId(2L);
    owner2.setFirstName("Austin");
    owner2.setLastName("Powers");
    ownerService.save(owner2);

    System.out.println("Loaded Owners...");

    Vet vet1 = new Vet();
    vet1.setId(1L);
    vet1.setFirstName("Sam");
    vet1.setLastName("Ford");
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setId(2L);
    vet2.setFirstName("Ron");
    vet2.setLastName("Swanson");
    vetService.save(vet2);

    System.out.println("Loaded Vets...");

  }
}
