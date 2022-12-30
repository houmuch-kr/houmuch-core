package kr.co.houmuch.core.domain.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractJpaRepository extends JpaRepository<ContractJpo, Long> {
}
