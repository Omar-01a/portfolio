package com.omar.portfolio.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String category;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "live_url")
    private String liveUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany
@JoinTable(
        name = "project_technologies",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
)
private Set<Technology> technologies = new HashSet<>();

    public Project() {
    }

    public Project(String title, String description, String category,
                   String githubUrl, String liveUrl, String imageUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.githubUrl = githubUrl;
        this.liveUrl = liveUrl;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLiveUrl() {
        return liveUrl;
    }

    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Set<Technology> getTechnologies() {
    return technologies;
}

public void setTechnologies(Set<Technology> technologies) {
    this.technologies = technologies;
}
}