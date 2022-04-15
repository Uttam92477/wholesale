package com.anz.career.wholesale.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
  <T> Page<T> findByUserId(String userId, Pageable pageable, Class<T> type);
}
