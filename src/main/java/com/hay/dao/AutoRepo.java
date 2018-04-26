package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Auto;

public interface AutoRepo extends JpaRepository<Auto, Long> {

}
