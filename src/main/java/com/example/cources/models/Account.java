package com.example.cources.models;

import com.example.cources.models.enums.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Логин не может быть пустым")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
    @NotBlank(message = "ФИО не может быть пустым")
    private String credentials;
    @Builder.Default()
    private boolean isActive = true;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cource> cources;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GetRoleRequest> requests;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OwnedCource> ownedCources;
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ChatMessage> chatMessages;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CourceComment> comments;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Set<Role> roles = new HashSet<>(Arrays.asList(Role.USER));
}
