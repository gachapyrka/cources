package com.example.cources.models;

import com.example.cources.models.enums.TopicType;
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
@Table(name = "step")
public class Step {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Topic> topics;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private List<OwnedStep> ownedSteps;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id")
    private Lesson owner;
}
