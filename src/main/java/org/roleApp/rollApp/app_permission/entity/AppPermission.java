package org.roleApp.rollApp.app_permission.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.app_role.entity.AppRole;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "AppPermission")
@Table(name = "app_permissions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AppPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "permission name is required")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "PERMISSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Set<AppRole> roles = new HashSet<>();
    
}
