package project.common;


import static project.Database.parkplaces;

public class Parking {
    private boolean isFree = true;
    private boolean isPaid = false;
    private short id;
    private Transport transport;


    public Parking(boolean isFree, boolean isPaid, Transport transport, short id){
        setFree(isFree);
        setPaid(isPaid);
        this.id = id;

    }


    public static void initParkplaces(){
        for (int i = 0; i < parkplaces.length; i++) {
            parkplaces[i] = new Parking(true, false, null, (short) (i+1));
        }
    }

    public static void showOccupied(){
        int counter = 0;
        for(Parking p : parkplaces){
            if(p.getTransport()!= null){
                p.getTransport().showTransportInfo();
                counter++;
            }

        }

        if(counter == 0){
            System.out.println("No one parking place is occupied");
        }
    }

    static void addToParkPlace(Transport transport){
        for (Parking parkplace : parkplaces) {
            if (parkplace.isFree()) {
                parkplace.setTransport(transport);
                parkplace.setFree(false);
                parkplace.setPaid(true);
                transport.setId(parkplace.getId());
                break;
            }
        }

    }


    public void setFree(boolean free) {
        isFree = free;
    }

    public void setTransport(Transport transport) { this.transport = transport; }

    public void setPaid(boolean paid) { isPaid = paid; }


    public boolean isFree() { return isFree; }

    public short getId() { return id; }

    public Transport getTransport() { return transport; }
}
