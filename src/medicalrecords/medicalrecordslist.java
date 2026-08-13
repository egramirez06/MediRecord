package medicalrecords;

import clinic.SequentialDynamicsLists;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author norki
 */
public class medicalrecordslist implements SequentialDynamicsLists<MedicalRecord> {
    private Stack<MedicalRecord> medicalHistory;

    public medicalrecordslist() {
        this.medicalHistory = new Stack<>();
    }

    @Override
    public MedicalRecord get() {
        try {
            return medicalHistory.peek();
        } catch (EmptyStackException e) {
            return null;
        }
    }

    @Override
    public boolean remove() {
        try {
         return   medicalHistory.pop() !=null;
            
        } catch (EmptyStackException e) {
            return false; 
        }
    }

    @Override
    public boolean add(MedicalRecord item) {
      return  medicalHistory.add(item);
       
    }

    @Override
    public Iterator getAll() {
      if (medicalHistory.isEmpty()) return null;
      return medicalHistory.iterator();
    }

    @Override
    public int size() {
return medicalHistory.size();
    }

    @Override
    public boolean isEmpty() {
return medicalHistory.isEmpty();
    }
}