package kr.co.houmuch.core.domain.store.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCoordinateJpaRepository extends JpaRepository<StoreCoordinateJpo, String> {
}
