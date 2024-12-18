package org.roleApp.rollApp.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.app_user.entity.AppUser;
import org.roleApp.rollApp.balance.entity.Balance;

@Entity(name = "Account")
@Table(name = "accounts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @NotBlank(message = "Account type is required")
    private String accountType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BALANCE_ID", referencedColumnName = "id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Balance balance;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AppUser user;
}