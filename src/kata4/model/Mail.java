package kata4.model;

public class Mail {
    private String mail;

    public Mail(String mail) {
        this.mail = mail;
    }
    public String getDomain(){
        String domain = "";
        if(mail.contains("@")){
            for(int i = 0; i <mail.length(); i++){
                if(mail.charAt(i) == '@'){
                    domain = mail.substring(i+1, mail.length());
                }
            }
        }else{
            return "email incorrecto";
        }
        return domain;
    }
    
}
