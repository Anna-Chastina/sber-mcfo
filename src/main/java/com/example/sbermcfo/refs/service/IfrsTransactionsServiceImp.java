package com.example.sbermcfo.refs.service;

import com.example.sbermcfo.converter.IfrsTransactionsConverter;
import com.example.sbermcfo.refs.domain.IfrsTransactions;
import com.example.sbermcfo.refs.dto.IfrsTransactionsDto;
import com.example.sbermcfo.refs.repo.IfrsTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public IfrsTransactionsDto update(IfrsTransactionsDto dto) {
        Optional<IfrsTransactions> byId = ifrsTransactionsRepository.findById(dto.getId());
        if (byId.isPresent()) {
            IfrsTransactions transaction = byId.get();
            transaction.setId(dto.getId());
            transaction.setBsPlImpact(dto.getBsPlImpact());
            transaction.setTransactionId(dto.getTransactionId());
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
            transaction.setUndiscCfMaturity(dto.getUndiscCfMaturity());
            transaction.setIfrsAaggregate(dto.getIfrsAaggregate());
            transaction.setComponent(dto.getComponent());
            transaction.setComment(dto.getComment());
            transaction.setDoer(dto.getDoer());
            transaction.setFvLevel(dto.getFvLevel());
            transaction.setBsLineL2(dto.getBsLineL2());
            transaction.setRelatedParty(dto.getRelatedParty());
            transaction.setFv3Lvl(dto.getFv3Lvl());
            transaction.setNciLine(dto.getNciLine());
            transaction.setDerivative(dto.getDerivative());
            transaction.setConsGroupMember(dto.getConsGroupMember());
            transaction.setTag(dto.getTag());
            transaction.setTempLine(dto.getTempLine());
            transaction.setConsLayer(dto.getConsLayer());
            transaction.setConsLayerAggregate(dto.getConsLayerAggregate());
            transaction.setSegmentReconcLine(dto.getSegmentReconcLine());
            transaction.setSegmentReconcLineAggregate(dto.getSegmentReconcLineAggregate());
            transaction.setCorrespondingIfrsAccount(dto.getCorrespondingIfrsAccount());
            transaction.setRelatedGroupMember(dto.getRelatedGroupMember());
            transaction.setLabel(dto.getLabel());
            transaction.setSubGm(dto.getSubGm());
            transaction.setConsSubGm(dto.getConsSubGm());
            transaction.setRelatedSubGm(dto.getRelatedSubGm());
            transaction.setSegBlock(dto.getSegBlock());
            transaction.setSegItem(dto.getSegItem());
            transaction.setSegLine(dto.getSegLine());
            transaction.setReportPeriod2(dto.getReportPeriod2());
            transaction.setRngType(dto.getRngType());
            transaction.setRecLayer(dto.getRecLayer());
            transaction.setPd(dto.getPd());
            transaction.setEcl(dto.getEcl());
            transaction.setValTp(dto.getValTp());
            transaction.setFvplTp(dto.getFvplTp());
            transaction.setBankTp(dto.getBankTp());
            transaction.setRarAccountName(dto.getRarAccountName());
            transaction.setRarAccountAndName(dto.getRarAccountAndName());
            transaction.setPlRep(dto.getPlRep());
            transaction.setPlRepOrdered(dto.getPlRepOrdered());
            transaction.setBsRep(dto.getBsRep());
            transaction.setBsRepOrdered(dto.getBsRepOrdered());
            transaction.setSegLn(dto.getSegLn());
            transaction.setImportDateTime(dto.getImportDateTime());
            transaction.setUploader(dto.getUploader());
            return IfrsTransactionsConverter.convertToDto(ifrsTransactionsRepository.save(transaction));
        } else {
            return null;
        }
    }
}
