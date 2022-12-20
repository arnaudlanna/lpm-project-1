package tests;

import app.Appointment;
import app.ApptCalendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ApptCalendarTest {
    static ApptCalendar appt;

    @BeforeAll
    static void initAll() {
        appt = new ApptCalendar();
    }


    @Test
    public void add() {
        Appointment appointment = new Appointment("Test", LocalDate.now());
        appt.addAppointment(appointment);

        List<Appointment> appts = appt.getAppointmentsBetweenDates(LocalDate.MIN, LocalDate.MAX);
        Assertions.assertEquals(1, appts.size());
        Assertions.assertEquals(appts.get(0), appointment);
    }

    @Test
    public void addRepeating() {
        Appointment appointment = new Appointment("Test", LocalDate.now(), 2, 2);
        appt.addAppointment(appointment);

        List<Appointment> appts = appt.getAppointmentsBetweenDates(LocalDate.MIN, LocalDate.MAX);
        Assertions.assertEquals(3, appts.size());
        Assertions.assertEquals(appts.get(1).getDate(), appointment.getDate().plus(2, ChronoUnit.DAYS));
    }
}
