package com.interview.parcelservices.controller;

import com.interview.parcelservices.dto.ParcelCreateRequest;
import com.interview.parcelservices.dto.ParcelDto;
import com.interview.parcelservices.service.ParcelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ParcelController {
    private final ParcelService parcelService;

    @GetMapping("/parcels/guests/{guestId}")
    public List<ParcelDto> findByGuestIds(@PathVariable UUID guestId) {
        return parcelService.findByGuestId(guestId);
    }

    @PostMapping("/parcels")
    public ParcelDto create(@Valid @RequestBody ParcelCreateRequest request) {
        return parcelService.createParcel(request);
    }

    @PostMapping("/parcels/{id}/claim")
    public ParcelDto markClaimed(@PathVariable UUID id) {
        return parcelService.markClaimed(id);
    }
}
