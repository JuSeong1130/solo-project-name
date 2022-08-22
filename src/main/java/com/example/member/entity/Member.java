package com.example.member.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String companyName;

    @OneToOne
    @JoinColumn(name="COMPANY_LOCATION")
    private Locations locations;

    @OneToOne
    @JoinColumn(name="COMPANY_TYPE")
    private Types types;



    @Getter
    public enum Gender{

        MALE("GENDER_MALE","남자"),
        FEMALE("GENDER_FEMAL","여자");

        private final String genderString;
        private final String genderKoreanString;

        Gender(String genderString, String genderKoreanString) {
            this.genderString = genderString;
            this.genderKoreanString = genderKoreanString;
        }
    }

}
