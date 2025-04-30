package com.mycompany.coachifywebsite.Services;

import com.mycompany.coachifywebsite.Entities.Program;
import com.mycompany.coachifywebsite.dto.ProgramRequest;
import org.springframework.stereotype.Service;

@Service
public class ProgramService {

    public Program createProgram(ProgramRequest programRequest){

        Program programToBeAdded = new Program();

        programToBeAdded.setTitle(programRequest.getTitle());
        programToBeAdded.setDescription(programRequest.getDescription());
        programToBeAdded.setMentorName(programRequest.getMentorName());
        programToBeAdded.setStudentName(programRequest.getStudentName());
        programToBeAdded.setDate(programRequest.getDate());

        return programToBeAdded;
    }
}
