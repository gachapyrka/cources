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
@Table(name = "topic")
public class Topic {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TopicType type;
    @NotNull
    @NotBlank
    @Builder.Default
    private String content = "---No content---";

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<OwnedTopic> ownedTopics;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "step_id")
    private Step owner;
}
