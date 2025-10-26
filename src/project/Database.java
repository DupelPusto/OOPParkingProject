package project;

import project.common.Count;
import project.common.Parking;
import project.staff.Cleaner;
import project.staff.Security;
import project.utilities.Energy;
import project.utilities.Water;

public class Database {

    public static final int SIZE = 4;
    public static final String LOGIN = "admin";
    public static final String PASSWORD = "admin";
    public static Cleaner[] cleaners = new Cleaner[SIZE];
    public static Security[] securitys = new Security[SIZE];
    public static Parking[] parkplaces = new Parking[20];

    public static Count counter = Count.create();
    public static Energy energy = Energy.create();
    public static Water water = Water.create();
}
