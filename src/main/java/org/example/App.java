package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    TruckService truckService = new TruckService();
    Truck tata = new Truck("TATA", "2019", 1000, "rejesh");
    Truck volvo = new Truck("volvlo", "2020", 5000, "ambani");
    Truck eicher = new Truck("eicher", "2022", 2000, "rahul");

    //adding the data in db
    truckService.addTruck(tata);
    truckService.addTruck(volvo);
    truckService.addTruck(eicher);

    //fetch truck data
       Truck truck =  truckService.getTruckById(1);
        System.out.println("truck data :"+truck);

        //updating truck
        truck.setDriver_name("ali");
        truckService.updateTruck(truck);
        System.out.println("updated truck data:"+ truckService.getTruckById(1));


        //get all truck data
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("all trucks in db");
        for(Truck truck1 : allTrucks){
            System.out.println(truck1);
        }

        //delete truck data
        truckService.deleteTruck(2);
        System.out.println("Data deleted by id "+2);

        //retrieve the data after deletion and updation and all operation
       allTrucks = truckService.getAllTrucks();
        System.out.println("all trucks after all operations");
        System.out.println(allTrucks);



    }
}
