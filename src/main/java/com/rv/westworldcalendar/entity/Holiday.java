package com.rv.westworldcalendar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="holiday")
public class Holiday {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    @Column(name="country_id")
    Integer countryId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date date;

    String name;

    String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="country_id")
    @MapsId("countryId")
    Country country;

}
