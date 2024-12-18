package org.roleApp.rollApp.loan.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.app_user.entity.AppUser;

@Entity
@Table(name = "loans")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Loan amount is required")
    private Double amount;

    @NotBlank(message = "Interest rate is required")
    private Double interestRate;

    @NotBlank(message = "Loan term is required")
    private Integer term; // in months

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}