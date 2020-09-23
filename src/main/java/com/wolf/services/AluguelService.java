package com.wolf.services;

import com.wolf.model.Filme;
import com.wolf.model.NotaAluguel;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme){
        NotaAluguel nota  = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,1);
        nota.setEntrega(calendar.getTime());
        filme.setEstoque(filme.getEstoque()-1);
        return nota;
    }
}
