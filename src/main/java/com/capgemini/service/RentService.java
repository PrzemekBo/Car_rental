package com.capgemini.service;


import com.capgemini.dto.RentDTO;

public interface RentService {

    RentDTO findRenttById(Long id);

    RentDTO addRent(RentDTO rentDTO);
}
