package com.capgemini.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@MappedSuperclass
public abstract class AbstractEntity {


    private LocalDateTime creationDate;
    private LocalDateTime updateDateTime;


    @PreUpdate
    public void updateDateTime() {
        updateDateTime = LocalDateTime.now();
    }

    @PrePersist
    public void createCreationDate() {
        creationDate = LocalDateTime.now();
    }

}
