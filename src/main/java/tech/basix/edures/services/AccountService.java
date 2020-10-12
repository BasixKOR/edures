package tech.basix.edures.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.basix.edures.dto.AccountDto;
import tech.basix.edures.repositories.AccountRepository;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public Long join(AccountDto accountDto) {
        var passwordEncoder = new BCryptPasswordEncoder();
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        return accountRepository.save(accountDto.toEntity()).getId();
    }
}
