package kz.adilet.tleubay.code.generator.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "codes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
