package com.example.sbermcfo.refs.repo;

import com.example.sbermcfo.refs.domain.IfrsTransactions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IfrsTransactionsRepository extends PagingAndSortingRepository<IfrsTransactions, Integer> {

}
