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
 
    public void    addRecorrido    (int LugarDeSalida, int LugarDeLLegada, int w)  { RecorridoACiudad[LugarDeSalida][LugarDeLLegada] = w; }
    public boolean isRecorrido     (int LugarDeSalida, int LugarDeLLegada)  { return RecorridoACiudad[LugarDeSalida][LugarDeLLegada]>0; }
    public void    removeRecorrido (int LugarDeSalida, int LugarDeLLegada)  { RecorridoACiudad[LugarDeSalida][LugarDeLLegada] = 0; }
    public int     getCosto  (int LugarDeSalida, int LugarDeLLegada)  { return RecorridoACiudad[LugarDeSalida][LugarDeLLegada]; }
 
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
       final GrafoConPesos t = new GrafoConPesos (6);
       t.setNombreDelNodo(0, "v0");
       t.setNombreDelNodo(1, "v1");
       t.setNombreDelNodo(2, "v2");
       t.setNombreDelNodo(3, "v3");
       t.setNombreDelNodo(4, "v4");
       t.setNombreDelNodo(5, "v5");
       t.addRecorrido (0,1,2);
       t.addRecorrido (0,5,9);
       t.addRecorrido (1,2,8);
       t.addRecorrido (1,3,15);
       t.addRecorrido (1,5,6);
       t.addRecorrido (2,3,1);
       t.addRecorrido (4,3,3);
       t.addRecorrido (4,2,7);
       t.addRecorrido (5,4,3);
       t.print();
 
       final int [] pred = Dijkstra.dijkstra (t, 0);
       for (int n=0; n<6; n++) {
          Dijkstra.printPath (t, pred, 0, n);
       }
    }
 
 }
