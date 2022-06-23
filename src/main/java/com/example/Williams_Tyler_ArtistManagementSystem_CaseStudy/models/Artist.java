package com.example.Williams_Tyler_ArtistManagementSystem_CaseStudy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String artistName;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String label;
    @Column
    private String genre;
    @Column
    private String phoneNumber;
    @Column
    private String email;
}
