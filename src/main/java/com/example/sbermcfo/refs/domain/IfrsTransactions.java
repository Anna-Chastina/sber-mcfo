package com.example.sbermcfo.refs.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("IFRS_TRANSACTIONS")
public class IfrsTransactions {

    @Id
    private Integer id;
    @Column("REPORT_PERIOD_ID")
    private Integer reportDateId;
    @Column("BS_PL_IMPACT")
    private Integer bsPlImpact;
    @Column("TRANSACTION_ID")
    private Integer transactionId;
    @Column("SHORT_NAME")
    private String shortName;
    @Column("AMOUNT")
    private Double amount;
    @Column("IFRS_ACCOUNT_ID")
    private Integer ifrsAccountId;
    @Column("RAR_ACCOUNT")
    private Double rarAccount;
    @Column("RAR_ACCOUNT3")
    private Double rarAccount3;
    @Column("RAR_ACCOUNT5")
    private Double rarAccount5;
    @Column("SA-CONS")
    private String saCons;
    @Column("BS_LINE")
    private String bsLine;
    @Column("PL_LINE")
    private String plLine;
    @Column("CATEGORY")
    private String category;
    @Column("COUNTRY")
    private String country;
    @Column("CURRENCY")
    private String currency;
    @Column("DERIVATIVE_TYPE")
    private String derivativeType;
    @Column("DISCLOSURE")
    private String disclosure;
    @Column("DISCLOSURE_AGGREGATE")
    private String disclosureAggregate;
    @Column("GROUP_MEMBER")
    private String groupMember;
    @Column("INDIVIDUAL_PLI")
    private String individualPli;
    @Column("LEASE_MATURITY")
    private String leaseMaturity;
    @Column("LOAN_CLASS")
    private String loanClass;
    @Column("LOAN_GROUP")
    private String loanGroup;
    @Column("MATURITY")
    private String maturity;
    @Column("OVERDUE")
    private String overdue;
    @Column("PPE_CLASS")
    private String ppeClass;
    @Column("FS_PPE_CLASS")
    private String fsPpeClass;
    @Column("RATING")
    private String rating;
    @Column("RESTRUCTURED")
    private String restructured;
    @Column("SELECTOR")
    private String sector;
    @Column("REP_SELECTOR")
    private String repSector;
    @Column("SECURITY_TYPE")
    private String securityType;
    @Column("SECURITY_TYPE_AGGREGATE")
    private String securityTypeAggregate;
    @Column("SEGMENT")
    private String segment;
    @Column("TAX_DIFFERENCE")
    private String taxDifference;
    @Column("TYPE")
    private String type;
//    @Column("UNDISC_CF_MATURITY")
//    private String undiscCfMaturity;
//    @Column("IFRS_AGGREGATE")
//    private String ifrsAaggregate;
//    @Column("COMPONENT")
//    private String component;
//    @Column("COMMENT")
//    private String comment;
//    @Column("DOER")
//    private String doer;
//    @Column("FV_LEVEL")
//    private String fvLevel;
//    @Column("BS_LINE_L2")
//    private String bsLineL2;
//    @Column("RELATED_PARTY")
//    private String relatedParty;
//    @Column("FV3LVL")
//    private String fv3Lvl;
//    @Column("NCI_LINE")
//    private String nciLine;
//    @Column("DERIVATIVE")
//    private String derivative;
//    @Column("CONS_GROUP_MEMBER")
//    private String consGroupMember;
//    @Column("TAG")
//    private String tag;
//    @Column("TEMP_LINE")
//    private String tempLine;
//    @Column("CONS_LAYER")
//    private String consLayer;
//    @Column("CONS_LAYER_AGGREGATE")
//    private String consLayerAggregate;
//    @Column("SEGMENT_RECONC_LINE")
//    private String segmentReconcLine;
//    @Column("SEGMENT_RECONC_LINE_AGGREGATE")
//    private String segmentReconcLineAggregate;
//    @Column("CORRESPONDING_IFRS_ACCOUNT")
//    private String correspondingIfrsAccount;
//    @Column("RELATED_GROUP_MEMBER")
//    private String relatedGroupMember;
//    @Column("LABEL")
//    private String label;
//    @Column("SUB_GM")
//    private String subGm;
//    @Column("CONS_SUB_GM")
//    private String consSubGm;
//    @Column("RELATED_SUB_GM")
//    private String relatedSubGm;
//    @Column("SEG_BLOCK")
//    private String segBlock;
//    @Column("SEG_ITEM")
//    private String segItem;
//    @Column("SEG_LINE")
//    private String segLine;
//    @Column("RNG_TYPE")
//    private String rngType;
//    @Column("REC_LAYER")
//    private String recLayer;
//    @Column("PD")
//    private String pd;
//    @Column("ECT")
//    private String ecl;
//    @Column("VAL_TP")
//    private String valTp;
//    @Column("FVPL_TP")
//    private String fvplTp;
//    @Column("BANK_TP")
//    private String bankTp;
//    @Column("RAR_ACCOUNT_NAME")
//    private String rarAccountName;
//    @Column("RAR_ACCOUNT_AND_NAME")
//    private String rarAccountAndName;
//    @Column("PL_REP")
//    private String plRep;
//    @Column("PL_REP_ORDERED")
//    private String plRepOrdered;
//    @Column("BS_REP")
//    private String bsRep;
//    @Column("BS_REP_ORDERED")
//    private String bsRepOrdered;
//    @Column("SEG_LN")
//    private String segLn;
//    @Column("IMPORT_DATE_TIME")
//    private String importDateTime;
//    @Column("UPLOADER")
//    private String uploader;
}
