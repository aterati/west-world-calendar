package com.rv.westworldcalendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="country")
public class Country {

    @Getter
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="country_id")
    Integer countryId;


    String countryName;

    String countryCode;

    String description;

    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER ,mappedBy = "countryId")
    Set<Holiday> holiday;

}
