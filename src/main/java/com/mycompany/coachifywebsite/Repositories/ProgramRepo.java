package com.mycompany.coachifywebsite.Repositories;

import com.mycompany.coachifywebsite.Entities.Program;
import org.springframework.data.repository.CrudRepository;

public interface ProgramRepo extends CrudRepository<Program, String> {
}
