package com.bci.peopledata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bci.peopledata.entitys.Peoples;

public interface PeoplesDAO extends JpaRepository<Peoples, Long> {

}
