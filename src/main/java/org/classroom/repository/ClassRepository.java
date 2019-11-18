package org.classroom.repository;


import org.classroom.domain.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<Classes, Long> {
}
