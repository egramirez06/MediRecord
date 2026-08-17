
package clinic;
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
}
