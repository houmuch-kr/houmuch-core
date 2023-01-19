package kr.co.houmuch.core.domain.contract.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractJpaRepository extends JpaRepository<ContractJpo, String> {
}
