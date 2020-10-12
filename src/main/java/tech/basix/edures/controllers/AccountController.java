package tech.basix.edures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.basix.edures.dto.AccountDto;
import tech.basix.edures.services.AccountService;

@Controller
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/signup")
    public String signupView() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(AccountDto accountDto) {
        accountService.join(accountDto);
        return "redirect:/login";
    }
}
