package com.mycompany.coachifywebsite.Entities;

import java.time.LocalDateTime;
import java.util.List;



import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Program {

    @Id
    public String id;
    public String title;
    public String description;
    public List<ProgramEntry> entries;
    public String mentorName;
    public String studentName;
    public LocalDateTime date;

}
