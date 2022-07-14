package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {

    public ContinenteDTO save(ContinenteDTO dto);

    void delete(Long id);

    List<ContinenteDTO> getAllContinentes();
}
