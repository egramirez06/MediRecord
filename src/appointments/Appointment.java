
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;

import java.time.LocalDate;
import java.time.LocalTime;
import patients.Patient;

/**
 *
 * @author jprod
 */
public class Appointment {
    //implememtar Comparable<Appointment>
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
    
    public void reschedule(LocalDate newDate, LocalTime newTime){
        
    }

    public void cancel(){
        
    }

    public boolean isPending(){
        return false;
    }

    public boolean isToday(){
        return false;
    }

    //public int compareTo(Appointment other); date → time → code

}
