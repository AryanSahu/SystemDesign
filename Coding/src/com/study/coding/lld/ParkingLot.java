package com.study.coding.lld;

import java.io.OutputStream;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParkingLot {




static List<ParkingLevel> parkingLevels = new ArrayList<>();

   static {
       parkingLevels.add(new ParkingLevel(10,VehicleCategory.BIKE));
       parkingLevels.add(new ParkingLevel(10,VehicleCategory.CAR));

   }


    public static void VehicleCheckin(Vehicle vehicle)
    {

        for(ParkingLevel parkingLevel:parkingLevels)
        {
           if(parkingLevel.isSpotAvailable())
           {
             Spot spot=parkingLevel.assignParkingSpot();

           }
        }

    }


}

class ParkingLevel
{
    List<Spot> parkingspots;

    ParkingLevel(int spots,VehicleCategory category)
    {
        parkingspots=new ArrayList<>();

        int i=0;
        while(i<spots)
        {
            parkingspots.add(new Spot(category));
            i++;
        }
    }

    public boolean isSpotAvailable()
    {
        int maxcapacity=40;

        if(parkingspots.size()<maxcapacity)
        {
            return true;
        }

        return false;
    }

    public Spot assignParkingSpot()
    {
        for(Spot spot:parkingspots)
        {
            if(spot.isAvailable)
            {
                return spot;
            }

        }

        return null;

    }

    public void releaseParkingSpot(Spot spot)
    {
        parkingspots.remove(spot);

    }


}

class Spot
{
    Vehicle vehicle;
    boolean isAvailable;
    VehicleCategory vehicleCategory;

    Spot(VehicleCategory vehicleCategory)
    {
        this.vehicleCategory=vehicleCategory;
    }

    public void assignSpot(Vehicle vehicle)
    {
        this.vehicle=vehicle;
        isAvailable=false;
    }

    public void releaseSpot()
    {
        this.vehicle=null;
        isAvailable=true;
    }


}

enum VehicleCategory
{
    CAR,BIKE;
}

class Vehicle
{
    VehicleCategory vehicleCategory;
    private long entryTime;

    Vehicle(VehicleCategory vehicleCategory)
    {
        this.vehicleCategory=vehicleCategory;
        entryTime=System.currentTimeMillis();

    }


    public static void main(String[] args) {

List<Integer> list=new ArrayList<>();
for(int i=0;i<100;i++) {
    list.add(i);
}

List<List<Integer>> klist=new ArrayList<>();
klist.add(list);
klist.add(list);

klist.stream().flatMap(t->t.stream()).forEach(t-> System.out.println(t));






list.stream().sorted((o,t)->{return o.compareTo(t);}).collect(Collectors.toList());

        try {
            Map<Integer,Integer> map=new HashMap<>();
            map.put(1,2);
            map.put(2,1);
            map.put(3,1);
            map.put(4,2);


            /*map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing())).forEach((k)->{
                System.out.println(k.getKey());
            });
*/
            Predicate<Integer> predicate=(t)->{return  t>1;};

            map.forEach((k,v)->{ if(predicate.test(v)){
              //  System.out.println(k);
            }});


       List<Map.Entry> a=    map.entrySet().stream().filter((t)->t.getValue()>1).collect(Collectors.toList());






        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}