package kata4.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata4.model.Mail;

public class MailListReader {
    public List <Mail> read(String filename){
        List <Mail> list = new ArrayList <>();
        try{
            BufferedReader input =
                    new BufferedReader(new FileReader(filename));
            String token = "";
            while((token = input.readLine()) != null){
                if(token.contains("@")){
                    list.add(new Mail(token));
                }
            }
            input.close();
        }catch(FileNotFoundException ex){
            System.out.println("Fichero no encontrado");
        }catch(IOException ex){
            System.out.println("Error al leer fichero");
        }
        return list;
    }
    
}
