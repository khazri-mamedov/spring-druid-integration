package com.iwconnect;

import com.iwconnect.entity.LineSummary;
import com.iwconnect.entity.Wikipedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WikipediaRepository extends JpaRepository<Wikipedia, LocalDateTime> {

    /**
     * Find lines summary (added, deleted) by hour in time interval
     */
    @Query(
            value = "SELECT FLOOR(__time to HOUR) timeHour, SUM(deleted) linesAdded, SUM(deleted) linesDeleted " +
                    "FROM wikipedia " +
                    "WHERE __time BETWEEN :startInterval AND :endInterval " +
                    "GROUP BY 1",
            nativeQuery = true
    )
    List<LineSummary> findLineSummariesByHour(LocalDate startInterval, LocalDate endInterval);

    /**
     * Finds all wikipedia entities by country name and applying limits
     */
    @Query(
            value = "SELECT * " +
                    "FROM wikipedia " +
                    "WHERE countryName = :countryName " +
                    "LIMIT :limit",
            nativeQuery = true
    )
    List<Wikipedia> findByCountryName(String countryName, Integer limit);

    /**
     * Finds all wikipedia entities with channel like (JPQL)
     */
    @Query("SELECT wk FROM wikipedia wk WHERE wk.channel = :channel ORDER BY wk.time")
    List<Wikipedia> findAllByChannel(String channel);

    List<Wikipedia> findByCityName(String cityName);
}
