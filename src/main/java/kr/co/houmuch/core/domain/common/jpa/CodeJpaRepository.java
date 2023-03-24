package kr.co.houmuch.core.domain.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeJpaRepository extends JpaRepository<CodeJpo, String> {
}
