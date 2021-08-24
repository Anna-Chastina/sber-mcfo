package com.example.sbermcfo.refs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IfrsTransactionsDto {
    private Integer id;
    private Integer reportDateId;
    private Integer bsPlImpact;
    private Integer transactionId;
    private String shortName;
    private Double amount;
    private Integer ifrsAccountId;
    private Double rarAccount;
    private Double rarAccount3;
    private Double rarAccount5;
    private String saCons;
    private String bsLine;
    private String plLine;
    private String category;
    private String country;
    private String currency;
    private String derivativeType;
    private String disclosure;
    private String disclosureAggregate;
    private String groupMember;
    private String individualPli;
    private String leaseMaturity;
    private String loanClass;
    private String loanGroup;
    private String maturity;
    private String overdue;
    private String ppeClass;
    private String fsPpeClass;
    private String rating;
    private String restructured;
    private String sector;
    private String repSector;
    private String securityType;
    private String securityTypeAggregate;
    private String segment;
    private String taxDifference;
    private String type;
    private String undiscCfMaturity;
    private String ifrsAaggregate;
    private String component;
    private String comment;
    private String doer;
    private String fvLevel;
    private String bsLineL2;
    private String relatedParty;
    private String fv3Lvl;
    private String nciLine;
    private String derivative;
    private String consGroupMember;
    private String tag;
    private String tempLine;
    private String consLayer;
    private String consLayerAggregate;
    private String segmentReconcLine;
    private String segmentReconcLineAggregate;
    private String correspondingIfrsAccount;
    private String relatedGroupMember;
    private String label;
    private String subGm;
    private String consSubGm;
    private String relatedSubGm;
    private String segBlock;
    private String segItem;
    private String segLine;
    private String reportPeriod2;
    private String rngType;
    private String recLayer;
    private String pd;
    private String ecl;
    private String valTp;
    private String fvplTp;
    private String bankTp;
    private String rarAccountName;
    private String rarAccountAndName;
    private String plRep;
    private String plRepOrdered;
    private String bsRep;
    private String bsRepOrdered;
    private String segLn;
    private String importDateTime;
    private String uploader;
}
