package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.model.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}