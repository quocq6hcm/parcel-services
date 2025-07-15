package com.interview.parcelservices.service;

import com.interview.parcelservices.dto.ParcelCreateRequest;
import com.interview.parcelservices.dto.ParcelDto;

import java.util.List;
import java.util.UUID;

public interface ParcelService {
    List<ParcelDto> findByGuestId(UUID guestId);
    ParcelDto createParcel(ParcelCreateRequest input);
    ParcelDto markClaimed(UUID id);
}
