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

package hacker_earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class RoyAndTrendingTopics1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int N = Integer.parseInt (br.readLine());
        
        Topic[] topics = new Topic[N];
        for (int i=0; i<N; i++)
        {
            String[] split = br.readLine().split(" ");
            int id = Integer.parseInt(split[0]);
            int newScore = (Integer.parseInt(split[2])*50 +
                         Integer.parseInt(split[3])*5 +
                         Integer.parseInt(split[4])*10 +
                         Integer.parseInt(split[5])*20  );
            int diff = newScore-Integer.parseInt(split[1]);
                        
            topics[i] = new Topic (id, diff, newScore);
        }
        
        Arrays.sort (topics);
        for (int i=N-5; i<=N-1; i++)
        {
            System.out.println (topics[i].id+" "+topics[i].newScore);
        }
    }

    private static class Topic implements Comparable<Topic>{
        int id;
        int diff;
        int newScore;
        
        public Topic(int id, int diff, int newScore) {
            this.id = id;
            this.diff = diff;
            this.newScore = newScore;
        }

        @Override
        public int compareTo(Topic t) {
            if (this.diff<t.diff)
                return -1;
            else if (this.diff>t.diff)
                return 1;
            else if (this.id>t.id)
                return -1;
            else return 1;
        }
    }
    
}
