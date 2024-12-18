package org.roleApp.rollApp.card.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.roleApp.rollApp.app_user.entity.AppUser;

@Entity
@Table(name = "cards")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Card number is required")
    private String cardNumber;

    @NotBlank(message = "Card type is required")
    private String cardType;

    @OneToOne(mappedBy = "card")
    private AppUser user;
}