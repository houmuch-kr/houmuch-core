package kr.co.houmuch.core.domain.code;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaCodeJpaRepository extends JpaRepository<AreaCodeJpo, Long> {
    @Query("SELECT c FROM AreaCodeJpo c INNER JOIN FETCH c.coordinate WHERE c.type = :type")
    List<AreaCodeJpo> findByType2(int type);
    @Query("SELECT c FROM AreaCodeJpo c LEFT OUTER JOIN FETCH c.coordinate")
    List<AreaCodeJpo> findAllFetchJoin();
    Page<AreaCodeJpo> findByType(int type, Pageable pageable);
    Page<AreaCodeJpo> findByCodeSido(int sido, Pageable pageable);
    Page<AreaCodeJpo> findByCodeSidoAndCodeSgg(int sido, int sgg, Pageable pageable);
    Page<AreaCodeJpo> findByCodeSidoAndCodeSggAndCodeUmd(int sido, int sgg, int umd, Pageable pageable);

    /**
     * 광역시/도 타입 지역 목록 조회 (type : 0)
     */
    default Page<AreaCodeJpo> findSido(Pageable pageable) {
        return findByType(0, pageable);
    }

    /**
     * 시/군/구 타입 지역 목록 조회 (type : 1)
     */
    default Page<AreaCodeJpo> findSgg(Pageable pageable) {
        return findByType(1, pageable);
    }

    /**
     * 읍/면/동 타입 지역 목록 조회 (type : 2)
     */
    default Page<AreaCodeJpo> findUmd(Pageable pageable) {
        return findByType(2, pageable);
    }
}
