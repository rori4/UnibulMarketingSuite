package com.unibul.services.personas;

import com.unibul.entities.Persona;
import com.unibul.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void add(Persona persona) {
        personaRepository.save(persona);
    }
}
