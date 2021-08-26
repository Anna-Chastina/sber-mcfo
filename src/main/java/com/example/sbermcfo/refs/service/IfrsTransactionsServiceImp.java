package com.example.sbermcfo.refs.service;

import com.example.sbermcfo.converter.IfrsTransactionsConverter;
import com.example.sbermcfo.refs.domain.IfrsTransactions;
import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import com.example.sbermcfo.refs.repo.IfrsTransactionsRepository;
import liquibase.pro.packaged.I;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IfrsTransactionsServiceImp implements IfrsTransactionsService {

    private IfrsTransactionsRepository ifrsTransactionsRepository;

    @Autowired
    public IfrsTransactionsServiceImp(IfrsTransactionsRepository ifrsTransactionsRepository) {
        this.ifrsTransactionsRepository = ifrsTransactionsRepository;
    }

    @Override
    public Page<IfrsTransactionsDto> getAll(Pageable page) {
        return ifrsTransactionsRepository.findAll(page).map(IfrsTransactionsConverter::convertToDto);
    }

    @Override
    public List<IfrsTransactionsDto> getAll() {
        Iterable<IfrsTransactions> all = ifrsTransactionsRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .map(IfrsTransactionsConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public IfrsTransactionsDto getById(Integer id) {
        return IfrsTransactionsConverter.convertToDto(ifrsTransactionsRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void deleteById(Integer id) {
        ifrsTransactionsRepository.deleteById(id);
    }

    @Override
    public IfrsTransactionsDto create(IfrsTransactionsDto dto) {
        return IfrsTransactionsConverter.convertToDto(ifrsTransactionsRepository.save(IfrsTransactionsConverter.convertToEntity(dto)));
    }

    @Override
    public List<IfrsTransactionsDto> createAll(List<IfrsTransactionsDto> dtos) {

        List<IfrsTransactionsDto> dtos2 = new ArrayList<>();
        for (IfrsTransactionsDto dto:dtos){
        dtos2.add( IfrsTransactionsConverter.convertToDto(ifrsTransactionsRepository.save(IfrsTransactionsConverter.convertToEntity(dto))));}
        return dtos2;
    }


//    IfrsTransactionsDto dto = new IfrsTransactionsDto();
//    List<String> list = new ArrayList<>();
//
//    int checkRow = 0;
//    String [] columnNamesArray = {};
//        try {
//        wb = new XSSFWorkbook(FILE);
//        for (Row row : wb.getSheetAt(0)) {
//            if (checkRow == 0) {
//                int indexMap = 0;
//                for (Cell cell : row) {
//                    columnNamesArray = addElToArray(columnNamesArray, cell.getRichStringCellValue().getString());
//                    indexMap++;
//                }
//                checkRow++;
//                continue;
//            } else {
//                int indexMap = 0;
//                for (Cell cell : row) {
//                    if(columnNamesArray[indexMap].equals("ReportDate")) {
//                        //dto = IfrsTransactionsDto.builder().reportDateId(7).build();
//                        dto.setReportDateId(6);
//                    } if(columnNamesArray[indexMap].equals("BS_PL_IMPACT")) {
//                        dto.setBsPlImpact((int)(cell.getNumericCellValue()));
//                    } if(columnNamesArray[indexMap].equals("Amount")) {
//                        dto.setAmount(cell.getNumericCellValue());
//                    } if(columnNamesArray[indexMap].equals("Short_Name")){
//                        dto.setShortName(cell.getStringCellValue());
////                        } if(columnNamesArray[indexMap].equals("IFRS Account")){
////                            dto.setIfrsAccountId((int)(cell.getNumericCellValue()));
////                        } if(columnNamesArray[indexMap].equals("RAR Account")){
////                            dto.setRarAccount(cell.getNumericCellValue());
////								} if(columnNamesArray[indexMap].equals("Rar_Acc3")){
////									dto.setRarAccount3(cell.getNumericCellValue());
////								} if(columnNamesArray[indexMap].equals("Rar_Acc5")){
////									dto.setRarAccount5(cell.getNumericCellValue());
////								} if(columnNamesArray[indexMap].equals("SA-Cons")){
////									dto.setSaCons(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("BS Line")){
////									dto.setBsLine(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("PL Line")){
////									dto.setPlLine(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Category")){
////									dto.setCategory(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Country")){
////									dto.setCountry(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Currency")){
////									dto.setCurrency(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Derivative_type")){
////									dto.setDerivativeType(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Disclosure")){
////									dto.setDisclosure(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("DisclosureAggr")){
////									dto.setDisclosureAggregate(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Group_Member")){
////									dto.setGroupMember(cell.getStringCellValue());
////								} if(columnNamesArray[indexMap].equals("Individual_PLI")) {
////									dto.setIndividualPli(cell.getStringCellValue());
//                    }
//                    indexMap++;
//
//                }System.out.println(dto);
//
//            }
//            System.out.print(Arrays.toString(columnNamesArray) + " " + columnNamesArray.length + " ");
//
//        }
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//
//    IfrsTransactionsDto dtoMain = IfrsTransactionsDto.builder()
//            .reportDateId(dto.getReportDateId())
//            .shortName(dto.getShortName())
//            .amount(dto.getAmount())
//            .build();
//        try {
//        return ResponseEntity.ok(ifrsTransactionsService.create(dtoMain));
//    }catch (Exception e) {
//        e.printStackTrace();
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//}
//
//    public static String[] addElToArray(String arr[], String newEl) {
//        String newArr[] = new String[arr.length+1];
//        for (int i = 0; i < arr.length; i++){
//            newArr[i] = arr[i];
//        }
//        newArr[arr.length] = newEl;
//        return newArr;
//    }





    @Override
    public IfrsTransactionsDto update(IfrsTransactionsDto dto) {
        Optional<IfrsTransactions> byId = ifrsTransactionsRepository.findById(dto.getId());
        if (byId.isPresent()) {
            IfrsTransactions transaction = byId.get();
            transaction.setId(dto.getId());
            transaction.setBsPlImpact(dto.getBsPlImpact());
            transaction.setTransactionId(dto.getTransactionId());
            transaction.setShortName(dto.getShortName());
            transaction.setAmount(dto.getAmount());
            transaction.setIfrsAccountId(dto.getIfrsAccountId());
            transaction.setRarAccount(dto.getRarAccount());
            transaction.setRarAccount3(dto.getRarAccount3());
            transaction.setRarAccount5(dto.getRarAccount5());
            transaction.setSaCons(dto.getSaCons());
            transaction.setBsLine(dto.getBsLine());
            transaction.setPlLine(dto.getPlLine());
            transaction.setCategory(dto.getCategory());
            transaction.setCountry(dto.getCountry());
            transaction.setCurrency(dto.getCurrency());
            transaction.setDerivativeType(dto.getDerivativeType());
            transaction.setDisclosure(dto.getDisclosure());
            transaction.setDisclosureAggregate(dto.getDisclosureAggregate());
            transaction.setGroupMember(dto.getGroupMember());
            transaction.setIndividualPli(dto.getIndividualPli());
            transaction.setLeaseMaturity(dto.getLeaseMaturity());
            transaction.setLoanClass(dto.getLoanClass());
            transaction.setLoanGroup(dto.getLoanGroup());
            transaction.setMaturity(dto.getMaturity());
            transaction.setOverdue(dto.getOverdue());
            transaction.setPpeClass(dto.getPpeClass());
            transaction.setFsPpeClass(dto.getFsPpeClass());
            transaction.setRating(dto.getRating());
            transaction.setRestructured(dto.getRestructured());
            transaction.setSector(dto.getSector());
            transaction.setRepSector(dto.getRepSector());
            transaction.setSecurityType(dto.getSecurityType());
            transaction.setSecurityTypeAggregate(dto.getSecurityTypeAggregate());
            transaction.setSegment(dto.getSegment());
            transaction.setTaxDifference(dto.getTaxDifference());
            transaction.setType(dto.getType());
//            transaction.setUndiscCfMaturity(dto.getUndiscCfMaturity());
//            transaction.setIfrsAaggregate(dto.getIfrsAaggregate());
//            transaction.setComponent(dto.getComponent());
//            transaction.setComment(dto.getComment());
//            transaction.setDoer(dto.getDoer());
//            transaction.setFvLevel(dto.getFvLevel());
//            transaction.setBsLineL2(dto.getBsLineL2());
//            transaction.setRelatedParty(dto.getRelatedParty());
//            transaction.setFv3Lvl(dto.getFv3Lvl());
//            transaction.setNciLine(dto.getNciLine());
//            transaction.setDerivative(dto.getDerivative());
//            transaction.setConsGroupMember(dto.getConsGroupMember());
//            transaction.setTag(dto.getTag());
//            transaction.setTempLine(dto.getTempLine());
//            transaction.setConsLayer(dto.getConsLayer());
//            transaction.setConsLayerAggregate(dto.getConsLayerAggregate());
//            transaction.setSegmentReconcLine(dto.getSegmentReconcLine());
//            transaction.setSegmentReconcLineAggregate(dto.getSegmentReconcLineAggregate());
//            transaction.setCorrespondingIfrsAccount(dto.getCorrespondingIfrsAccount());
//            transaction.setRelatedGroupMember(dto.getRelatedGroupMember());
//            transaction.setLabel(dto.getLabel());
//            transaction.setSubGm(dto.getSubGm());
//            transaction.setConsSubGm(dto.getConsSubGm());
//            transaction.setRelatedSubGm(dto.getRelatedSubGm());
//            transaction.setSegBlock(dto.getSegBlock());
//            transaction.setSegItem(dto.getSegItem());
//            transaction.setSegLine(dto.getSegLine());
//            transaction.setRngType(dto.getRngType());
//            transaction.setRecLayer(dto.getRecLayer());
//            transaction.setPd(dto.getPd());
//            transaction.setEcl(dto.getEcl());
//            transaction.setValTp(dto.getValTp());
//            transaction.setFvplTp(dto.getFvplTp());
//            transaction.setBankTp(dto.getBankTp());
//            transaction.setRarAccountName(dto.getRarAccountName());
//            transaction.setRarAccountAndName(dto.getRarAccountAndName());
//            transaction.setPlRep(dto.getPlRep());
//            transaction.setPlRepOrdered(dto.getPlRepOrdered());
//            transaction.setBsRep(dto.getBsRep());
//            transaction.setBsRepOrdered(dto.getBsRepOrdered());
//            transaction.setSegLn(dto.getSegLn());
//            transaction.setImportDateTime(dto.getImportDateTime());
//            transaction.setUploader(dto.getUploader());
            return IfrsTransactionsConverter.convertToDto(ifrsTransactionsRepository.save(transaction));
        } else {
            return null;
        }
    }
}
