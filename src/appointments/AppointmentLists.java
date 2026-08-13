/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appointments;


import clinic.KeyDynamicsLists;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author Stef
 */
public class AppointmentLists implements KeyDynamicsLists<Appointment,String>{
    TreeSet<Appointment> appointments;
    
    public AppointmentLists(){
        this.appointments = new TreeSet();
    }
 

    @Override
    public Appointment get(String code) {
        for(Appointment appo: appointments){
            if(appo.getCode().equals(code))return appo;
        }
        return null;
         
    }

    @Override
    public boolean remove(String id) {
        Appointment appo= this.get(id);
        if(appo==null)return false;
        return appointments.remove(appo);
    }

    @Override
    public boolean add(Appointment item) {
         return appointments.add(item);
         
    }

    @Override
    public Iterator getAll() {
        if(appointments.isEmpty()) return null;
        return appointments.iterator();
    }

    @Override
    public int size() {
        return appointments.size(); 
    }

    @Override
    public boolean isEmpty() {
       return appointments.isEmpty();
    }
    
   
    
}
