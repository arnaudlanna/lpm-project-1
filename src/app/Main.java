package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


/**
 * Classe principal do programa
 */
public class Main {
    /**
     * Agenda de compromissos
     */
    private static ApptCalendar apptCalendar;

    /**
     * Scanner que lê o input do usuário
     */
    private static Scanner scanner;

    /**
     * Método principal
     *
     * @param args Argumentos de console (não utilizados)
     */
    public static void main(String[] args) {
        apptCalendar = new ApptCalendar();
        scanner = new Scanner(System.in);

        menu();
    }

    /**
     * Classe principal do menu
     */
    private static void menu() {
        while (true) {
            System.out.println();
            System.out.println("       Agenda de Compromissos");
            System.out.println();
            System.out.println("   Ações:");
            System.out.println("1) Cadastrar compromisso único");
            System.out.println("2) Cadastrar compromisso periódico");
            System.out.println("3) Ver relatório de compromissos entre datas");
            System.out.println("0) Sair");
            System.out.println();
            System.out.print("Escolha a sua ação: ");

            // Lê a ação e repete até ser válido
            Optional<Integer> action = Utilities.parseInt(scanner.next());

            if (action.isEmpty()) {
                System.out.println("Ação inválida - é necessário ser um número inteiro. Tente novamente.");
                System.out.println();
                continue;
            }

            // Número inteiro, executar ações
            System.out.println();

            switch (action.get()) {
                case 0:
                    return;
                case 1:
                    scheduleOneTimeAppointment();
                    break;
                case 2:
                    schedulePeriodicAppointment();
                    break;
                case 3:
                    generateAppointmentReport();
                    break;
                default:
                    System.out.println("Não existe nenhuma ação com esse número. Tente novamente.");
                    break;
            }
        }
    }

    /**
     * Gerar um relatório de compromissos entre uma data inicial e final
     */
    private static void generateAppointmentReport() {
        System.out.println("Data inicial?");
        LocalDate initialDate = Utilities.readDate(scanner);

        System.out.println("Data final?");
        LocalDate finalDate = Utilities.readDate(scanner);

        List<Appointment> filtered = apptCalendar.getAppointmentsBetweenDates(initialDate, finalDate);

        for (Appointment appt : filtered) {
            System.out.println(" - " + appt.getName() + ": " + appt.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
    }

    /**
     * Cadastra um compromisso periódico
     */
    private static void schedulePeriodicAppointment() {
        System.out.println("Qual o nome do compromisso?");
        String name = scanner.next();

        System.out.println("Insira a data do compromisso. (Formato: DD-MM-YYYY)");
        LocalDate date = Utilities.readDate(scanner);

        System.out.println("Repetir de quantos em quantos dias?");
        int repeatDays = Utilities.readInt(scanner);

        System.out.println("Repetir quantas vezes?");
        int repeatCount = Utilities.readInt(scanner);

        apptCalendar.addAppointment(new Appointment(name, date, repeatCount, repeatDays));

        System.out.println("Criado com sucesso.");
        System.out.println("Nome: " + name);
        System.out.println("Data: " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Repetir a cada " + repeatDays + " dias por " + repeatCount + " vezes");
    }


    /**
     * Cadastra um compromisso em uma data específica
     */
    private static void scheduleOneTimeAppointment() {
        System.out.println("Qual o nome do compromisso?");
        String name = scanner.next();
        System.out.println("Insira a data do compromisso. (Formato: DD-MM-YYYY)");
        LocalDate date = Utilities.readDate(scanner);

        apptCalendar.addAppointment(new Appointment(name, date));

        System.out.println("Criado com sucesso.");
        System.out.println("Nome: " + name);
        System.out.println("Data: " + date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}