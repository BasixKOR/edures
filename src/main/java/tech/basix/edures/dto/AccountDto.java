package tech.basix.edures.dto;

import tech.basix.edures.domains.Account;

public class AccountDto {
    String email, password;

    public AccountDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account toEntity() {
        return new Account(email, password);
    }
}
