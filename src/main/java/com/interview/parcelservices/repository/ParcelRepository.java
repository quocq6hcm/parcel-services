package com.interview.parcelservices.repository;

import com.interview.parcelservices.entity.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, UUID> {
    List<Parcel> findByGuestId(UUID guestId);
}
