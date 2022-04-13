package com.anz.career.wholesale.anzuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ANZUserRepository extends JpaRepository<ANZUser, Long> {

}
