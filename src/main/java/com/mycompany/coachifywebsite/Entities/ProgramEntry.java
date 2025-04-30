package com.mycompany.coachifywebsite.Entities;


import jdk.jfr.Enabled;
import org.springframework.data.annotation.Id;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public class ProgramEntry {


    @Id
    public String id;
    public String saat;
    public String description;
    public Boolean isDone;
    public String konu;
    public String ders;
    public String kitap;
    public String hedef;
    @Getter
    @Setter
    public String programID;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramEntry that = (ProgramEntry) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }



}
