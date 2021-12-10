public class EmailSender {

    public void send(String email,String text){
        System.out.println(String.format("'%s' текст был отправлен на %s", text, email));
    }
}
