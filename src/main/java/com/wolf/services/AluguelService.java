package com.wolf.services;

import com.wolf.model.Filme;
import com.wolf.model.NotaAluguel;
import com.wolf.utils.DateUtil;

public class AluguelService {

    public NotaAluguel alugar(Filme filme) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");
        NotaAluguel nota = new NotaAluguel();
        nota.setPreco(filme.getAluguel());
        nota.setEntrega(DateUtil.obterDataDiferencaDias(1));
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
