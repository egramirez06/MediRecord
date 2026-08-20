/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import medicalrecords.MedicalRecord;
import medicalrecords.medicalrecordslist;

/**
 *
 * @author jprod
 */
public class Patient {
    private String id;
    private String fullName;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private medicalrecordslist medicalHistory;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public int getAge() {
        return calculateAge();
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Patient(String id, String fullName, LocalDate birthDate, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
       this.medicalHistory = new medicalrecordslist();
    }
    
    private int calculateAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    
    public void addMedicalRecord(MedicalRecord record){
    medicalHistory.add(record);
    }
    
    public MedicalRecord getLatestMedicalRecord(){
 return medicalHistory.get();
}
  public MedicalRecord removeLatestMedicalRecord(){
    MedicalRecord record = medicalHistory.get();
    if (record != null) {
        medicalHistory.remove();
    }
    return record;
}
    
    public Iterator<MedicalRecord> getMedicalHistory() {
        return medicalHistory.getAll();
    }
    
    public boolean hasMedicalHistory(){
         return !medicalHistory.isEmpty();
}

    Object Id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}