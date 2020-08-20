
import java.util.ArrayList;
import java.util.Collections;

public class ParkingLot {
    
    private final String parkingLotName;
    private final int parkingLotSize;
    Ticket t;
    private final ArrayList<Ticket> ticket = new ArrayList<>();
    private final ArrayList<Integer> availableVacancy= new ArrayList<>();


    public ParkingLot(String parkingLotName, int parkingLotSize) {
        this.parkingLotName = parkingLotName;
        this.parkingLotSize = parkingLotSize;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public int getParkingLotSize() {
        return parkingLotSize;
    }

    public void park(String registration, String color, Boolean parkAction){
        if(parkAction){
            t = new Ticket(registration,color,true);
            if(availableVacancy.isEmpty()){
                ticket.add(t);
            }
            else {
                int position=availableVacancy.get(0);
                ticket.set(position,t);
            }
        }
        else {
            t = new Ticket(registration,color,false);
            int temp=0;
            for(int i=0;i<ticket.size();i++){
                if(ticket.get(i).getRegistration().equals(registration)){
                    temp++;
                    ticket.get(i).setRegistration("Empty");
                    ticket.get(i).setColor("Empty");
                    availableVacancy.add(i);
                    Collections.sort(availableVacancy);
                    break;
                }
                else if(ticket.size()==i && temp==0){
                    System.out.println("Invalid inputs");
                    break;
                }
            }
        }
    }


    public void displayStatus(){
        ticket.forEach((n)->System.out.println("\n"+n.getRegistration()+"\t"+n.getColor()));
    }

    public void registrationsForGivenColor(String color){
        ticket.stream()
                .filter(r->r.getColor().equals(color))
                .forEach(System.out::println);

       /* int temp=0;
        for (int i=0;i<ticket.size();i++){
            if(ticket.get(i).getColor().equals(color)){
                temp++;
                System.out.println("\t"+i+"."+ticket.get(i).getRegistration());
            }
            else if(ticket.size()==i && temp==0)
                System.out.println("No vehicle of given color found");
        }*/
    }

    public void slotsForGivenColor(String color){
        int temp=0;
        for (int i=0;i<ticket.size();i++){
            if(ticket.get(i).getColor().equals(color)){
                temp++;
                System.out.println("\t"+i);
            }
            else if(ticket.size()==i && temp==0)
                System.out.println("No vehicle of given color found");
        }
    }

}
