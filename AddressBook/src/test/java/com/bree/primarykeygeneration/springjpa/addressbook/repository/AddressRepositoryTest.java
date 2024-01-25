package com.bree.primarykeygeneration.springjpa.addressbook.repository;

import com.bree.primarykeygeneration.springjpa.addressbook.entity.Addresses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bree.primarykeygeneration.springjpa.addressbook.entity.Addresses.saved;

@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveMethod(){

        //create an object of class Addresses
        Addresses addresses = new Addresses();
        addresses.setCity("Southfield");
        addresses.setCountry("USA");
        addresses.setState("Michigan");
        addresses.setZip_code("011-0012");

        //save the object
        saved = addressRepository.save(addresses);

        System.out.println(saved.getId());
        System.out.println(saved.toString());
    }

    @Test
    void updateUsingSaveMethod(){
        //find the entity by id
        Long id = 1L;
        Addresses addresses = addressRepository.findById(id).get();

        //updatethe entity informtion
        addresses.setState("Texas");
        addresses.setCity("Warren");

        addressRepository.save(addresses);
    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Addresses addresses = addressRepository.findById(id).get();
    }
}
