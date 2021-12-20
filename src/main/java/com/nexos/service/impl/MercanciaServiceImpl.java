package com.nexos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexos.dao.IMercanciaDao;
import com.nexos.dao.IUsuarioDao;
import com.nexos.entity.Mercancia;
import com.nexos.entity.Usuario;
import com.nexos.service.IMercanciaService;

import java.util.List;

@Service
public class MercanciaServiceImpl  implements IMercanciaService {

    @Autowired
    private IMercanciaDao mercanciaDao;
    
    @Autowired
    private IUsuarioDao usuarioDao;

    @Override
    public List<Mercancia> findAll() {
        return mercanciaDao.findAll();
    }

    @Override
    public Mercancia saveMercancia(Mercancia mercancia) {
    	Usuario usuario = usuarioDao.
    			findById(mercancia.getUsuario().getIdusuario()).orElse(null);
    	
    	mercancia.setUsuario(usuario);
        return mercanciaDao.save(mercancia);
    }
    
    @Override
    public void deleteMercancia(long id) {
    	mercanciaDao.deleteById(id);
    }
}