package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildingJpaRepository extends JpaRepository<BuildingJpo, String> {
    Optional<BuildingJpo> findByNameAndTypeAndAreaCode(String name, BuildingType type, AreaCodeJpo areaCodeJpo);
}

