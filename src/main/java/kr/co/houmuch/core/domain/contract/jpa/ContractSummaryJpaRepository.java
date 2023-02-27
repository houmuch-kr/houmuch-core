package kr.co.houmuch.core.domain.contract.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractSummaryJpaRepository extends JpaRepository<ContractSummaryJpo, Long> {
    @Query("SELECT cs FROM ContractSummaryJpo cs " +
            "INNER JOIN FETCH cs.areaCode " +
            "WHERE cs.id in (:areaCodeList)")
    List<ContractSummaryJpo> findByAreaCode(List<Long> areaCodeList);
}
