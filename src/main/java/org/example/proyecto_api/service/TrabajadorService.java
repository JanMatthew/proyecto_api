package org.example.proyecto_api.service;

import org.example.proyecto_api.ConfigProperties;
import org.example.proyecto_api.model.Trabajador;
import org.example.proyecto_api.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private ConfigProperties configProperties;

    public List<Trabajador> getAllTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Trabajador addTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador updateTrabajador(Trabajador trabajador){
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador deleteTrabajador(Long id) throws Throwable{
        Trabajador t = trabajadorRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                try{
                    throw new Exception("El usuario con id " + id + " no existe");
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
        trabajadorRepository.delete(t);
        return t;
    }
}
