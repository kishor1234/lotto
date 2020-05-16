
import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPos.CharacterCodeTable;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.io.IOException;
import javax.print.PrintService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author asksoft
 */
public class printTest {

    public static void main(String args[]) throws IOException {
        try {
            PrintService printService = PrinterOutputStream.getPrintServiceByName("PDF");
            PrinterOutputStream printerOutputStream = new PrinterOutputStream(printService);
            try (EscPos escpos = new EscPos(printerOutputStream)) {
                escpos.writeLF("Hello Wold");
                escpos.setCharacterCodeTable(CharacterCodeTable.CP863_Canadian_French);
                escpos.writeLF("Liberté et Fraternité.");
                escpos.feed(5);
                escpos.cut(EscPos.CutMode.FULL);
                escpos.close();
            }
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
