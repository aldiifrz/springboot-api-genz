package com.boniewijaya2021.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_person", schema = "sample")
public class TblPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", columnDefinition = "serial")
    private Long idPerson;

    @Column(name = "person_name", nullable = false)
    private String personName;

    @Column(name = "person_age", nullable = false)
    private int personAge;

    @Column(name = "person_email", nullable = false)
    private String personEmail;

    @Column (name = "person_url", nullable = false)
    private String personUrl;

    @Column (name = "person_description", nullable = false)
    private String personDescription;


}
