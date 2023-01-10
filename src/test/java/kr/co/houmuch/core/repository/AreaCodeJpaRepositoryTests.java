package kr.co.houmuch.core.repository;

import kr.co.houmuch.core.domain.code.AreaCodeJpaRepository;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import kr.co.houmuch.core.domain.common.jpa.CombinedAreaCodeJpo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@DisplayName("AreaCodeJpaRepository")
public class AreaCodeJpaRepositoryTests {
    @Autowired
    private AreaCodeJpaRepository areaCodeJpaRepository;

    @BeforeEach
    void before() {
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1100000000L)
                .code(CombinedAreaCodeJpo.builder().sido(11).build()).type(0).build());
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1111000000L)
                .code(CombinedAreaCodeJpo.builder().sido(11).sgg(110).build()).type(1).build());
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1111010100L)
                .code(CombinedAreaCodeJpo.builder().sido(11).sgg(110).umd(10100).build()).type(2).build());
    }

    @ParameterizedTest
    @DisplayName("findById(id)")
    @ValueSource(longs = 1100000000)
    void findById(long id) {
        AreaCodeJpo areaCodeJpo = areaCodeJpaRepository.findById(id)
                .orElseThrow();
        assertNotNull(areaCodeJpo);
    }

    @ParameterizedTest
    @DisplayName("findByType(type, pageable)")
    @ValueSource(ints = 0)
    void findByType(int type) {
        Page<AreaCodeJpo> page = areaCodeJpaRepository.findByType(type, Pageable.unpaged());
        assertFalse(page.getContent().isEmpty());
    }

    @ParameterizedTest
    @DisplayName("findByCodeSido(sido)")
    @CsvSource({"11"})
    void findBySido(Integer sido) {
        Page<AreaCodeJpo> page = areaCodeJpaRepository
                .findByCodeSido(sido, Pageable.unpaged());
        assertFalse(page.getContent().isEmpty());
    }

    @ParameterizedTest
    @DisplayName("findByCodeSidoAndCodeSgg(sido, sgg)")
    @CsvSource({"11,110"})
    void findBySidoAndSgg(Integer sido, Integer sgg) {
        Page<AreaCodeJpo> page = areaCodeJpaRepository
                .findByCodeSidoAndCodeSgg(sido, sgg, Pageable.unpaged());
        assertFalse(page.getContent().isEmpty());
    }

    @ParameterizedTest
    @DisplayName("findByCodeSidoAndCodeSggAndCodeUmd(sido, sgg, umd)")
    @CsvSource({"11,110,10100"})
    void findBySidoAndSggAndUmd(Integer sido, Integer sgg, Integer umd) {
        Page<AreaCodeJpo> page = areaCodeJpaRepository
                .findByCodeSidoAndCodeSggAndCodeUmd(sido, sgg, umd, Pageable.unpaged());
        assertFalse(page.getContent().isEmpty());
    }
}
