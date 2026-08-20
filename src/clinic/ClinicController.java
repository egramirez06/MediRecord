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
        if (controller == null){
            controller = new ClinicController(view);
        } else {
            controller.setView(view);
        }
        return controller;
    }

    private ClinicController(FrmView view){
        this.clinic = new Clinic();
        this.view = view;
    }

    public void setView(FrmView view) {
        this.view = view;
    }

    public boolean addPatient(Patient patient){
        boolean status = clinic.addPatient(patient);
        if (status){
            view.showMessage("Paciente registrado con éxito");
            view.clear();
        } else {
            view.showError("No se pudo registrar el paciente (¿identificación duplicada?)");
        }
        return status;
    }

    public Patient findPatient(String id){
        Patient patient = clinic.findPatient(id);
        if (patient == null){
            view.showError("No se ha encontrado un paciente con esa identificación :( ");
            view.clear();
        } else {
            view.showData(patient);
        }
        return patient;
    }

    public boolean removePatient(String id){
        boolean status = clinic.removePatient(id);
        if (status){
            view.showMessage("Paciente eliminado correctamente");
            view.clear();
        } else {
            view.showError("No se pudo eliminar: paciente no encontrado");
        }
        return status;
    }

    public Iterator<Patient> getPatients(){
        return clinic.getPatients();
    }



    public boolean scheduleAppointment(Appointment appointment){
        boolean status = clinic.scheduleAppointment(appointment);
        if (status){
            view.showMessage("Cita agendada con exito :) ");
            view.clear();
        } else {
            view.showError("La cita no se pudo agendar correctamente");
        }
        return status;
    }

    public Appointment findAppointment(String code){
        Appointment appo = clinic.findAppointment(code);
        if (appo == null){
            view.showError("No se ha encontrado una cita agendada :( ");
            view.clear();
        } else {
            view.showData(appo);
        }
        return appo;
    }

    public boolean rescheduleAppointment(String code, LocalDate newDate, LocalTime newTime){
        boolean status = clinic.rescheduleAppointment(code, newDate, newTime);
        if (status){
            view.showMessage("La cita se ha reagendado correctamente <3");
        } else {
            view.showError("No se pudo reagendar la cita :( ");
        }
        return status;
    }

    public boolean cancelAppointment(String code){
        boolean status = clinic.cancelAppointment(code);
        if (status){
            view.showMessage("Cita cancelada correctamente");
            view.clear();
        } else {
            view.showError("No se pudo cancelar: cita no encontrada");
        }
        return status;
    }

    public Iterator<Appointment> getAppointments(){
        return clinic.getAppointments();
    }



    public boolean checkInPatient(String patientId){
        boolean status = clinic.checkInPatient(patientId);
        if (status){
            view.showMessage("Paciente registrado en la sala de espera");
        } else {
            view.showError("No se pudo registrar en sala de espera (ID inválido o ya está esperando)");
        }
        return status;
    }

    public Patient getNextPatient(){
        Patient patient = clinic.getNextPatient();
        if (patient == null){
            view.showError("No hay pacientes en la sala de espera");
        }
        return patient;
    }

    public Patient attendNextPatient(){
        Patient patient = clinic.attendNextPatient();
        if (patient != null){
            view.showMessage("Atendiendo a: " + patient.getFullName());
        } else {
            view.showError("No hay pacientes en la sala de espera");
        }
        return patient;
    }

    public int getWaitingPatientCount(){
        return clinic.getWaitingPatientCount();
    }

    public boolean isPatientWaiting(String patientId){
        return clinic.isPatientWaiting(patientId);
    }
}