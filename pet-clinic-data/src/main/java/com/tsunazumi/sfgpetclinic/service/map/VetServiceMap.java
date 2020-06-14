package com.tsunazumi.sfgpetclinic.service.map;

import com.tsunazumi.sfgpetclinic.model.Specialty;
import com.tsunazumi.sfgpetclinic.model.Vet;
import com.tsunazumi.sfgpetclinic.service.SpecialtyService;
import com.tsunazumi.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public Vet save(Vet object) {
    if (object.getSpecialtySet().size() > 0) {
      object.getSpecialtySet().forEach(specialty -> {
        if (specialty.getId() == null) {
          Specialty savedSpecialty = specialtyService.save(specialty);
          specialty.setId(savedSpecialty.getId());
        }
      });
    }
    return super.save(object.getId(), object);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
