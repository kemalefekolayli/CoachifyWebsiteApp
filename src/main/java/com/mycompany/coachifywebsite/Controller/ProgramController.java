package com.mycompany.coachifywebsite.Controller;



import com.mycompany.coachifywebsite.Entities.Program;
import com.mycompany.coachifywebsite.Repositories.ProgramRepo;
import com.mycompany.coachifywebsite.Services.ProgramService;
import com.mycompany.coachifywebsite.dto.ProgramRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class ProgramController {

    @Autowired
    private ProgramRepo programRepo;
    @Autowired
    private ProgramService programService;


    @PostMapping("/freeUse") //
    public ResponseEntity<String> freeUse(@RequestBody String body) {
        if(Objects.equals(body, "ok")){
            return new ResponseEntity<>("ok", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createProgram") // create a new program
    public ResponseEntity<String> createProgram(@RequestBody ProgramRequest programRequest){

        Program programToBeAdded = programService.createProgram(programRequest);

        // Save the program to the database
        programRepo.save(programToBeAdded);

        // Return a proper success response
        return ResponseEntity.status(HttpStatus.CREATED).body("Program successfully added.");
    }



    @GetMapping("/progController/{id}") // get a program by its id
    public ResponseEntity<Program> getProgram(@PathVariable String id){
        Optional<Program> program = programRepo.findById(String.valueOf(id));
        return program.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
