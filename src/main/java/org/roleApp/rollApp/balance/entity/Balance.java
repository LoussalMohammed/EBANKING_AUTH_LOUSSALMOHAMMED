package org.roleApp.rollApp.balance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.roleApp.rollApp.account.entity.Account;

@Entity(name = "Balance")
@Table(name = "balances")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @OneToOne(mappedBy = "balance")
    private Account account;
}