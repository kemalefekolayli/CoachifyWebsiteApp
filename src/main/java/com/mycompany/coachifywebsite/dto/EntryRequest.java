package com.mycompany.coachifywebsite.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class EntryRequest {

    private String saat;
    private String description;
    private Boolean isDone;
    private String konu;
    private String ders;
    private String kitap;
    private String hedef;
    private String programID;

}
