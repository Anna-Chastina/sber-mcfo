package com.example.sbermcfo.refs.service;

import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IfrsTransactionsService {
    Page<IfrsTransactionsDto> getAll(Pageable page);
    List<IfrsTransactionsDto> getAll();
    IfrsTransactionsDto getById(Integer id);
    void deleteById(Integer id);
    IfrsTransactionsDto create(IfrsTransactionsDto dto);
    IfrsTransactionsDto update(IfrsTransactionsDto dto);
}
