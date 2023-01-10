package kr.co.houmuch.core.repository;

import kr.co.houmuch.core.domain.code.AreaCodeJpaRepository;
import kr.co.houmuch.core.domain.code.AreaCodeJpo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1100000000L).type(0).build());
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1111000000L).type(1).build());
        areaCodeJpaRepository.save(AreaCodeJpo.builder().id(1111010100L).type(2).build());
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
        Page<AreaCodeJpo> areaCodeJpo = areaCodeJpaRepository.findByType(type, Pageable.unpaged());
        assertFalse(areaCodeJpo.getContent().isEmpty());
    }
}
