package com.interview.parcelservices.mapper;

import com.interview.parcelservices.dto.ParcelCreateRequest;
import com.interview.parcelservices.dto.ParcelDto;
import com.interview.parcelservices.entity.Parcel;

public class ParcelMapper {
    public static ParcelDto toDto(Parcel from) {
        if (from == null) {
            return null;
        }

        return ParcelDto.builder()
                .id(from.getId())
                .senderName(from.getSenderName())
                .name(from.getName())
                .guestId(from.getGuestId())
                .deliveryState(from.getDeliveryState())
                .build();
    }

    public static Parcel toEntity(ParcelCreateRequest from) {
        if (from == null) {
            return null;
        }

        return Parcel.builder()
                .senderName(from.getSenderName())
                .name(from.getName())
                .guestId(from.getGuestId())
                .build();
    }
}