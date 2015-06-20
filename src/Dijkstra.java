  public class Dijkstra {
   
     // Dijkstra's algorithm para encontrar caminos mas cortos
     public static int [] dijkstra (GrafoConPesos G, int s) {
        final int [] dist = new int [G.size()];  // es la distancia Mas corta empezando en s
        final int [] CiudadAnterior = new int [G.size()];  // nodo anterior
        final boolean [] CiudadVisitada = new boolean [G.size()]; 
// al incio todas son falsas
  
         for (int i=0; i<dist.length; i++) {
           dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
  
        for (int i=0; i<dist.length; i++) {
           final int next = minVertex (dist, CiudadVisitada);
           CiudadVisitada[next] = true;
  
  
           final int [] n = G.CiudadesVecinas (next);
           for (int j=0; j<n.length; j++) {
              final int v = n[j];
              final int d = dist[next] + G.getCosto (next,v);
              if (dist[v] > d) {
                 dist[v] = d;
                 CiudadAnterior[v] = next;
              }
           }
        }
        return CiudadAnterior;  // (ignore CiudadAnterior[s]==0!)
     }
  
     private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // grafo no esta conectado, o todas las Ciudades fueron Visitadas 
        for (int i=0; i<dist.length; i++) {
           if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
        }
        return y;
     }
  
     public static void printPath (GrafoConPesos G, int [] CiudadAnterior, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x!=s) {
           path.add (0, G.getNombreDelNodo(x));
           x = CiudadAnterior[x];
        }
        path.add (0, G.getNombreDelNodo(s));
        System.out.println (path);
     }
  
  }