package com.example.cources.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cource")
public class Cource {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String description;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "cource", cascade = CascadeType.ALL)
    private List<ChatMessage> messages;

    @OneToMany(mappedBy = "cource", cascade = CascadeType.ALL)
    private List<CourceComment> comments;

    @OneToMany(mappedBy = "cource", cascade = CascadeType.ALL)
    private List<OwnedCource> ownedCources;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private Account owner;
}
