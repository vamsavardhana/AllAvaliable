package edu.cmu.nsompura.allavailable.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class building
{
    static int buildingNumber=23;
    public List<room> rooms=new ArrayList<room>();
    public List<studyroom> rooms1=new ArrayList<studyroom>();
    public void setBuildingNumber(int buildingNumber1)
    {
        this.buildingNumber=buildingNumber1;
    }
    public int getBuildingNumber()
    {
        return this.buildingNumber;
    }

    public building(int buildingNumber1)
    {
        if(buildingNumber==19)
        {
            //List of conference rooms in building 19
            for(int i=0;i<5;i++)
            {
                room basicroom=new room();
                rooms.add(i,basicroom);
            }
            rooms.get(0).setRoomNumber(1);
            rooms.get(0).setRoomName("Room 1020");
            rooms.get(1).setRoomNumber(2);
            rooms.get(1).setRoomName("Room 1021");
            rooms.get(2).setRoomNumber(3);
            rooms.get(2).setRoomName("Room 1022");
            rooms.get(3).setRoomNumber(4);
            rooms.get(3).setRoomName("Room 1023");
            rooms.get(4).setRoomNumber(5);
            rooms.get(4).setRoomName("Room 1024");

            //List of study rooms in Building 19
            for(int i=0;i<5;i++)
            {
                studyroom basicroom1=new studyroom();
                rooms1.add(i,basicroom1);
            }
            rooms1.get(0).setRoomNumber(1);
            rooms1.get(0).setRoomName("Room 1043");
            rooms1.get(1).setRoomNumber(2);
            rooms1.get(1).setRoomName("Room 1044");
            rooms1.get(2).setRoomNumber(3);
            rooms1.get(2).setRoomName("Room 1045");
            rooms1.get(3).setRoomNumber(4);
            rooms1.get(3).setRoomName("Room 1046");
            rooms1.get(4).setRoomNumber(5);
            rooms1.get(4).setRoomName("Room 1047");
        }
        else if(buildingNumber==23)
        {
            for(int i=0;i<5;i++)
            {
                room basicroom=new room();
                rooms.add(i,basicroom);
            }
            rooms.get(0).setRoomNumber(1);
            rooms.get(0).setRoomName("Room 129A");
            rooms.get(1).setRoomNumber(2);
            rooms.get(1).setRoomName("Room 129B");
            rooms.get(2).setRoomNumber(3);
            rooms.get(2).setRoomName("Room 228B");
            rooms.get(3).setRoomNumber(4);
            rooms.get(3).setRoomName("Room 230B");
            rooms.get(4).setRoomNumber(5);
            rooms.get(4).setRoomName("Room 231B");
        // List of study rooms in building 23
            for(int i=0;i<5;i++)
            {
                studyroom basicroom1=new studyroom();
                rooms1.add(i,basicroom1);
            }
            rooms1.get(0).setRoomNumber(1);
            rooms1.get(0).setRoomName("Study room 1");
            rooms1.get(1).setRoomNumber(2);
            rooms1.get(1).setRoomName("Study room 2");
            rooms1.get(2).setRoomNumber(3);
            rooms1.get(2).setRoomName("Study room 3");
            rooms1.get(3).setRoomNumber(4);
            rooms1.get(3).setRoomName("Study room 4");
            rooms1.get(4).setRoomNumber(5);
            rooms1.get(4).setRoomName("Study room 5");
        }
        else
        {
            Log.i("ERROR WRONG BUILDING NO", buildingNumber + "");
        }
    }

}