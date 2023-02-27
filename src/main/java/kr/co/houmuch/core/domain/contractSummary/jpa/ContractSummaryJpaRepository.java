package kr.co.houmuch.core.domain.contractSummary.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractSummaryJpaRepository extends JpaRepository<ContractSummaryJpo, Long> {
    @Query("SELECT cs FROM ContractSummaryJpo cs  WHERE cs in (:areaCodeJpoList)")
    List<ContractSummaryJpo> findByAreaCode(List<AreaCodeJpo> areaCodeJpoList);
}
