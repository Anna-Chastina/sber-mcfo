package com.example.sbermcfo.refs.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("IFRS_transactions")
public class IfrsTransactions {

    @Id
    private Integer id;
    @Column("report_period_id")
    private Integer reportDateId;
    @Column("BS_PL_impact")
    private Integer bsPlImpact;
    @Column("transaction_id")
    private Integer transactionId;
    @Column("Short_Name")
    private String shortName;
    @Column("amount")
    private Double amount;
    @Column("IFRS_account")
    private Integer ifrsAccountId;
    @Column("RAR_account")
    private Double rarAccount;
    @Column("Rar_account3")
    private Double rarAccount3;
    @Column("Rar_account5")
    private Double rarAccount5;
    @Column("SA-cons")
    private String saCons;
    @Column("BS_line")
    private String bsLine;
    @Column("PL_line")
    private String plLine;
    @Column("сategory")
    private String category;
    @Column("сountry")
    private String country;
    @Column("сurrency")
    private String currency;
    @Column("derivative_type")
    private String derivativeType;
    @Column("disclosure")
    private String disclosure;
    @Column("disclosure_aggregate")
    private String disclosureAggregate;
    @Column("group_member")
    private String groupMember;
    @Column("individual_PLI")
    private String individualPli;
    @Column("lease_maturity")
    private String leaseMaturity;
    @Column("loan_class")
    private String loanClass;
    @Column("loan_group")
    private String loanGroup;
    @Column("maturity")
    private String maturity;
    @Column("overdue")
    private String overdue;
    @Column("PPE_class")
    private String ppeClass;
    @Column("FS_PPE_class")
    private String fsPpeClass;
    @Column("rating")
    private String rating;
    @Column("restructured")
    private String restructured;
    @Column("sector")
    private String sector;
    @Column("rep_sector")
    private String repSector;
    @Column("security_type")
    private String securityType;
    @Column("security_type_aggregate")
    private String securityTypeAggregate;
    @Column("segment")
    private String segment;
    @Column("tax_difference")
    private String taxDifference;
    @Column("type")
    private String type;
    @Column("undisc_cf_maturity")
    private String undiscCfMaturity;
    @Column("IFRS_aggregate")
    private String ifrsAaggregate;
    @Column("component")
    private String component;
    @Column("comment")
    private String comment;
    @Column("doer")
    private String doer;
    @Column("FV_level")
    private String fvLevel;
    @Column("BSLineL2")
    private String bsLineL2;
    @Column("related_party")
    private String relatedParty;
    @Column("FV3Lvl")
    private String fv3Lvl;
    @Column("NciLine")
    private String nciLine;
    @Column("derivative")
    private String derivative;
    @Column("cons_group_member")
    private String consGroupMember;
    @Column("tag")
    private String tag;
    @Column("temp_line")
    private String tempLine;
    @Column("cons_layer")
    private String consLayer;
    @Column("cons_layer_aggregate")
    private String consLayerAggregate;
    @Column("segment_reconc_line")
    private String segmentReconcLine;
    @Column("segment_reconc_line_aggregate")
    private String segmentReconcLineAggregate;
    @Column("corresponding_ifrs_account")
    private String correspondingIfrsAccount;
    @Column("related_group_member")
    private String relatedGroupMember;
    @Column("label")
    private String label;
    @Column("sub_gm")
    private String subGm;
    @Column("cons_sub_gm")
    private String consSubGm;
    @Column("related_sub_gm")
    private String relatedSubGm;
    @Column("seg_block")
    private String segBlock;
    @Column("seg_item")
    private String segItem;
    @Column("seg_line")
    private String segLine;
    @Column("report_period2")
    private String reportPeriod2;
    @Column("rng_type")
    private String rngType;
    @Column("rec_layer")
    private String recLayer;
    @Column("pd")
    private String pd;
    @Column("ecl")
    private String ecl;
    @Column("val_tp")
    private String valTp;
    @Column("fvpl_tp")
    private String fvplTp;
    @Column("bank_tp")
    private String bankTp;
    @Column("RAR_account_name")
    private String rarAccountName;
    @Column("RAR_account_and_name")
    private String rarAccountAndName;
    @Column("pl_rep")
    private String plRep;
    @Column("pl_rep_ordered")
    private String plRepOrdered;
    @Column("bs_rep")
    private String bsRep;
    @Column("bs_rep_ordered")
    private String bsRepOrdered;
    @Column("seg_ln")
    private String segLn;
    @Column("import_date_time")
    private String importDateTime;
    @Column("uploader")
    private String uploader;
}
