package com.firstPractice.springJpaPostgres.repository;

import com.firstPractice.springJpaPostgres.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
