package edu.cmu.nsompura.allavailable.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vijay on 4/15/16.
 */
public class studyroom {

    //Person booking the room
    user Booker;

    //People to whom notifications must go
    List<user> friends=new ArrayList<user>();

    //Room Details
    int roomno;String roomName;
    //Timeslots are ten in no. Morning 8to9,to10,10to11,11to12,12to1
    public static boolean[] ts=new boolean[5];


    //resources in the room
    static boolean isTVAvailable=true;
    static boolean isComputerAvailable=true;
    static boolean isTableAvailable=true;
    static boolean isACAvailable=true;
    static boolean isLockersAvailable=true;



    //working or non working condition
    static boolean isTVWorking=true;
    static boolean isComputerWorking=true;
    static boolean isTableWorking=true;
    static boolean isACWorking=true;
    static boolean isLockersWorking=true;
    static boolean isRoomAvailable=true;


    //Array list of seats created
    List<seat> seats= new ArrayList<seat>();


    //Constructor
    public void room()
    {
        for(int i=0;i<5;i++)
        {
            ts[i]=true;
        }
    }

    //Returns room number
    public int getRoomNumber() {
        return roomno;
    }

    // Sets Room Number
    public void setRoomNumber(int room) {
        this.roomno = room;
    }

    //Returns room name
    public String getRoomName() {
        return roomName;
    }

    //Sets room name
    public void setRoomName(String roomName1)
    {
        this.roomName=roomName1;
    }


    public boolean getRoomAvailability()
    {
        return isRoomAvailable;
    }

    public String getRoomStatus()
    {   String str="Room Under Repair";
        if(isACWorking==true && isComputerWorking==true && isLockersWorking==true && isTableWorking==true){
            str="Room Available";
        }
        else if(isRoomAvailable==false)
        {
            str="Room Unavailable";
        }
        return str;
        }


    //Updates Room Resources status whether they are working or not after repair activities
    //if resource is working enter 1, if not enter 0, if you don't know enter any other number
    public void setRoomResourceStatus(int isACWorking1,int isComputerWorking1,int isLockersWorking1, int isTableWorking1, int isTVWorking1)
    {
        if(isACWorking1==0)
        {
            isACWorking=false;
        }else if(isACWorking1==1){
            isACWorking=true;
        }
        else{}
        if(isComputerWorking1==0)
        {
            isComputerWorking=false;
        }else if(isComputerWorking1==1){
            isComputerWorking=true;
        }
        else{}
        if(isLockersWorking1==0)
        {
            isLockersWorking=false;
        }else if(isLockersWorking1==1){
            isLockersWorking=true;
        }
        else{}
        if(isTableWorking1==0)
        {
            isTableWorking=false;
        }else if(isTableWorking1==1){
            isTableWorking=true;
        }
        else{}
        if(isTVWorking1==0)
        {
            isTVWorking=false;
        }else if(isTVWorking1==0){
            isTVWorking=true;
        }
        else{}
    }

    //Sets number of seats in the room
    public void setSeats(int noseats)
    {
        seat chair=new seat();
        for(int i=0;i<noseats;i++)
        {
            seats.add(chair);
            seats.get(i).setSeat(i);
        }
    }

    public class seat{

        user User;

        int seatnumber;

        boolean timeslot[]=new boolean[5];

        seat()
        {
            for(int i=0;i<5;i++)
            {
                timeslot[i]=true;
            }
        }

        public int getSeat() {
            return seatnumber;
        }

        public void setSeat(int seat) {
            this.seatnumber = seat;
        }

    }
}
