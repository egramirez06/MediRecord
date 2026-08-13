/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patients;
import clinic.KeyDynamicsLists;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author maria
 */
public class PatientsList implements KeyDynamicsLists<Patient, String> {
    private HashMap<String, Patient> patients;

    public PatientsList() {
        this.patients = new HashMap();
    }
    @Override
    public Patient get(String id){
        if(!patients.containsKey(id)) return null;
        return patients.get(id);
}
    @Override
    public boolean remove(String id){
      return patients.remove(id)!=null;
    }
    @Override
    public boolean add(Patient item){
    if(patients.containsKey(item.Id())) return false;
    return patients.put(item.getId(), item)==null;
}
    @Override
    public Iterator getAll(){
    if(patients.isEmpty())return null;
    return patients.values().iterator();
}
    @Override
    public int size(){
    return  patients.size();
}
    @Override
    public boolean isEmpty(){
    return  patients.isEmpty();
}
}
  
