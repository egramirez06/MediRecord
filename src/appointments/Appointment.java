package appointments;
import java.time.LocalDate;
import java.time.LocalTime;
import patients.Patient;
public class Appointment implements Comparable<Appointment> {
    private String code;
    private Patient patient;
    private LocalDate date;
    private LocalTime time;
    private String reason;
    private AppointmentStatus status;

    public String getCode() {
        return code;
    }
    public Patient getPatient() {
        return patient;
    }
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public String getReason() {
        return reason;
    }
    public AppointmentStatus getStatus() {
        return status;
    }

    public Appointment(String code, Patient patient, LocalDate date, LocalTime time, String reason) {
        this.code = code;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void reschedule(LocalDate newDate, LocalTime newTime) {
        this.date = newDate;
        this.time = newTime;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public boolean isPending() {
        return status == AppointmentStatus.SCHEDULED;
    }

    public boolean isToday() {
        return date.equals(LocalDate.now());
    }

    @Override
    public int compareTo(Appointment other) {
        int comp = this.date.compareTo(other.date);
        if (comp == 0) {
            comp = this.time.compareTo(other.time);
        }
        if (comp == 0) {
            comp = this.code.compareTo(other.code);
        }
        return comp;
    }
}