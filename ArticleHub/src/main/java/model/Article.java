/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andesson
 */

@Entity
@Table(name = "articles")
@Data
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    
    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NotBlank
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "publication_date")
    private LocalDate publicationDate;
}
