package com.timberbase.sawmill.repository;

import com.timberbase.sawmill.model.SawmillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SawmillRepository extends JpaRepository<SawmillModel, Long> {
    @Query(value = "select s from SawmillModel s  where UPPER(s.name) like CONCAT('%', UPPER(:name), '%')")
    List<SawmillModel> findAllByName(@Param("name") String name);
}
