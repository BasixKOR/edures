package tech.basix.edures.domains;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private URL url;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Account> liked;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Account postedBy;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    protected Resource() {}

    public Resource(Account postedBy, LocalDate createdAt) {
        this.postedBy = postedBy;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Set<Account> getLiked() {
        return liked;
    }

    public void setLiked(Set<Account> liked) {
        this.liked = liked;
    }

    public void addLiked(Account account) {
        this.liked.add(account);
    }

    public void removeLiked(Account account) {
        this.liked.remove(account);
    }

    public Account getPostedBy() {
        return postedBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
