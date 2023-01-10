package kr.co.houmuch.core.domain.code;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaCodeJpaRepository extends JpaRepository<AreaCodeJpo, Long> {
    Page<AreaCodeJpo> findByType(int type, Pageable pageable);
    Page<AreaCodeJpo> findByCodeSidoAndCodeSggAndCodeUmd(Integer sido, Integer sgg, Integer umd, Pageable pageable);
    
    default Page<AreaCodeJpo> findBySido(int sido, Pageable pageable) {
        return findByCodeSidoAndCodeSggAndCodeUmd(sido, null, null, pageable);
    }

    default Page<AreaCodeJpo> findBySidoAndSgg(int sido, int sgg, Pageable pageable) {
        return findByCodeSidoAndCodeSggAndCodeUmd(sido, sgg, null, pageable);
    }

    default Page<AreaCodeJpo> findBySidoAndSggAndUmd(int sido, int sgg, int umd, Pageable pageable) {
        return findByCodeSidoAndCodeSggAndCodeUmd(sido, sgg, umd, pageable);
    }

    /**
     * 광역시/도 타입 지역 목록 조회 (type : 0)
     */
    default Page<AreaCodeJpo> findSidoAll(Pageable pageable) {
        return findByType(0, pageable);
    }

    /**
     * 시/군/구 타입 지역 목록 조회 (type : 1)
     */
    default Page<AreaCodeJpo> findSggAll(Pageable pageable) {
        return findByType(1, pageable);
    }

    /**
     * 읍/면/동 타입 지역 목록 조회 (type : 2)
     */
    default Page<AreaCodeJpo> findUmdAll(Pageable pageable) {
        return findByType(2, pageable);
    }
}
