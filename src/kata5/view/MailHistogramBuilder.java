package kata5.view;

import java.util.List;
import kata5.model.Histogram;

public class MailHistogramBuilder {
        public Histogram<String> build(List<String> list) {
        Histogram<String> histogram = new Histogram<>();
        String domain = "";
        for (String email : list) {
            if(email.contains("@")){
            for(int i = 0; i < email.length(); i++){
                if(email.charAt(i) == '@'){
                    domain = email.substring(i+1, email.length());
                }
            }
        }
            histogram.increment(domain);
        }
        return histogram;
    }   
}
