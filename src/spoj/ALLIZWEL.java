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

//test inputs: http://pastebin.com/znH3Q2MK
//AC :)
package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author chandni
 */
public class ALLIZWEL {

    static final char[] toFind = "ALLIZZWELL".toCharArray();
    static String[] graph;
    static boolean[][] visited;
    static int R, C;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine ());
        
        test:for (int t=0; t<T; t++)
        {
            String[] split = br.readLine().split(" ");
            R = Integer.parseInt (split[0]);
            C = Integer.parseInt (split[1]);
            
            graph = new String[R];
            for (int r=0; r<R; r++)
                graph[r] =  br.readLine();
            
            visited = new boolean[R][C];
            
            for (int i=0; i<R; i++)
                for (int j=0; j<C; j++)
                {
                    if (graph[i].charAt(j)==toFind[0])
                    {
                        //initialize all visited nodes to unvisited before each dfs run.
                        for (int r=0; r<R; r++)
                            Arrays.fill(visited[r], false);
                        
                        if (findPath (i, j, 0))
                        {
                            System.out.println("YES");
                            br.readLine();
                            continue test;
                        }
                    }
                }
            System.out.println("NO");

            br.readLine();
        }
    }

    private static boolean findPath(int i, int j, int toMatch) {
        if (i<0 || i>=R || j<0 || j>=C /*|| toMatch>=toFind.length*/)
            return false;
        
        visited[i][j] = true;
        
        if (toMatch==toFind.length-1)
        {
            if (graph[i].charAt(j) == toFind[toMatch])
                return true;
            else
                return false;
        }
        
        if (graph[i].charAt(j) != toFind[toMatch])
            return false;
        
        boolean e, se, s, sw, w, nw, n, ne;
        e= se= s= sw= w= nw= n= ne=false;
        
        if (!(i<0 || i>=R || j+1<0 || j+1>=C) && !visited[i][j+1])
        {
            e = findPath(i, j+1, toMatch+1);
            if (!e)
                visited[i][j+1] = false;//reset status unvisited on backtracked node
        }
        if (!(i+1<0 || i+1>=R || j+1<0 || j+1>=C) && !visited[i+1][j+1])
        {
            se = findPath(i+1, j+1, toMatch+1);
            if (!se)
                visited[i+1][j+1] = false;//reset status unvisited on backtracked node
        }
        if (!(i+1<0 || i+1>=R || j<0 || j>=C) && !visited[i+1][j])
        {
            s = findPath(i+1, j, toMatch+1);
            if (!s)
                visited[i+1][j] = false;//reset status unvisited on backtracked node
        }
        if (!(i+1<0 || i+1>=R || j-1<0 || j-1>=C) && !visited[i+1][j-1])
        {
            sw = findPath(i+1, j-1, toMatch+1);
            if (!sw)
                visited[i+1][j-1] = false;//reset status unvisited on backtracked node
        }
        if (!(i<0 || i>=R || j-1<0 || j-1>=C) && !visited[i][j-1])
        {
            w = findPath(i, j-1, toMatch+1);
            if (!w)
                visited[i][j-1] = false;//reset status unvisited on backtracked node
        }
        if (!(i-1<0 || i-1>=R || j-1<0 || j-1>=C) && !visited[i-1][j-1])
        {
            nw = findPath(i-1, j-1, toMatch+1);
            if (!nw)
                visited[i-1][j-1] = false;//reset status unvisited on backtracked node
        }
        if (!(i-1<0 || i-1>=R || j<0 || j>=C) && !visited[i-1][j])
        {
            n = findPath(i-1, j, toMatch+1);
            if (!n)
                visited[i-1][j] = false;//reset status unvisited on backtracked node
        }
        if (!(i-1<0 || i-1>=R || j+1<0 || j+1>=C) && !visited[i-1][j+1])
        {
            ne = findPath(i-1, j+1, toMatch+1);
            if (!ne)
                visited[i-1][j+1] = false;//reset status unvisited on backtracked node
        }
        
        return e||se||s||sw||w||nw||n||ne;
    }
    
}
