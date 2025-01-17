package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Pagamento registrarPagamento(Pagamento pagamento) {
        // pedido p ID
        Pedido pedido = pedidoRepository.findById(pagamento.getPedido().getId())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        // Validar valor pago
        if (!pedido.getValorTotal().equals(pagamento.getValorPago())) {
            throw new IllegalArgumentException("O valor pago não corresponde ao valor total do pedido");
        }

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        // Confirmar o pedido ( adicionar status ao pedido)
        // pedido.setStatus("PAGO");
        // pedidoRepository.save(pedido);

        return pagamentoSalvo;
    }
}