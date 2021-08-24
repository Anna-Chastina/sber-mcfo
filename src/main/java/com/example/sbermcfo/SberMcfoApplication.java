package com.example.sbermcfo;

import com.example.sbermcfo.controller.IfrsTransactionsController;
import com.example.sbermcfo.converter.IfrsTransactionsConverter;
import com.example.sbermcfo.refs.domain.IfrsTableNames;
import com.example.sbermcfo.refs.domain.IfrsTransactions;
import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import com.example.sbermcfo.refs.repo.IfrsTransactionsRepository;
import com.example.sbermcfo.refs.service.IfrsTransactionsService;
import com.example.sbermcfo.refs.service.IfrsTransactionsServiceImp;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import lombok.Builder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class SberMcfoApplication {


	private final static String FILE = "/home/Chadsky/Рабочий стол/Аня полезное/newTransaction.xlsx";
//
	public static void main(String[] args) {

		int checkRow = 0;
		Map<Integer, String> header = new LinkedHashMap<Integer, String>();
		String [] columnNamesArray = {};
		XSSFWorkbook wb;
//				try {
//					wb = new XSSFWorkbook(FILE);
//
//					IfrsTransactionsDto dto = new IfrsTransactionsDto();
//					for (Row row : wb.getSheetAt(0)) {
//						Map<Integer, String> OneCell = new LinkedHashMap<Integer, String>();
//						List<String> oneCellList = new ArrayList<>();
//
//						if (checkRow == 0) {
//							int indexMap = 0;
//							for (Cell cell : row) {
//								columnNamesArray = addElToArray(columnNamesArray, cell.getRichStringCellValue().getString());
//								indexMap++;
//							}
//							checkRow++;
//							continue;
//						} else {
//							int indexMap = 0;
//							for (Cell cell : row) {
//								dto.setId(2);
//								if(columnNamesArray[indexMap].equals("ReportDate")) {
//									dto.setReportDateId(6);
//								} if(columnNamesArray[indexMap].equals("BS_PL_IMPACT")) {
//									dto.setBsPlImpact((int)cell.getNumericCellValue());
//								} if(columnNamesArray[indexMap].equals("Amount")) {
//									dto.setAmount((cell.getNumericCellValue()));
//								} if(columnNamesArray[indexMap].equals("Short_Name")){
//									dto.setShortName(cell.getStringCellValue());
//								} if(columnNamesArray[indexMap].equals("IFRS Account")){
//									dto.setIfrsAccountId((int)(cell.getNumericCellValue()));
//								} if(columnNamesArray[indexMap].equals("RAR Account")){
//									dto.setRarAccount(cell.getNumericCellValue());
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
//								}
//									indexMap++;
//
//							}System.out.println(dto);
//						}
//						System.out.print(Arrays.toString(columnNamesArray) + " " + columnNamesArray.length + " ");
//					}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		SpringApplication.run(SberMcfoApplication.class, args);

	}

//	public static String[] addElToArray(String arr[], String newEl) {
//		String newArr[] = new String[arr.length+1];
//		for (int i = 0; i < arr.length; i++){
//			newArr[i] = arr[i];
//		}
//		newArr[arr.length] = newEl;
//		return newArr;
//	}

}
