package clinic;
public class ClinicController {
    private Clinic clinic;
    private iView view;
    private static ClinicController controller;
    
    public static ClinicController getInstance(iView view){
    if (controller==null)
        controller=new ClinicController(view);
    return controller;
    } 

    public void setView(iView view) {
        this.view = view;
    }
    
    private ClinicController(iView view){
    this.clinic = new clinic;
    this.view = view;
    }
}
