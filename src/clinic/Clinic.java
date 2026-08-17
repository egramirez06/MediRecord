/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinic;
import WaitingRoom.WaitingRoomList;
import appointments.Appointment;
import appointments.AppointmentList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.PatientsList;
import patients.Patient;

/**
 *
 * @author Stef
 */
public class Clinic {
    private PatientsList patients;
    private AppointmentList appointments;
    private WaitingRoomList waitingRoom;
    
    public Clinic(){
        this.patients = new PatientsList();
        this.appointments = new AppointmentList();
        this.waitingRoom = new WaitingRoomList();    
    }
    public boolean addPatient(Patient patient) {
      if (patient != null) {
        return patients.add(patient);
    } else {
        return false;
    }
    }

    public Patient findPatient(String id) {
        return patients.get(id);
    }

    public boolean removePatient(String id) {
        return patients.remove(id);
    }

    public Iterator<Patient> getPatients() {
        return patients.getAll();
    }

    public boolean scheduleAppointment(Appointment appointment) {
        if(appointment == null){
        return false;
        }
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        return appointments.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
        Appointment appointment = appointments.get(code);
    if (appointment == null) {
        return false;
    }
    appointment.setDate(newDate);
    appointment.setTime(newTime);
    return true; 
    }

    public boolean cancelAppointment(String code) {
        return appointments.remove(code);

    }

    public Iterator<Appointment> getAppointments() {
        return appointments.getAll();

    }

    public boolean checkInPatient(String patientId) {
       Patient patient = patients.get(patientId);
    if (patient == null) {
        return false;
    }
    return waitingRoom.enqueue(patient);
    }

    public Patient getNextPatient() {
        return waitingRoom.peek();

    }

    public Patient attendNextPatient() {
        return waitingRoom.dequeue();

    }

    public int getWaitingPatientCount() {
        return waitingRoom.size();

    }

    public boolean isPatientWaiting(String patientId) {
        return waitingRoom.contains(patientId);
    }
    
    
    
}
