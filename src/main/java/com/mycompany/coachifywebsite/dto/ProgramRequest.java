package com.mycompany.coachifywebsite.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequest {

    private String title;
    private String description;
    private List<EntryRequest> entries;
    private String mentorName;
    private String studentName;
    private LocalDateTime date;

}
