package com.wolf.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NotaAluguel {

    private double preco;
    private Date entrega;
    private int pontuacao;
}
