package com.example.sbermcfo.refs.service;

import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IfrsTransactionsService {
    Page<IfrsTransactionsDto> getAll(Pageable page);
    IfrsTransactionsDto getById(Integer id);
    void deleteById(Integer id);
    IfrsTransactionsDto create(IfrsTransactionsDto dto);
    IfrsTransactionsDto update(IfrsTransactionsDto dto);
}
