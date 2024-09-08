package org.ba.budgetapp2.businesslogic.entities;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "value")
    private Double value;

    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private Date date;
}