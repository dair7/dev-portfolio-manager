package com.dair.portfolio.controller;

import com.dair.portfolio.dto.technologyDTO.TechnologyRequestDTO;
import com.dair.portfolio.dto.technologyDTO.TechnologyResponseDTO;
import com.dair.portfolio.service.interfac.ITechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final ITechnologyService technologyService;

    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> create(@RequestBody TechnologyRequestDTO dto) {
        return new ResponseEntity<>(technologyService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {
        return ResponseEntity.ok(technologyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(technologyService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyResponseDTO> update(@PathVariable Long id, @RequestBody TechnologyRequestDTO dto) {
        return ResponseEntity.ok(technologyService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        technologyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
