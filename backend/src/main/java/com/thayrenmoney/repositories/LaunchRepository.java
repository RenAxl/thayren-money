package com.thayrenmoney.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thayrenmoney.entities.Launch;

@Repository
public interface LaunchRepository extends JpaRepository<Launch, Long>{

}
