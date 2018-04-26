package com.hay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hay.entities.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {

}
