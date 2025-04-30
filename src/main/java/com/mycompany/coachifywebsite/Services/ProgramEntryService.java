package com.mycompany.coachifywebsite.Services;

import com.mycompany.coachifywebsite.Entities.ProgramEntry;
import com.mycompany.coachifywebsite.dto.EntryRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProgramEntryService {

    public ProgramEntry createEntry(EntryRequest entry){

        ProgramEntry entryToBeAdded = new ProgramEntry();
        entryToBeAdded.setDers(entry.getDers());
        entryToBeAdded.setKonu(entry.getKonu());
        entryToBeAdded.setDescription(entry.getDescription());
        entryToBeAdded.setKitap(entry.getKitap());
        entryToBeAdded.setHedef(entry.getHedef());
        entryToBeAdded.setIsDone(entry.getIsDone());
        entryToBeAdded.setSaat(entry.getSaat());

        entryToBeAdded.setProgramID(entry.getProgramID());

        return entryToBeAdded;

    }
}
