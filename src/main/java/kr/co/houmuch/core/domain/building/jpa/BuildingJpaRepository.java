package kr.co.houmuch.core.domain.building.jpa;

import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.contract.BuildingType;
import kr.co.houmuch.core.domain.contract.jpa.ContractJpo;
import org.springframework.data.domain.Pageable;
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
            "INNER JOIN FETCH cb.coordinate bc " +
            "INNER JOIN FETCH c.detail cd " +
            "INNER JOIN FETCH cb.areaCode a " +
            "LEFT JOIN FETCH a.coordinate ac " +
            "WHERE (bc.coordinate.latitude >= :minLatitude " +
            "AND bc.coordinate.latitude <= :maxLatitude) " +
            "AND (bc.coordinate.longitude >= :minLongitude " +
            "AND bc.coordinate.longitude <= :maxLongitude) " +
            "AND c.type = 'TRADE'")
    List<ContractJpo> findAllByContract(double maxLatitude, double minLatitude, double maxLongitude, double minLongitude);
    @Query("SELECT b FROM BuildingJpo b " +
            "INNER JOIN FETCH b.coordinate bc " +
            "WHERE b.name like %:searchWord%")
    List<BuildingJpo> findByName(String searchWord, Pageable pageable);

    @Query("SELECT b FROM BuildingJpo b " +
            "INNER JOIN FETCH b.areaCode ba " +
            "LEFT OUTER JOIN FETCH ba.coordinate " +
            "LEFT OUTER JOIN FETCH b.coordinate")
    List<BuildingJpo> findAllFetchJoin();
}

