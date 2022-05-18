package at.ac.fhcampuswien.webproject.email;

public interface EmailSender {
    void send(String to, String email);
}