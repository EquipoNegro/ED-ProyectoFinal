/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pf.estructuradatos;

/**
 *
 * @author Salvador
 */
public class Edge {
    private int dest;
    private double weight;
    
    public Edge(int dest)
    {
        this.weight=0.0;
        this.dest = dest;
    }
    public Edge(double weight, int dest)
    {
        this.dest = dest;
        this.weight = weight;
    }
    public int getDest()
    {
        return (Integer) this.dest;
    }
    double getWeight()
    {
        return this.weight;
    }
    public String toString()
    {
        return (this.dest)+" ("+(Double.toString(weight))+" )";
    }
}
