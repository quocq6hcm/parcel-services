package com.interview.parcelservices.entity;

import com.interview.parcelservices.dto.ParcelDeliveryStateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parcel extends AuditableEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String senderName;
    private String name;
    private UUID guestId;
    private ParcelDeliveryStateEnum deliveryState;

    // todo add more field for audit purposes.
    // claimedDate, etc
}
