package tech.basix.edures.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tech.basix.edures.domains.Resource;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends PagingAndSortingRepository<Resource, Long> {
    Optional<Resource> findById(Long id);
    
    @Query("SELECT res FROM Resource res ORDER BY size(res.liked) ASC, res.createdAt DESC")
    List<Resource> getResourcesSortedByLike(Pageable pageable);
}
