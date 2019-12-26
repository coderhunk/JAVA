import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args)throws IOException 
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
                
            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for(int i = 1; i <= edg; i++)
            {    int u = Integer.parseInt(s[p++]);
                 int v = Integer.parseInt(s[p++]);
                 list.get(u).add(v);
                
            }
            
            
            int res[] = new int[10001];
             res = new TopologicalSort().topoSort(list, nov);
            boolean valid = true;
            
            for(int i = 0; i < nov; i++)
            {
                int n = list.get(res[i]).size();
                for(int j = 0; j < list.get(res[i]).size(); j++)
                {
                    for(int k = i+1; k < nov; k++)
                    {
                        if(res[k]==list.get(res[i]).get(j))
                            n--;
                    }
                }
                if(n!=0)
                {
                    valid = false;
                    break;
                }
            }
            if(valid == true)
                System.out.println("0");
            else
                System.out.println("1");
		}
    }
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<>Integer>list: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort
{
    static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
        //System.out.println(N);
        int[] result=new int[N];
        int a=0;
        //HashSet<Integer> seen = new HashSet<Integer>();
        //intialising queue for indegree 0
        Queue<Integer> q=new LinkedList<Integer>();
       int[] indegree=new int[N];
       //intialise the in-degrees to 0
       for(int i=0;i<indegree.length;i++){
           indegree[i]=0;
       }
       //computing the in-degree
       for(int i=0;i<list.size();i++){
          for(int j=0;j<list.get(i).size();j++){
              indegree[list.get(i).get(j)]=indegree[list.get(i).get(j)]+1;
          }
           
       }
       /* checking the inderee array
       for(int i=0;i<indegree.length;i++){
           System.out.print(indegree[i]+" ");
       }
       System.out.println();
       */
       
       // checking for intial indegree 0 and putting it into queue
       for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0){
               q.add(i);
               //seen.add(i);
           }
       }
       while(!q.isEmpty()){
           int curr=q.poll();
           if(a<N){
           result[a]=curr;}
           a++;
           // remove this node from the graph and decrese the indegree of the corresponding nodes
           for(int i=0;i<list.get(curr).size();i++){
               indegree[list.get(curr).get(i)]=indegree[list.get(curr).get(i)]--;
               if(indegree[list.get(curr).get(i)]==0){
                   //if(!seen.contains(list.get(curr).get(i))){
                   q.add(list.get(curr).get(i));
                   //}
               }
           }
       }
       //System.out.print(result);
       //for(int i:result){
          // System.out.print(i+" ");
       //}
       return result;
       
           
       }
    }

