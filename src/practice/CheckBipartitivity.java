/*
 * The MIT License
 *
 * Copyright 2015 chandni.
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chandni
 */
public class CheckBipartitivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int T = Integer.parseInt (br.readLine());
        
        test:for (int t=1; t<=T; t++)
        {
            String split[] = br.readLine().split(" ");
            int bugs = Integer.parseInt (split[0]);
            int interactions = Integer.parseInt (split[1]);
            
            Graph g = new Graph (bugs);
            for (int i=0; i<interactions; i++)
            {
                split = br.readLine().split(" ");
                int u = Integer.parseInt (split[0]);
                int v = Integer.parseInt (split[1]);
                g.addEdge(u, v);
            }
            
            Boolean isGraphBipartite = true;
            for (int i=1; i<=bugs; i++)
            {
                Vertex thisVertex = g.getVertexNumber(i);
                
                /*if this vertex has not been visited, start a bfs on its 
                  connected component with this as root*/
                if (!thisVertex.visited)
                {
                    Vertex root = thisVertex;
                    isGraphBipartite &= isComponentBipartite (root);
                    if (!isGraphBipartite)
                        break;
                }
            }
            if (isGraphBipartite)
                System.out.println("Bipartite!");
            else
                System.out.println ("Not Bipartite!");
            
//            System.out.println ("Scenario #"+t+":");
//            if (isGraphBipartite)
//                System.out.println ("No suspicious bugs found!");
//            else
//                System.out.println ("Suspicious bugs found!");
        }
    }
    
    public static boolean isComponentBipartite (Vertex root)
    {
        ArrayDeque<Vertex> dq = new ArrayDeque<Vertex>();
        
        dq.add(root);
        root.colorBlack = true;
        root.visited = true;
        
        while (!dq.isEmpty())
        {
            Vertex out = dq.removeFirst();
            for (int i=0; i<out.adjacent.size(); i++)
            {
                Vertex v = out.adjacent.get(i);
                if (!v.visited)
                {
                    //add v to queue. out->v is a tree edge.
                    dq.add(v);
                    v.colorBlack = !out.colorBlack;
                    v.visited = true;
                }
                else
                    //v has been visited and alloted a color.
                    if (v.colorBlack == out.colorBlack)
                    //ie. v and out belong to the same level since non-tree 
                    //edges cannot jump levels.
                        return false;//component is non-bipartite                        
            }
        }
        return true;
    }
    
    
    private static class Graph {
        private Map V;
        public Graph(int vertices) {
            V = new HashMap<Integer, Vertex> ();
            for (int i=1; i<=vertices; i++)
                V.put(i, new Vertex(i));
        }
        
        public void addEdge (int u, int v)
        {
            getVertexNumber(u).adjacent.add(getVertexNumber(v));
            getVertexNumber(v).adjacent.add(getVertexNumber(u));
        }
        
        public Vertex getVertexNumber (int v)
        {
            return (Vertex)V.get(v);
        }
    }

    private static class Vertex {
        int label;
        ArrayList<Vertex> adjacent;
        boolean visited;
        boolean colorBlack;//for alternating colors
        
        public Vertex(int label) {
            this.label = label;
            adjacent = new ArrayList<Vertex> ();
            visited = false;
        }
    }
    
}
