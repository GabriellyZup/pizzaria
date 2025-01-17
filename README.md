# pizzaria

## Diagrama UML

+------------------------+
|       Pagamento        |
+------------------------+
| - id: Long             |
| - pedido: Pedido       |
| - formaPagamento:      |
|   FormaPagamento       |
| - valorPago: Double    |
| - dataHoraPagamento    |
|   : LocalDateTime      |
+------------------------+
| + registrarPagamento() |
+------------------------+
            |
            v
+-------------------------+
|       Pedido            |
+-------------------------+
| - id: Long              |
| - descricao: String     |
| - cliente: Cliente      |
| - valorTotal: Double    |
| - status: String        |
+-------------------------+
| + getValorTotal()       |
+-------------------------+
            |
            v
+--------------------------+
| Cliente                  |
+--------------------------+
| - id: Long               |
| - nome: String           |
| - email: String          |
+--------------------------+
| + getNome()              |
+--------------------------+