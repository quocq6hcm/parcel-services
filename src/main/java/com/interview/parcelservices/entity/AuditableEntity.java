package com.interview.parcelservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(org.springframework.data.jpa.domain.support.AuditingEntityListener.class)
public abstract class AuditableEntity {
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    protected Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    protected Instant updatedAt;

}
