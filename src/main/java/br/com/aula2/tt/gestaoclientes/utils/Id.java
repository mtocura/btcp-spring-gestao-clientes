package br.com.aula2.tt.gestaoclientes.utils;

public class Id {
    private static long id = 1l;

    public static long generateID() {
        return id++;
    }
}
