package com.wolf.services;

import com.wolf.model.Filme;
import com.wolf.model.NotaAluguel;
import com.wolf.utils.DateUtil;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipo) {
        if (filme.getEstoque() == 0) throw new RuntimeException("Filme sem estoque");
        NotaAluguel nota = new NotaAluguel();
        if ("extendido".equals(tipo)) {
            nota.setPreco(filme.getAluguel() * 2);
            nota.setEntrega(DateUtil.obterDataDiferencaDias(3));
            nota.setPontuacao(2);
        } else {
            nota.setPreco(filme.getAluguel());
            nota.setEntrega(DateUtil.obterDataDiferencaDias(1));
            nota.setPontuacao(1);
        }


        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
