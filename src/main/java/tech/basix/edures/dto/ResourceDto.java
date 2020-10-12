package tech.basix.edures.dto;

import tech.basix.edures.domains.Account;
import tech.basix.edures.domains.Resource;

import java.net.URL;
import java.time.LocalDate;

public class ResourceDto {
    private String title;
    private URL url;
    private Account postedBy;
    private LocalDate createdAt;

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

    public Account getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Account postedBy) {
        this.postedBy = postedBy;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Resource toEntity() {
        Resource resource = new Resource(postedBy, createdAt);
        resource.setTitle(title);
        resource.setUrl(url);
        return resource;
    }
}
