package app;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

/**
 * Métodos utilitários para a aplicação
 */
public class Utilities {
    /**
     * Lê uma string e retorna um Optional de inteiro
     * @param x String original
     * @return Inteiro opcional
     */
    public static Optional<Integer> parseInt(String x) {
        try {
            return Optional.of(Integer.parseInt(x));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    /**
     * Lê um número inteiro pelo scanner até ser válido
     * @param sc Scanner
     * @return Número inteiro
     */
    public static int readInt(Scanner sc) {
        while (true) {
            Optional<Integer> opt = Utilities.parseInt(sc.next());
            if (opt.isEmpty()) {
                System.out.println("Número inválido - introduza um número inteiro");
            } else {
                return opt.get();
            }
        }
    }

    /**
     * Lê uma data pelo scanner até ser válido
     * @param sc Scanner
     * @return Data
     */
    public static LocalDate readDate(Scanner sc) {
        while (true) {
            String line = sc.next();
            String[] split = line.split("-");

            try {
                return LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
            } catch (Exception ex) {
                System.out.println("Data inválida. Insira a data novamente.");
            }
        }
    }
}
