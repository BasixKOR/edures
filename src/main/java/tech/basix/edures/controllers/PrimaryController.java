package tech.basix.edures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.basix.edures.domains.Account;
import tech.basix.edures.dto.ResourceDto;
import tech.basix.edures.services.ResourceService;

import java.time.LocalDate;

@Controller
public class PrimaryController {
    private final ResourceService resourceService;

    @Autowired
    public PrimaryController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/")
    public String home(Model model) {
        var page = resourceService.getPage(0);
        model.addAttribute("page", page);
        return "home";
    }

    @PostMapping("/post")
    public String post(@AuthenticationPrincipal Account account, ResourceDto resource) {
        if(resource.getTitle().isEmpty() || resource.getUrl() == null) throw new IllegalArgumentException();
        resource.setPostedBy(account);
        resource.setCreatedAt(LocalDate.now());

        resourceService.postResource(resource);
        return "redirect:/";
    }

    @GetMapping("/post")
    public String postView() {
        return "post";
    }

    @GetMapping("/like")
    public String like(@AuthenticationPrincipal Account account, @RequestParam Long id) {
        resourceService.like(id, account);
        return "redirect:/";
    }
}
