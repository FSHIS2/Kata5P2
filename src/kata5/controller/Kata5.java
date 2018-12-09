package kata5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata5.model.Histogram;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;
import kata5.view.MailListReaderBD;

public class Kata5 {

    public static void main(String[] args) throws IOException, SQLException {
        MailListReaderBD bd = new MailListReaderBD();
        List <String> list = bd.read();
        MailHistogramBuilder histo = new MailHistogramBuilder();
        Histogram <String> histogram = histo.build(list);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
