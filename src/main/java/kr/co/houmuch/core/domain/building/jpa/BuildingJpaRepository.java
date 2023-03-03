package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import kr.co.houmuch.core.domain.contract.jpa.ContractJpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingJpaRepository extends JpaRepository<BuildingJpo, String> {
    Optional<BuildingJpo> findByNameAndTypeAndAreaCode(String name, BuildingType type, AreaCodeJpo areaCodeJpo);
    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.building cb " +
            "INNER JOIN FETCH c.additional ca " +
            // 나중에 coordinate 데이터 다 넣으면 아래 주석 사용해야 함!
//            "LEFT OUTER JOIN FETCH c.coordinate cc " +
            "INNER JOIN FETCH cb.coordinate bc " +
            "INNER JOIN FETCH cb.areaCode a " +
            "LEFT JOIN FETCH a.coordinate ac " +
            "WHERE (bc.coordinate.latitude >= :minLatitude " +
            "AND bc.coordinate.latitude <= :maxLatitude) " +
            "AND (bc.coordinate.longitude >= :minLongitude " +
            "AND bc.coordinate.longitude <= :maxLongitude) " +
            "AND c.type = 'TRADE'")
    List<ContractJpo> findAllByContract(double maxLatitude, double minLatitude, double maxLongitude, double minLongitude);
}

