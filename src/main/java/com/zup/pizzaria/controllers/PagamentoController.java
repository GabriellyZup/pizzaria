package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.services.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<Pagamento> registrarPagamento(@RequestBody Pagamento pagamento) {
        try {
            Pagamento pagamentoRegistrado = pagamentoService.registrarPagamento(pagamento);
            return ResponseEntity.ok(pagamentoRegistrado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}