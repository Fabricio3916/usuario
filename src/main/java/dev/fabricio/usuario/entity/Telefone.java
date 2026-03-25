package dev.fabricio.usuario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "telefone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String ddd;

}
