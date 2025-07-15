package com.interview.parcelservices.service;

import com.interview.parcelservices.dto.ParcelCreateRequest;
import com.interview.parcelservices.dto.ParcelDeliveryStateEnum;
import com.interview.parcelservices.dto.ParcelDto;
import com.interview.parcelservices.entity.Parcel;
import com.interview.parcelservices.mapper.ParcelMapper;
import com.interview.parcelservices.repository.ParcelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class ParcelServiceImpl implements ParcelService {
    private final ParcelRepository parcelRepository;

    public List<ParcelDto> findByGuestId(UUID guestId) {
        return parcelRepository.findByGuestId(guestId).stream()
                .map(ParcelMapper::toDto)
                .toList();
    }

    @Override
    public ParcelDto createParcel(ParcelCreateRequest input) throws EntityNotFoundException {
        Parcel newEntity = ParcelMapper.toEntity(input);
        newEntity.setDeliveryState(ParcelDeliveryStateEnum.Unclaimed);
        parcelRepository.save(newEntity);
        log.info("[createParcel] Parcel {} created successfully", newEntity.getId());
        return ParcelMapper.toDto(newEntity);
    }

    @Override
    public ParcelDto markClaimed(UUID id) throws EntityNotFoundException {
        Optional<Parcel> maybeParcel = parcelRepository.findById(id);
        if (maybeParcel.isEmpty()) {
            throw new EntityNotFoundException("Parcel not found");
        }

        Parcel found = maybeParcel.get();
        if (found.getDeliveryState().equals(ParcelDeliveryStateEnum.Claimed)) {
            // todo check if parcel had been claimed
        }

        found.setDeliveryState(ParcelDeliveryStateEnum.Claimed);
        parcelRepository.save(found);
        log.info("[markClaimed] Parcel {} set claimed successfully", id);
        return ParcelMapper.toDto(found);
    }
}
