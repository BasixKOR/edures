package tech.basix.edures.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.basix.edures.domains.Account;
import tech.basix.edures.domains.Resource;
import tech.basix.edures.dto.ResourceDto;
import tech.basix.edures.repositories.ResourceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final ResourceRepository repository;

    @Autowired
    public ResourceService(ResourceRepository repository) {
        this.repository = repository;
    }

    public Long postResource(ResourceDto resource) {
        if(resource.getTitle().isEmpty() || resource.getUrl() == null || resource.getPostedBy() == null)
            throw new IllegalArgumentException("Illegal resource.");

        return repository.save(resource.toEntity()).getId();
    }

    public void like(Long id, Account account) {
        Optional<Resource> optionalResource = repository.findById(id);
        if(optionalResource.isEmpty()) return;

        Resource resource = optionalResource.get();

        if(resource.getLiked().contains(account)) resource.removeLiked(account);
        else resource.addLiked(account);

        repository.save(resource);
    }

    public List<Resource> getPage(int page) {
        return repository.getResourcesSortedByLike(PageRequest.of(page, 20));
    }
}
