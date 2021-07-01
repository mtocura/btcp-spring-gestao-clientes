package br.com.aula2.tt.gestaoclientes.utils;

public class Id {
    private static long idCliente = 1l;
    private static long idProduto = 1l;
    private static long idPedido = 1l;

    public static long generateIDCliente() {
        return idCliente++;
    }

    public static long generateIDProduto() {
        return idProduto++;
    }

    public static long generateIDPedido() {
        return idPedido++;
    }
}
