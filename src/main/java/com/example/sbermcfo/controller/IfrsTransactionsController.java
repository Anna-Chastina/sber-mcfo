package com.example.sbermcfo.controller;

import com.example.sbermcfo.converter.IfrsTransactionsConverter;
import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import com.example.sbermcfo.refs.service.IfrsTransactionsService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

//@RequestMapping("/")
@Controller
public class IfrsTransactionsController {
    private IfrsTransactionsService ifrsTransactionsService;

    @Autowired
    public IfrsTransactionsController(IfrsTransactionsService ifrsTransactionsService) {
        this.ifrsTransactionsService = ifrsTransactionsService;
    }

    int checkRow = 0;
    String [] columnNamesArray = {};
    private final static String FILE = "/home/Chadsky/Рабочий стол/Аня полезное/newTransaction.xlsx";
    XSSFWorkbook wb;

//    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<IfrsTransactionsDto> getById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(ifrsTransactionsService.getById(id));
//    }

    @RequestMapping("/put")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createFromEcxel(String filePath){
        IfrsTransactionsDto dto = new IfrsTransactionsDto();
        int checkRow = 0;
        String [] columnNamesArray = {};
        try {
            wb = new XSSFWorkbook(FILE);
            for (Row row : wb.getSheetAt(0)) {
                if (checkRow == 0) {
                    int indexMap = 0;
                    for (Cell cell : row) {
                        columnNamesArray = addElToArray(columnNamesArray, cell.getRichStringCellValue().getString());
                        indexMap++;
                    }
                    checkRow++;
                    continue;
                } else {
                    int indexMap = 0;
                    for (Cell cell : row) {
                        dto.setId(2);
                        if(columnNamesArray[indexMap].equals("ReportDate")) {
                            dto.setReportDateId(6);
                        } if(columnNamesArray[indexMap].equals("BS_PL_IMPACT")) {
                            dto.setBsPlImpact((int)cell.getNumericCellValue());
                        } if(columnNamesArray[indexMap].equals("Amount")) {
                            dto.setAmount((cell.getNumericCellValue()));
                        } if(columnNamesArray[indexMap].equals("Short_Name")){
                            dto.setShortName(cell.getStringCellValue());
                        } if(columnNamesArray[indexMap].equals("IFRS Account")){
                            dto.setIfrsAccountId((int)(cell.getNumericCellValue()));
                        } if(columnNamesArray[indexMap].equals("RAR Account")){
                            dto.setRarAccount(cell.getNumericCellValue());
//								} if(columnNamesArray[indexMap].equals("Rar_Acc3")){
//									dto.setRarAccount3(cell.getNumericCellValue());
//								} if(columnNamesArray[indexMap].equals("Rar_Acc5")){
//									dto.setRarAccount5(cell.getNumericCellValue());
//								} if(columnNamesArray[indexMap].equals("SA-Cons")){
//									dto.setSaCons(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("BS Line")){
//									dto.setBsLine(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("PL Line")){
//									dto.setPlLine(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Category")){
//									dto.setCategory(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Country")){
//									dto.setCountry(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Currency")){
//									dto.setCurrency(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Derivative_type")){
//									dto.setDerivativeType(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Disclosure")){
//									dto.setDisclosure(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("DisclosureAggr")){
//									dto.setDisclosureAggregate(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Group_Member")){
//									dto.setGroupMember(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("Individual_PLI")) {
//									dto.setIndividualPli(cell.getStringCellValue());
                        }
                        indexMap++;

                    }System.out.println(dto);
                }
                System.out.print(Arrays.toString(columnNamesArray) + " " + columnNamesArray.length + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return ResponseEntity.ok(ifrsTransactionsService.create(dto));
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public static String[] addElToArray(String arr[], String newEl) {
        String newArr[] = new String[arr.length+1];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        newArr[arr.length] = newEl;
        return newArr;
    }


//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity getAll(){
//        return ResponseEntity.ok(ifrsTransactionsService.getAll());
//    }


//    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<IfrsTransactionsDto> getById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(ifrsTransactionsService.getById(id));
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Page<IfrsTransactionsDto>> getAll(
//            @RequestParam(value="size") int size,
//            @RequestParam(value="page", defaultValue = "0") int page
//    ) {
//        Pageable paging = PageRequest.of(page, size);
//        return ResponseEntity.ok(ifrsTransactionsService.getAll(paging));
//    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<IfrsTransactionsDto> create(@RequestBody IfrsTransactionsDto dto) {
//        try {
//            return ResponseEntity.ok(ifrsTransactionsService.create(dto));
//        }catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<IfrsTransactionsDto> update(@RequestBody IfrsTransactionsDto dto) {
//        try{
//            return ResponseEntity.ok(ifrsTransactionsService.update(dto));
//        }catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
//        ifrsTransactionsService.deleteById(id);
//        return ResponseEntity.ok("Successfully deleted");
//    }

}
