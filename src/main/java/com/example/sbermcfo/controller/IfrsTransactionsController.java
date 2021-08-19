package com.example.sbermcfo.controller;

import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import com.example.sbermcfo.refs.service.IfrsTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class IfrsTransactionsController {
    private IfrsTransactionsService ifrsTransactionsService;

    @Autowired
    public IfrsTransactionsController(IfrsTransactionsService ifrsTransactionsService) {
        this.ifrsTransactionsService = ifrsTransactionsService;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IfrsTransactionsDto> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(ifrsTransactionsService.getById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<IfrsTransactionsDto>> getAll(
            @RequestParam(value="size") int size,
            @RequestParam(value="page", defaultValue = "0") int page
    ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(ifrsTransactionsService.getAll(paging));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IfrsTransactionsDto> create(@RequestBody IfrsTransactionsDto dto) {
        try {
            return ResponseEntity.ok(ifrsTransactionsService.create(dto));
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IfrsTransactionsDto> update(@RequestBody IfrsTransactionsDto dto) {
        try{
            return ResponseEntity.ok(ifrsTransactionsService.update(dto));
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        ifrsTransactionsService.deleteById(id);
        return ResponseEntity.ok("Successfully deleted");
    }

}
