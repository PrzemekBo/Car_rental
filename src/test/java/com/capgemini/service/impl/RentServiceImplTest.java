package com.capgemini.service.impl;

import com.capgemini.dto.RentDTO;
import com.capgemini.service.RentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class RentServiceImplTest {

    @Autowired
    private RentService rentService;

    @Test
    public void addRent() {

        RentDTO rentDTO = new RentDTO().builder().cost(2000).rentDate(rentDate).returnDate(returnDate)
                .build();
        RentDTO newRent = rentService.addRent(rentDTO);

        RentalTO addedRental = rentalService.addRental(rentalTO);

        //when
        RentalTO selectedRental = rentalService.findRentaltById(addedRental.getId());

        //then
        assertThat(selectedRental.getId()).isEqualTo(addedRental.getId());

    }
}