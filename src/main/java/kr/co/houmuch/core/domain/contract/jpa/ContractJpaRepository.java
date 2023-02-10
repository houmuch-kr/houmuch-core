package kr.co.houmuch.core.domain.contract.jpa;

import kr.co.houmuch.core.domain.building.jpa.BuildingJpo;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractJpaRepository extends JpaRepository<ContractJpo, String> {
    @Query("SELECT c FROM ContractJpo c " +
                    "INNER JOIN FETCH c.additional ca " +
                    "INNER JOIN FETCH c.detail cd " +
                    "INNER JOIN FETCH c.building b " +
                    "INNER JOIN FETCH b.areaCode a " +
                    "LEFT OUTER JOIN FETCH b.coordinate bc " +
                    "WHERE a.code.sido IN (:sidoLists)")
    List<ContractJpo> findByBuildingAreaCode(List<Integer> sidoLists);
    Page<ContractJpo> findByBuildingAreaCode(AreaCodeJpo areaCodeJpo, Pageable pageable);
    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.building cb " +
            "INNER JOIN FETCH cb.areaCode " +
            "WHERE cb.areaCode = :areaCodeJpo")
    List<ContractJpo> findByAreaCode(AreaCodeJpo areaCodeJpo);

    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.building cb " +
            "INNER JOIN FETCH cb.areaCode " +
            "WHERE c.building = :buildingJpo")
    List<ContractJpo> findByBuilding(BuildingJpo buildingJpo);
}
