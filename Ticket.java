public class Ticket {
    private String registration, color;

    public Ticket(String registration, String color, boolean occupied) {
        this.registration = registration;
        this.color = color;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

