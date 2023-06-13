package com.example.appinicial.controller;

import com.example.appinicial.dto.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("usuarios")
public class UsuarioControler {
    //http://localhost:8081/usuario
    Map<String, String> mapUsers = new HashMap<>();

    @PostMapping("create")
    public ResponseEntity<Object> createUser(@RequestBody UsuarioDTO usuarioDTO) {
        mapUsers.put("1", usuarioDTO.getNombre());
        mapUsers.put("2", usuarioDTO.getApellido());


        return ResponseEntity.status(HttpStatus.OK).body(mapUsers);

    }


    @GetMapping("read/{id}")
    public ResponseEntity<Object> readUser(@PathVariable String id) {

            return ResponseEntity.status(mapUsers.containsKey(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(mapUsers.containsKey(id) ? mapUsers.get(id) : "no existe");
            /*
            if (mapUsers.containsKey(id)) {
             return ResponseEntity.status(HttpStatus.OK).body(mapUsers.get(id));

        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("no existe");

             */
        }


        @PutMapping("update/{id}")
        public ResponseEntity<Object> updateUser (@RequestBody UsuarioDTO usuarioDTO,@PathVariable String id  ){
            mapUsers.put(id, usuarioDTO.getNombre());

            return ResponseEntity.status(HttpStatus.OK).body(mapUsers);
        }


        @DeleteMapping("delete/{id}")
        public ResponseEntity<Object> deleteUser (@PathVariable String id  ){
        mapUsers.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }


    }

