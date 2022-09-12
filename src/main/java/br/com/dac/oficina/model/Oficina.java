package br.com.dac.oficina.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "oficinas")
public class Oficina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String bairro;

    private String cidade;

    private BigDecimal saldoOficina;

    private List<Funcionario> funcionarios;
}
