package com.dao;

import com.model.Emploee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DaoEmploee extends CrudRepository<Emploee, Integer> {
}
