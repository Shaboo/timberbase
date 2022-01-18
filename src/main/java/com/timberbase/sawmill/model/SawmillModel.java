package com.timberbase.sawmill.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Builder
@Jacksonized
@Entity
@Table(
        name = "Sawmill",
        indexes = {
                @Index(name = "idx_sawmill_name", columnList = "name")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SawmillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "city", nullable = false)
    String city;

    @Column(name = "country", nullable = false)
    String country;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP", nullable = false)
    ZonedDateTime createdAt;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "updatedAt", columnDefinition = "TIMESTAMP", nullable = false)
    ZonedDateTime updatedAt;
}
