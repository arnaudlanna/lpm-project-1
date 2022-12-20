package app;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que guarda e organiza os compromissos
 */
public class ApptCalendar {
    /**
     * Lista de compromissos
     */
    private final List<Appointment> appointments;

    /**
     * Construtor
     */
    public ApptCalendar() {
        this.appointments = new ArrayList<>();
    }

    /**
     * Adiciona um compromisso à lista
     * @param appt Compromisso para adicoinar
     */
    public void addAppointment(Appointment appt) {
        appointments.add(appt);
    }

    /**
     * Retorna todos os compromissos entre a data inicial e a data final
     * @param initialDate Data inicial
     * @param finalDate Data final
     * @return Compromissos filtrados entre as duas datas
     */
    public List<Appointment> getAppointmentsBetweenDates(LocalDate initialDate, LocalDate finalDate) {
        List<Appointment> allAppts = new ArrayList<>();

        // Antes de mais, vamos "repetir" os compromissos
        for (Appointment appt : appointments) {
            allAppts.add(appt);
            for (int i = 0; i < appt.getRepeatTimes(); i++) {
                allAppts.add(new Appointment(appt.getName(), appt.getDate().plus((long) (i + 1) * appt.getRepeatDuration(), ChronoUnit.DAYS)));
            }
        }

        List<Appointment> filtered = new ArrayList<>();

        // Loop em todos os compromissos
        for (Appointment appt : allAppts) {
            // Verificar se está entre a data inicial e final
            if (appt.getDate().isBefore(initialDate) || appt.getDate().isAfter(finalDate)) {
                // Não está - continuar
                continue;
            }

            // Adicionar à lista
            filtered.add(appt);
        }

        return filtered;
    }
}
