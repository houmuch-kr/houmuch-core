package kr.co.houmuch.core.domain.hospital.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalJpaRepository extends JpaRepository<HospitalJpo, String> {
    @Query("SELECT h FROM HospitalJpo h " +
            "WHERE (h.latitude >= :minLatitude " +
            "AND h.latitude <= :maxLatitude) " +
            "AND (h.longitude >= :minLongitude " +
            "AND h.longitude <= :maxLongitude)")
    List<HospitalJpo> findByCoordinate(double maxLatitude, double minLatitude, double maxLongitude, double minLongitude);
}
