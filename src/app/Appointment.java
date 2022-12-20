package app;

import java.time.LocalDate;

/**
 * Objeto que representa um compromisso
 */
public class Appointment {
    /**
     * Nome do compromisso
     */
    private final String name;

    /**
     * Data do compromisso
     */
    private final LocalDate date;

    /**
     * Vezes para repetir o compromisso
     */
    private int repeatTimes;

    /**
     * Quantos dias para repetir o compromisso
     */
    private int repeatDuration;

    /**
     * Construtor simples
     * @param name Nome do compromisso
     * @param date Data do compromisso
     */
    public Appointment(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    /**
     * Construtor
     * @param name Nome do compromisso
     * @param date Data do compromisso
     * @param repeatTimes Vezes para repetir
     * @param repeatDuration Dias para repetir
     */
    public Appointment(String name, LocalDate date, int repeatTimes, int repeatDuration) {
        this.name = name;
        this.date = date;
        this.repeatTimes = repeatTimes;
        this.repeatDuration = repeatDuration;
    }

    /**
     * Nome do compromisso
     * @return Nome do compromisso
     */
    public String getName() {
        return name;
    }

    /**
     * Data do compromisso
     * @return Data do compromisso
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Vezes para repetir o compromisso
     * @return Vezes para repetir o compromisso
     */
    public int getRepeatTimes() {
        return repeatTimes;
    }

    /**
     * Quantos dias para repetir o compromisso
     * @return Quantos dias para repetir o compromisso
     */
    public int getRepeatDuration() {
        return repeatDuration;
    }
}
