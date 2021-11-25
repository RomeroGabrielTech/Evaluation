package com.bci.peopledata.dao;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bci.peopledata.entitys.Peoples;

public interface PeoplesDAO extends JpaRepository<Peoples, Integer> {

	Optional<Peoples> findById(UUID id);

}
