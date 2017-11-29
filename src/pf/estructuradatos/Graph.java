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
public class Graph {
    private int v, e; //Vertices y ejes del programa (conexiones y nodos)
    List<Edge> g[];
    boolean visited[]; //Lista de booleanos que relaciona los nodos ya visitados
    String pathString=""; //Variable de impresión global
    int[] parentNodes; //Guarda el registro de los previos
    
    //Constructor
    public Graph(int v)
    {
        //Inicio de variables locales
        this.v = v;
        this.e = 0;
        g = new List [v+1];
        for(int i = 1; i<v+1;i++)
        {
            g[i] = new List<>(); //Inicialización de listas dentro del arreglo.
        }
    }
    //Getters
    public int getEdges()
    {
        return this.e;
    }
    public int getVertices()
    {
        return this.v;
    }
    //Funciones
    public boolean isEdge(int s, int d) //Comprueba si hay una relación entre dos nodos
    {
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for (int i = 0; i < l.length ; i++)
        {
            if (d == p.data.getDest())
            {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    //Regresa el peso de un vertice entre nodos
    public double getEWeight(int s, int d)
    {
        List<Edge> l = this.g[s];
        Node<Edge> p = l.first;
        for (int i = 0; i < l.length; i++)
        {
                if (d == p.data.getDest())
                {
                    return p.data.getWeight();
                }
                p = p.next;
        }
        return -1.0;
    }
    //Inserta un nodo sin peso
    public void insertE(int s, int d)
    {
        insertE(s, d, 0.0);
    }
    //Inserta un nodo con peso
    public void insertE(int s, int d, double w)
    {
        if (!isEdge(s,d))
        {
            this.g[s].insertLast(new Edge(w, d));
            this.e++;
        }
        else
        {
            System.out.println("No es posible insertar elemento, ya se encuentra en el grafo");
        }
    }
    //Regresa una lista de nodos adyacentes a un nodo en especifico
    public List<Edge> adjacentTo(int s)
    {
        return this.g[s];
    }
    //Función que convierte los grafos a string
    public String toString()
    {
        String r = "";
        for (int i=1; i < this.v+1; i++){
            r += "\nVértice "+ i +" ";
            List<Edge> lp = adjacentTo(i);
            if (lp.isEmpty()){
                r += "sin Adyacentes.\n\n";
            }
            else
            {
                r += "con Adyacentes:\n";
                lp.pointer=lp.first;
                for (int j=1; j<=lp.length; j++){
                    r += lp.pointer.data.toString()+"\n";
                    lp.pointer=lp.pointer.next;
                }
            }
        }
        return r;
    }
    public String BFS(int origin, int destiny)
    {
        visited = new boolean [v+1]; //Matriz que indica los nodos visitados 
        pathString= "Recorrido BFS\n";
        Queue<Integer> q = new Queue<>();//Cola donde iremos guardando las visitas *ClosedList
        q.enqueue(origin); //Insertamos el primer nodo enviado
        visited[origin]=true; //Indicamos que ya fue visitado
        int aux;
        parentNodes = new int[v+1];
        while (!q.isEmpty()) //Mientras que la cola no esté vacía
        { 
            aux=q.dequeue();
            List<Edge> l = adjacentTo(aux); //obtenemos los adyacentes del nodo visitado y lo sacamos de la cola;
            l.pointer=l.first; //inicializamos el puntero de la lista en la primer posición.
            while(l.pointer!=null) //Recorremos la lista de adyacencia
            { 
                //Variable temporal tipo edge para evitar errores en 
                //llamadas a funciones de tipos genericos
                Edge tmp = (Edge) l.pointer.data;
                if(!visited[(int)tmp.getDest()])
                { //Preguntamos si ya fue visitado
                //Si no fue visitado, obtenemos el nodo adyacente
                    int a=(int) tmp.getDest(); //Se consigue el index
                    visited[a]=true; //El nodo se toma como visitado
                    q.enqueue(a); //Se agrega la visita a la cola
                    parentNodes[a]=aux;
                }
                l.pointer=l.pointer.next;//Se recorre el puntero
            }
        }
        //Stack para revertir el orden
        Stack printStack = new Stack();
        printStack.push(destiny-1); //Primera entrada es el destino (-1 debido a que se inicializa en +1 el nodo)
        for(int i=destiny; i!=1;i=parentNodes[i]) //Se inicia desde el destino, tomando los nodos que se recorrieron
        {
            printStack.push(parentNodes[i]-1); //(-1 debido a que se inicializa en +1 el nodo)
        }
        while(!printStack.isEmpty()) //Mientras que haya elementos en el printStack
        {
            pathString+=printStack.pop()+"->"; //Se van tomando del stack, hacia la string de impresión
        }
        pathString+="end!";
        return pathString;
}
    public String DFS(int origin, int destiny)
    {
        //Inicializamos las variables globales
        visited =new boolean[v+1];
        this.parentNodes = new int[v+1];
        pathString = (origin-1)+"->";
        //Utilizando recursividad, se regresa un string con el camino más corto
        return pathString="\nRecorrido DFS\n" + recursiveDFS(origin,destiny) +"end!"+"\n";
    }

    private String recursiveDFS(int origin,int destiny)
    {
        if (!this.visited[origin])
        {
            this.visited[origin]=true;
            List<Edge> l = adjacentTo(origin); //Se obtienen los adyacentes del origen
            l.pointer=l.first;//inicializamos el puntero de la lista en la primer posición.
            while(l.pointer!=null) //Recorremos la lista de adyacencia
            {
                Edge tmp = (Edge) l.pointer.data; //Variable temporal tipo edge para evitar errores en 
                                                  //llamadas a tipos genericos
                int a=(int)tmp.getDest();
                this.parentNodes[a]=origin;
                recursiveDFS(a, destiny); //Recursividad, se mueve al siguiente nodo pero con el mismo destino
                l.pointer = l.pointer.next; //Recorre el puntero de la lista de adyacentes
            }
        }
        if (origin==destiny) //Si nos encontramos en el destino, se imprime la ruta
        {
             //Stack para revertir el orden
            Stack printStack = new Stack();
            printStack.push(destiny-1); //Primera entrada es el destino (-1 debido a que se inicializa en +1 el nodo)
            for(int i=destiny; parentNodes[i]!=1;i=parentNodes[i]) //Se inicia desde el destino, tomando los nodos que se recorrieron
            {
                printStack.push(parentNodes[i]-1); //(-1 debido a que se inicializa en +1 el nodo)
            } 
            while(!printStack.isEmpty()) //Mientras que haya elementos en el printStack
            {
                pathString+=printStack.pop()+"->"; //Se van tomando del stack, hacia la string de impresión
            }
        }
        return pathString;
    }
}