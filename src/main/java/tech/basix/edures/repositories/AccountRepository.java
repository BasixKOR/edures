package tech.basix.edures.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import tech.basix.edures.domains.Account;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
}
