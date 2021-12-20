package com.nexos.service;

import org.springframework.stereotype.Service;

import com.nexos.entity.Mercancia;

import java.util.List;

@Service
public interface IMercanciaService {

    public List<Mercancia> findAll();

    public  Mercancia saveMercancia(Mercancia mercancia);
    
    public void deleteMercancia(long id);
}
