package project;

import project.common.Count;
import project.common.Parking;
import project.staff.Staff;
import project.utilities.Energy;
import project.utilities.PublicUtilities;
import project.utilities.Water;

public class Database {

    public static final int SIZE = 8;
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "admin";
    public static Parking[] parkplaces = new Parking[20];
    public static Staff[] staff = new Staff[SIZE];
    public static Count counter = Count.create();
    public static PublicUtilities water = new Water();
    public static PublicUtilities energy = new Energy();

}
