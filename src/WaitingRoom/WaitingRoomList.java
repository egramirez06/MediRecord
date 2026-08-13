package WaitingRoom;

import clinic.SequentialDynamicsLists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import patients.Patient;

public class WaitingRoomList implements SequentialDynamicsLists<Patient>{
        Queue<Patient> WaitingList;
        
        public WaitingRoomList(){
        this.WaitingList = new LinkedList ();
        }

    @Override
    public Patient get() {
        return WaitingList.peek();
    }

    @Override
    public boolean remove() {
      return WaitingList.pull() != null;
    }

    @Override
    public boolean add(Patient item) {
    try {
    return WaitingList.add(item);
    } catch (IllegalStateException e)  {
        return false;
    }
    }

    @Override
    public Iterator getAll() {
     return WaitingList.iterator();
    }

    @Override
    public int size() {
        return WaitingList.size();
    }

    @Override
    public boolean isEmpty() {
   return WaitingList.isEmpty();
    }
}
