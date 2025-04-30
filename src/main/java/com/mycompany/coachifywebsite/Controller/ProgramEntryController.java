package com.mycompany.coachifywebsite.Controller;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.mycompany.coachifywebsite.Entities.Program;
import com.mycompany.coachifywebsite.Entities.ProgramEntry;
import com.mycompany.coachifywebsite.Repositories.ProgramEntryRepo;
import com.mycompany.coachifywebsite.Repositories.ProgramRepo;
import com.mycompany.coachifywebsite.Services.ProgramEntryService;
import com.mycompany.coachifywebsite.dto.EntryID;
import com.mycompany.coachifywebsite.dto.EntryRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProgramEntryController {

    @Autowired
    private ProgramEntryRepo programEntryRepo;

    @Autowired
    private ProgramEntryService programEntryService;

    @Autowired
    private ProgramRepo programRepo;

    @PostMapping("/createEntry") // create a new entry
    public ResponseEntity<String> CreateEntry(@RequestBody EntryRequest entry){

        ProgramEntry entryToBeAdded = programEntryService.createEntry(entry);
        programEntryRepo.save(entryToBeAdded);
        return ResponseEntity.ok("Entry added");
    }

    @PostMapping("/addEntryToProgram")
    public ResponseEntity<String> addEntryToProgram(@RequestBody EntryID entrySent){
        String id = entrySent.getEntryID();
        Optional<ProgramEntry> entryOptional = programEntryRepo.findById(id);

        if (entryOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Program entry not found");
        }

        ProgramEntry entryToBeAdded = entryOptional.get();

        String programId = entryToBeAdded.getProgramID();
        Optional<Program> targetProgramOptional = programRepo.findById(programId);

        if (targetProgramOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Target program not found");
        }



        Program targetProgram = targetProgramOptional.get();


        List<ProgramEntry> entries = Optional.ofNullable(targetProgram.getEntries()).orElse(new ArrayList<>());
        if(entries.contains(entryToBeAdded)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Entry already exists");
        }
        entries.add(entryToBeAdded);
        targetProgram.setEntries(entries);

        programRepo.save(targetProgram);

        return ResponseEntity.ok("Entry successfully added to the program.");
    }



    @GetMapping("/getEntry/{id}") // get an entry by its id
    public ResponseEntity<ProgramEntry> getProgramEntry(@PathVariable String id){
        Optional<ProgramEntry> programEntry = programEntryRepo.findById(id);
        return programEntry.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
