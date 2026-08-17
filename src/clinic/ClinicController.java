
package clinic;

import appointments.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import patients.Patient;

public class ClinicController {
    private Clinic clinic;
    private FrmView view;
    private static ClinicController controller;
    
    public static ClinicController getInstance(FrmView view){
    if (controller==null)
        controller=new ClinicController(view);
    return controller;
    }
    
    private ClinicController(FrmView view){
    this.clinic = new Clinic();
    this.view = view;
    }

    public void setView(FrmView view) {
        this.view = view;
    }
    public void addPatient(Patient patient){

    }

    public void findPatient(String id){
        
    }

    public void removePatient(String id){
        
    }

    public Iterator<Patient> getPatients(){    
        return null;
        
    }

    public boolean scheduleAppointment(Appointment appointment){
      boolean status = clinic.scheduleAppointment(appointment);
      if (status){
      view.showMessage("Cita agendada con exito :) ");
      } else {
     view.showError("La cita no se pudo agendar correctamente");
    }
      return status;
    }

    public Appointment findAppointment(String code){
      Appointment appo = clinic.findAppointment(code);
      if (appo==null){
      view.showError("No se ha encontrado una cita agendada :( ");
      view.clear();
      }
     view.showData(appo);
     return appo;
    }
    
    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime){
        boolean status = false;
       if (status){
           view.showMessage("La cita se ha agendado correctamente <3");
       } else {
        view.showError("No se pudo reagendar la cita :( ");
       }
        return status;
    }

    public boolean cancelAppointment(String code){
        return false;
    }

    public Iterator<Appointment> getAppointments(){
        return null;
    }

    public boolean checkInPatient(String patientId){
        return false;
    }

    public Patient getNextPatient(){
        
        return null;
    }

    public Patient attendNextPatient(){
        return null;
    }

    public int getWaitingPatientCount(){
        return 0;
    }

    public boolean isPatientWaiting(String patientId){
        return false;
    }
}
