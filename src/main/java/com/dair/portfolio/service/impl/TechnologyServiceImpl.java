package com.dair.portfolio.service.impl;

import com.dair.portfolio.dto.technologyDTO.TechnologyRequestDTO;
import com.dair.portfolio.dto.technologyDTO.TechnologyResponseDTO;
import com.dair.portfolio.entity.Technology;
import com.dair.portfolio.mapper.TechnologyMapper;
import com.dair.portfolio.repository.TechnologyRepository;
import com.dair.portfolio.service.interfac.ITechnologyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements ITechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public TechnologyResponseDTO create(TechnologyRequestDTO dto) {
        Technology technology = TechnologyMapper.toEntity(dto);
        Technology saved = technologyRepository.save(technology);
        return TechnologyMapper.toDTO(saved);
    }

    @Override
    public List<TechnologyResponseDTO> findAll() {
        return TechnologyMapper.toDTOList(technologyRepository.findAll());
    }

    @Override
    public TechnologyResponseDTO findById(Long id) {
        Technology technology = technologyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Technology not found with id: " + id));
        return TechnologyMapper.toDTO(technology);
    }

    @Override
    public TechnologyResponseDTO update(Long id, TechnologyRequestDTO dto) {
        Technology technology = technologyRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Technology not found with id: " + id));
        technology.setName(dto.getName());
        Technology updated = technologyRepository.save(technology);
        return TechnologyMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!technologyRepository.existsById(id)) {
            throw new RuntimeException("Technology not found with id: " + id);
        }
        technologyRepository.deleteById(id);
    }
}
