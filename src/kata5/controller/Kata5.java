package kata5.controller;

import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.util.List;
 import kata5.model.Histogram;
 import kata5.model.Mail;
 import kata5.view.HistogramDisplay;
 import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReader;

public class Kata5 {
    private List<Mail> list;
    private Histogram histogram;

    public static void main(String[] args) throws IOException {
        Kata5 k = new Kata5();
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
