package com.backbase.kalah.persistence.repository;

import com.backbase.kalah.persistence.model.Pit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitRepository extends JpaRepository<Pit, Long> {
    Pit findByPitId(Long pitId);
}
