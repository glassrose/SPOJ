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

package practice;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author chandni
 */
public class ConferenceTrackManagement {
    private static class Talk implements Comparable<Talk>
    {
        int minutes;
        String title;

        @Override
        public int compareTo(Talk o) {//for descending order
            if (this.minutes < o.minutes)
                return 1;
            if (this.minutes > o.minutes)
                return -1;
            return 0;
        }
    }
    private static class Session
    {
        int totalTime;
        int timeLimit;
        ArrayList<Talk> talks;
        
        public Session ()
        {
            talks = new ArrayList<Talk>();
        }
        
        public void addTalk (Talk talk)
        {
            talks.add(talk);
            totalTime += talk.minutes;
        }
        
        public Calendar print (Calendar time)
        {
            Calendar t = time;
            for (int i=0; i<talks.size(); i++)
            {
                Date d = t.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
                System.out.println (sdf.format(d)+" "+talks.get(i).title);
                t.add(Calendar.MINUTE, talks.get(i).minutes);
            }
            return t;
        }
    }
    private static class Track
    {
        Session session1;
        Session session2;
        
        public Track ()
        {
            session1 = new Session();
            session1.timeLimit = 60*3;
            session2 = new Session();
            session2.timeLimit = 60*4;
        }
        
        public void print ()
        {
            Calendar time1 = Calendar.getInstance();
            Calendar time2 = Calendar.getInstance();
            time1.set(Calendar.HOUR_OF_DAY, 9);
            time1.set(Calendar.MINUTE, 0);
            time1.set(Calendar.SECOND, 0);
            time2.set(Calendar.HOUR_OF_DAY, 13);
            time2.set(Calendar.MINUTE, 0);
            time2.set(Calendar.SECOND, 0);
            
            session1.print (time1);
            System.out.println("12:00PM Lunch");
            Calendar finishTime = session2.print (time2);
            if (finishTime.get(Calendar.HOUR_OF_DAY)<=15)
                System.out.println("04:00PM Networking Event");
            else
                System.out.println("05:00PM Networking Event");
            System.out.println();
        }
    }
    
    public static void main (String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        
        ArrayList<Talk> talks = new ArrayList<>();
        String line;
        while (!((line = br.readLine()).equals("")))
        {
            Talk talk = new Talk ();
            String[] split = line.split(" ");
            if (split[split.length-1].equals("lightning"))
            {
                talk.minutes = 5;
                talk.title = line;
            }
            else
            {
                String[] split2 = split[split.length-1].split("min");
                talk.minutes = Integer.parseInt (split2[split2.length-1]);
                talk.title = line;
            }
            talks.add(talk);
        }
        //Sort talks in descending order by duration
        Collections.sort(talks);
        
        ArrayList<Track> tracks = bestFitApproximation (talks);
        for (int i=0; i<tracks.size(); i++)
        {
            System.out.println ("Track "+(i+1)+":");
            tracks.get(i).print();
        }
    }
    
    public static ArrayList<Track> bestFitApproximation (ArrayList<Talk> talks)
    {
        ArrayList<Track> tracks = new ArrayList<>();
        ArrayList<Session> sessions = new ArrayList<>();
        Session pseudoSession = new Session ();
        pseudoSession.totalTime = -1;
        
        for (int i=0; i<talks.size(); i++)
        {
            Session bestSession = pseudoSession;
            for (int j=0; j<sessions.size(); j++)
            {
                //Choose the most full session which has room for this talk. "Best fit".
                if (bestSession.totalTime < sessions.get(j).totalTime &&
                    sessions.get(j).totalTime + talks.get(i).minutes < sessions.get(j).timeLimit)
                    bestSession = sessions.get(j);
            }
            
            if (bestSession==pseudoSession)//talk "i" not fitting in any existing session
            {
                //add a track and thus automatically 2 more sessions
                Track newTrack = new Track ();
                tracks.add(newTrack);
                sessions.add(newTrack.session1);
                sessions.add(newTrack.session2);
                
                newTrack.session1.addTalk(talks.get(i));
            }
            else//there's room for this talk in an existing session. Add it to bestSession.
            {
                bestSession.addTalk(talks.get(i));
            }
        }
        
        return tracks;
    }
}
