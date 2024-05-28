package br.com.fiap.tech_challenge.controller;

import br.com.fiap.tech_challenge.dto.UsuarioDTO;
import br.com.fiap.tech_challenge.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Collection<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.findById(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping()
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO insertUsuarioDTO = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(201).body(insertUsuarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updateUsuarioDTO = usuarioService.update(usuarioDTO);
        return ResponseEntity.ok(updateUsuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
