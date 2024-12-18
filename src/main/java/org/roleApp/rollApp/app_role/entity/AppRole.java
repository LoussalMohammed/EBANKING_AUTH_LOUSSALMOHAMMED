package org.roleApp.rollApp.app_role.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.app_permission.entity.AppPermission;
import org.roleApp.rollApp.app_user.entity.AppUser;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "AppRole")
@Table(name = "app_roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "role name is required")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<AppPermission> permissions = new HashSet<>();

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<AppUser> users;
}
