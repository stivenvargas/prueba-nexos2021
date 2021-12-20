package com.nexos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexos.entity.Usuario;


public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
}
