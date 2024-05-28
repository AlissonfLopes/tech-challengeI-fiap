package br.com.fiap.tech_challenge.controller;

import br.com.fiap.tech_challenge.dto.AparelhoDTO;
import br.com.fiap.tech_challenge.service.AparelhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/aparelho")
public class AparelhoController {

    private AparelhoService aparelhoService;

    @Autowired
    public AparelhoController(AparelhoService aparelhoService) {
        this.aparelhoService = aparelhoService;
    }

    @GetMapping
    public ResponseEntity<Collection<AparelhoDTO>> findAll() {
        return ResponseEntity.ok(aparelhoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AparelhoDTO> findById(@PathVariable Long id) {
        AparelhoDTO aparelhoDTO = aparelhoService.findById(id);
        return ResponseEntity.ok(aparelhoDTO);
    }

    @PostMapping
    public ResponseEntity<AparelhoDTO> insert(@RequestBody AparelhoDTO aparelhoDTO) {
        AparelhoDTO insertAparelhoDTO = aparelhoService.insert(aparelhoDTO);
        return ResponseEntity.status(201).body(insertAparelhoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AparelhoDTO> update(@PathVariable Long id, @Valid @RequestBody AparelhoDTO aparelhoDTO) {
        AparelhoDTO upateAparelhoDTO = aparelhoService.update(id, aparelhoDTO);
        return ResponseEntity.ok(upateAparelhoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        aparelhoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
