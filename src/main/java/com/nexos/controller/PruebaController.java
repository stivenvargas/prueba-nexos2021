package com.nexos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.nexos.entity.Mercancia;
import com.nexos.entity.Usuario;
import com.nexos.service.IMercanciaService;
import com.nexos.service.IUsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PruebaController {

	@Autowired
    private IUsuarioService iUsuarioService;
	
	@Autowired
	private IMercanciaService iMercanciaService;

    @PostMapping("/addUsuario")
    public ResponseEntity<?> addUsuario(@RequestBody  Usuario usuario){
        Usuario usuarioResponse = null;
        Map<String,Object> response = new HashMap<>();
        try {
            usuarioResponse = iUsuarioService.save(usuario);

        }catch (HttpServerErrorException.InternalServerError e){
            response.put("error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            response.put("error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/allUsuarios")
    public ResponseEntity<?> getUsuarios (){
    	List<Usuario> listUsuarioResponse = null;
    	Map<String,Object> response = new HashMap<>();
    	try {
			listUsuarioResponse = iUsuarioService.findAll();
		} catch (Exception e) {
			response.put("error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    	return new ResponseEntity<>(listUsuarioResponse, HttpStatus.OK);
    	
    }
    
    @GetMapping("/allMercancia")
    public ResponseEntity<?> getMercancia (){
    	List<Mercancia> listMercanciaResponse = null;
    	Map<String,Object> response = new HashMap<>();
    	try {
    		listMercanciaResponse = iMercanciaService.findAll();
		} catch (Exception e) {
			response.put("error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    	return new ResponseEntity<>(listMercanciaResponse, HttpStatus.OK);
    	
    }
    
    @DeleteMapping("/mercancia/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
    	Map<String, Object> response = new HashMap<>();
		
		try {
			iMercanciaService.deleteMercancia(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la mercancia de la base de datos.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Mercancia eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    
    @PostMapping("/addMercancia")
    public ResponseEntity<?> addMercancia(@RequestBody  Mercancia mercancia){
        Mercancia mercanciaResponse = null;
        Map<String,Object> response = new HashMap<>();
        try {
        	mercanciaResponse = iMercanciaService.saveMercancia(mercancia);

        }catch (HttpServerErrorException.InternalServerError e){
            response.put("error: ", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch (Exception e){
            response.put("error: ", e.getStackTrace());
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(mercanciaResponse, HttpStatus.CREATED);
    }
}

