package com.example.homework.repository;

import com.example.homework.model.Statictics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StatisticsRepo extends JpaRepository<Statictics, Integer> {
    Optional<Statictics> findByCountryNameAndUser_id(String countryName, int userId);

    Optional<Statictics> findFirstByUser_Id(int id);

    @Query(value = "select country_name from statictics s where s.user_id=?", nativeQuery = true)
    List<String> findAllCountryNames(int userId);

    List<Statictics> findAllByUser_Id(int userId);
}
