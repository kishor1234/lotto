
import GUI.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asksoft
 */
public class Main {
    
    public static void main(String[] args) {
        
        try {
//            PrinterService printerService = new PrinterService();
//
//            System.out.println(printerService.getPrinters());
//            System.exit(0);
//
//            for (int i = 1; i <= 10; i++) {
//                //print some stuff
//                printerService.printString("PDF", "\n\n @aksort testing testing "+i+" 2 3eeeee \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
//
//                // cut that paper!
//                byte[] cutP = new byte[]{0x1d, 'V', 1};
//
//                printerService.printBytes("PDF", cutP);
//            }
            Login login = new Login();
            login.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
