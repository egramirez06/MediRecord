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
     return patients.add(patient);
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
        return appointments.add(appointment);
    }

    public Appointment findAppointment(String code) {
        if(appointments.isEmpty() )return null;
        return appointments.get(code);
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime) {
          Appointment Cita= appointments.get(code);
          if(Cita!=null){
          Cita.reschedule(newDate,newTime);
          return true;
          }
          return false;
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
    if (isPatientWaiting(patientId)) {
        return false;
    }
    return waitingRoom.add(patient);
        
    }

    public Patient getNextPatient() {
        return waitingRoom.get();

    }

    public Patient attendNextPatient() {
        Patient patient = waitingRoom.get();
        waitingRoom.remove();
        return patient;
    }

    public int getWaitingPatientCount() {
        return waitingRoom.size();

    }

    public boolean isPatientWaiting(String patientId) {
        Iterator<Patient>i = waitingRoom.getAll();
        while(i.hasNext()) {
            Patient p= i.next();
            if(p.getId().equals(patientId)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
