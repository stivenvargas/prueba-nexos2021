package com.nexos.service;


import com.nexos.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Optional<Usuario> findById(long id);

    public Usuario save(Usuario usuario);
}