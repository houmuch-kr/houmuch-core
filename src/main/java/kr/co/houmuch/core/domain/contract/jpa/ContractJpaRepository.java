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
    List<ContractJpo> findByBuildingAreaCodeSido(List<Integer> sidoLists);

    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.additional ca " +
            "INNER JOIN FETCH c.detail cd " +
            "INNER JOIN FETCH c.building b " +
            "INNER JOIN FETCH b.areaCode a " +
            "LEFT OUTER JOIN FETCH b.coordinate bc " +
            "WHERE a.code.sgg IN (:sggLists)")
    List<ContractJpo> findByBuildingAreaCodeSgg(List<Integer> sggLists);

    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.additional ca " +
            "INNER JOIN FETCH c.detail cd " +
            "INNER JOIN FETCH c.building b " +
            "INNER JOIN FETCH b.areaCode a " +
            "LEFT OUTER JOIN FETCH b.coordinate bc " +
            "WHERE a.code.umd IN (:umdLists)")
    List<ContractJpo> findByBuildingAreaCodeUmd(List<Integer> umdLists);
    Page<ContractJpo> findByBuildingAreaCode(AreaCodeJpo areaCodeJpo, Pageable pageable);
    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.detail cd " +
            "INNER JOIN FETCH c.additional ca " +
            "INNER JOIN FETCH c.building b " +
            "INNER JOIN FETCH b.coordinate " +
            "INNER JOIN FETCH b.areaCode a " +
            "INNER JOIN FETCH a.coordinate " +
            "WHERE (:sido = 0 OR a.code.sido = :sido) " +
			"AND (:sgg = 0 OR a.code.sgg = :sgg) " +
			"AND (:umd = 0 OR a.code.umd = :umd) " +
            "ORDER BY c.contractedAt DESC")
    List<ContractJpo> findByAreaCode(int sido, int sgg, int umd, Pageable pageable);

    @Query("SELECT c FROM ContractJpo c " +
            "INNER JOIN FETCH c.building cb " +
            "INNER JOIN FETCH cb.areaCode " +
            "WHERE c.building = :buildingJpo " +
            "ORDER BY c.contractedAt DESC")
    List<ContractJpo> findByBuilding(BuildingJpo buildingJpo, Pageable pageable);
}
