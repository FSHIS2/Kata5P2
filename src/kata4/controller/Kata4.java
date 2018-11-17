package kata4.controller;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    public static void main(String[] args) {
        MailListReader lista = new MailListReader();
        List<Mail> list = lista.read("email.txt");
        MailHistogramBuilder histo = new MailHistogramBuilder();
        Histogram histogram = histo.build(list);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }

}
