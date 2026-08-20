package patients;
import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import medicalrecords.MedicalRecord;
import medicalrecords.medicalrecordslist;
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
        
    }
    
    public MedicalRecord getLatestMedicalRecord(){
        return null;
    }
    
    public MedicalRecord removeLatestMedicalRecord(){
        return null;
    }
    
    public Iterator<MedicalRecord> getMedicalHistory() {
        return null;
    }
    
    public boolean hasMedicalHistory(){
        return false;
    }

    Object Id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}