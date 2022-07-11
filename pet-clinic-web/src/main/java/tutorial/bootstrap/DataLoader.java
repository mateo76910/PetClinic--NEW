package tutorial.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tutorial.model.*;
import tutorial.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0){
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

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Mateo");
        owner1.setLastName("Pokulic");
        owner1.setAddress("123 Strosika");
        owner1.setCity("Osijek");
        owner1.setTelephone("095655372");

        //Owner.builder().address("ADSAD").firstName("").id(1L).build();

        Pet firstPet = new Pet();
        firstPet.setPetType(savedDogPetType);
        firstPet.setOwner(owner1);
        firstPet.setBirthDate(LocalDate.now());
        firstPet.setName("Ogi");
        owner1.getPets().add(firstPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Matija");
        owner2.setLastName("Habjan");
        owner2.setAddress("13233 Strosika");
        owner2.setCity("Osijek");
        owner2.setTelephone("3213213213");

        Pet secondPet = new Pet();
        secondPet.setPetType(savedCatPetType);
        secondPet.setOwner(owner2);
        secondPet.setBirthDate(LocalDate.now());
        secondPet.setName("Lola");
        owner2.getPets().add(secondPet);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(secondPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Zdravko");
        vet1.setLastName("Korpar");
        vet1.getSpeciality().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Maja");
        vet2.setLastName("Logun");
        vet2.getSpeciality().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
