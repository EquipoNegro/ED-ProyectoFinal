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
public class PFEstructuraDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {            
        Graph Maze = new Graph(13);
        //Se utiliza Nodo+1 ya que inicializarlo con 0 crea problemas en los punteros. Este cambio se 
        //revierte en la impresion.
        Maze.insertE(0+1,1+1);
        Maze.insertE(1+1,2+1);
        Maze.insertE(1+1,4+1);
        Maze.insertE(2+1,7+1);
        Maze.insertE(2+1,8+1);
        Maze.insertE(4+1,10+1);
        Maze.insertE(4+1,5+1);
        Maze.insertE(5+1,10+1);
        Maze.insertE(5+1,3+1);
        Maze.insertE(5+1,6+1);
        Maze.insertE(6+1,11+1);
        Maze.insertE(6+1,7+1);
        Maze.insertE(7+1,9+1);
        Maze.insertE(8+1,12+1);
        Maze.insertE(10+1,5+1);
        Maze.insertE(11+1,8+1); 
        //Probando con BFS y DFS modificados
        System.out.println(Maze.BFS(0+1,12+1));
        System.out.println(Maze.DFS(0+1,12+1));
    }
}
