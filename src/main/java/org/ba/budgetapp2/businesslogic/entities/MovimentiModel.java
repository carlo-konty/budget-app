package org.ba.budgetapp2.businesslogic.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "budget_dba.movimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimentiModel {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movimento_seq")
    @SequenceGenerator(name = "movimento_seq", sequenceName = "movimento_seq", allocationSize = 1)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "conto_o_carta")
    private String contoOrCarta;

    @Column(name = "value")
    private Double value;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date date;

}