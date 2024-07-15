package com.green.glampick.repository;


import com.green.glampick.entity.GlampingEntity;
import com.green.glampick.entity.ReviewEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GlampingStarRepository extends JpaRepository<ReviewEntity, Long> {

    @Modifying
    @Query(
            value =
                    "UPDATE glamping " +
                    "SET star_point_avg = ( " +
                    "SELECT TRUNCATE(AVG(review_star_point),1) " +
                    "FROM review " +
                    "WHERE glamp_id = :glampId) " +
                    ", review_count = (SELECT COUNT(review_content) " +
                    "FROM review " +
                    "WHERE glamp_id = :glampId) " +
                    "WHERE user_id = :userId " +
                    "AND glamp_id = :glampId ",
            nativeQuery = true)
    void findStarPointAvg(long reservationId);
}
