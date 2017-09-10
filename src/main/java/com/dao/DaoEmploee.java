package com.dao;

import com.model.Emploee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DaoEmploee extends CrudRepository<Emploee, Integer> {
    public Emploee findByName(String name);

    @Query(value = "select * from Emploee order by name desc", nativeQuery = true)
    public List<Emploee> findDesc();
}
