/*
 * The MIT License
 *
 * Copyright 2014 chandni.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/*Meeting room: A company named x is shifting to a new office, As an admin, you have the responsibility of deciding upon the number of meeting rooms it should have.
You are given last day calendar of all employees, how will you optimize the number of rooms
*/
package practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author chandni
 */
class Meeting {
    long startTime;
    long endTime;
}

class Employee {
    ArrayList<Meeting> meetings;
}

class MeetingTimes implements Comparable<MeetingTimes>
{
    long timestamp;
    boolean isStart;
    
    public MeetingTimes (long ts, boolean isStart)
    {
        this.timestamp = ts;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(MeetingTimes o) {
        if (this.timestamp < o.timestamp)
            return -1;
        if (this.timestamp > o.timestamp)
            return 1;
        if (!this.isStart && o.isStart)        
            return -1;
        if (this.isStart && !o.isStart)        
            return 1;
        return 0;
    }    
}

public class MeetingRoom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        
        Employee e = new Employee ();
        ArrayList<Meeting> meetings = new ArrayList<>();
        Meeting m1 = new Meeting ();
        m1.startTime = 1000; m1.endTime = 1100;
        Meeting m2 = new Meeting ();
        m2.startTime = 1100; m2.endTime = 1200;
        meetings.add(m1);
        meetings.add(m2);
        e.meetings = meetings;
        employees.add(e);
        
        e = new Employee ();
        meetings = new ArrayList<>();
        m1 = new Meeting ();
        m1.startTime = 1015; m1.endTime = 1200;
        m2 = new Meeting ();
        m2.startTime = 1300; m2.endTime = 1430;
        meetings.add(m1);
        meetings.add(m2);
        e.meetings = meetings;
        employees.add(e);
        
        e = new Employee ();
        meetings = new ArrayList<>();
        m1 = new Meeting ();
        m1.startTime = 1245; m1.endTime = 1700;
        m2 = new Meeting ();
        m2.startTime = 900; m2.endTime = 1100;
        meetings.add(m1);
        meetings.add(m2);
        e.meetings = meetings;
        employees.add(e);
        
        System.out.println ("The minimum number of meeting rooms required is "+
                getMinMeetingRoomsRequired (employees));
    }
    
    private static int getMinMeetingRoomsRequired (ArrayList<Employee> employees)
    {
        ArrayList<MeetingTimes> mt = new ArrayList<>();
        for (Employee e:employees)
        {
            for (Meeting m:e.meetings)
            {
                mt.add (new MeetingTimes (m.startTime, true));
                mt.add (new MeetingTimes (m.endTime, false));
            }
        }
        
        Collections.sort(mt);
        
        int maxCnt=0, cnt=0;
        for (int i=0; i<mt.size(); i++)
        {
            if (!mt.get(i).isStart)
                cnt--;
            else
                cnt++;
            
            maxCnt = maxCnt<cnt?cnt:maxCnt;
        }
        
        return maxCnt;
    }
}
