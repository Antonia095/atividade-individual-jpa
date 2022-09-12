package br.com.dac.oficina.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "concertos")
public class Concerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorConcerto;

    @ManyToOne
    private Funcionario funcionario;

    private LocalDate dataConcerto;



}
