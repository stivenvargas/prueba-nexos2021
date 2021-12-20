package com.nexos.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nexos.entity.Mercancia;

public interface IMercanciaDao  extends JpaRepository<Mercancia,Long> {

}
