package kr.co.houmuch.core.domain.store.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StoreJpaRepository extends JpaRepository<StoreJpo, String> {
    //@Query("INSERT INTO StoreJpo() ")
//    @Modifying
//            //(clearAutomatically = true)
//    @Transactional
//    void saveStore();

}
