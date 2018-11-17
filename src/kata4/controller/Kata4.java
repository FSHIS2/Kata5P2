package kata4.controller;

import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.util.List;
 import kata4.model.Histogram;
 import kata4.model.Mail;
 import kata4.view.HistogramDisplay;
 import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {
    private List<Mail> list;
    private Histogram histogram;

    public static void main(String[] args) throws IOException {
        Kata4 k = new Kata4();
        k.execute();
        /*MailListReader lista = new MailListReader();
        MailHistogramBuilder histo = new MailHistogramBuilder();
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();*/
    }

    private void execute() throws IOException {
        input();
        process();
        output();
        
    }

    private void input() throws FileNotFoundException, IOException {
        MailListReader lista = new MailListReader();
        list = lista.read("email.txt");
    }

    private void process() {
        MailHistogramBuilder histo = new MailHistogramBuilder();
        histogram = histo.build(list);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }

}
