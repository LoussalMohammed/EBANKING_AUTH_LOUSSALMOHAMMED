package org.roleApp.rollApp.app_user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.account.entity.Account;
import org.roleApp.rollApp.app_role.entity.AppRole;
import org.roleApp.rollApp.card.entity.Card;
import org.roleApp.rollApp.contact.entity.Contact;
import org.roleApp.rollApp.loan.entity.Loan;
import org.roleApp.rollApp.notification.entity.Notification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity(name = "AppUser")
@Table(name = "app_users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "permission name is required")
    private String name;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "phone is required")
    private String phone;

    @NotBlank(message = "password is required")
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    AppRole role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Account> accounts = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Notification> notifications = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CARD_ID", referencedColumnName = "id")
    private Card card;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "id")
    private Contact contact;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
