 public class GrafoConPesos {
   
      private int [][]  RecorridoACiudad;  // adjacency matrix
      private Object [] NumeroONombreDeLasCiudades;
   
      public GrafoConPesos (int n) {
         RecorridoACiudad  = new int [n][n];
         NumeroONombreDeLasCiudades = new Object[n];
      }
 
 
    public int size() { return NumeroONombreDeLasCiudades.length; }
 
    public void   setNombreDelNodo (int vertex, Object NombreDelNodo) { NumeroONombreDeLasCiudades[vertex]=NombreDelNodo; }
    public Object getNombreDelNodo (int vertex)               { return NumeroONombreDeLasCiudades[vertex]; }
 
    public void    addRecorrido (int LugarDeSalida, int LugarDeLLegada, int w)  
    { RecorridoACiudad[LugarDeSalida][LugarDeLLegada] = w; }
    public boolean isRecorrido (int LugarDeSalida, int LugarDeLLegada)  
    { return RecorridoACiudad[LugarDeSalida][LugarDeLLegada]>0; }
    public void    removeRecorrido (int LugarDeSalida, int LugarDeLLegada)  
    { RecorridoACiudad[LugarDeSalida][LugarDeLLegada] = 0; }
    public int     getCosto (int LugarDeSalida, int LugarDeLLegada)  
    { return RecorridoACiudad[LugarDeSalida][LugarDeLLegada]; }
 
    public int [] CiudadesVecinas (int vertex) {
       int count = 0;
       for (int i=0; i<RecorridoACiudad[vertex].length; i++) {
          if (RecorridoACiudad[vertex][i]>0) count++;
       }
       final int[]answer= new int[count];
       count = 0;
       for (int i=0; i<RecorridoACiudad[vertex].length; i++) {
          if (RecorridoACiudad[vertex][i]>0) answer[count++]=i;
       }
       return answer;
    }
 
    public void print () {
       for (int j=0; j<RecorridoACiudad.length; j++) {
          System.out.print (NumeroONombreDeLasCiudades[j]+": ");
          for (int i=0; i<RecorridoACiudad[j].length; i++) {
             if (RecorridoACiudad[j][i]>0) System.out.print (NumeroONombreDeLasCiudades[i]+":"+RecorridoACiudad[j][i]+" ");
          }
          System.out.println ();
       }
    }

    public static void main (String args[]) {
       final GrafoConPesos GrafoDeCiudades = new GrafoConPesos (5);
       GrafoDeCiudades.setNombreDelNodo(0, "Nivel 1");
       GrafoDeCiudades.setNombreDelNodo(1, "Nivel 2");
       GrafoDeCiudades.setNombreDelNodo(2, "Nivel 3");
       GrafoDeCiudades.setNombreDelNodo(3, "Nivel 4");
       GrafoDeCiudades.setNombreDelNodo(4, "Nivel 5");
       
       GrafoDeCiudades.addRecorrido (0,3,2);
       GrafoDeCiudades.addRecorrido (0,4,9);
       GrafoDeCiudades.addRecorrido (1,0,8);
       GrafoDeCiudades.addRecorrido (1,2,15);
       GrafoDeCiudades.addRecorrido (1,3,6);
       GrafoDeCiudades.addRecorrido (2,4,1);
       GrafoDeCiudades.addRecorrido (3,4,3);
       GrafoDeCiudades.addRecorrido (3,1,7);
       GrafoDeCiudades.addRecorrido (3,2,3);
       GrafoDeCiudades.addRecorrido (4,1,7);
       GrafoDeCiudades.addRecorrido (4,3,3);
       GrafoDeCiudades.print();
 
       final int [] pred = Dijkstra.dijkstra (GrafoDeCiudades, 0);
       for (int n=0; n<5; n++) {
          Dijkstra.printPath (GrafoDeCiudades, pred, 0, n);
       }
    }
 
 }
