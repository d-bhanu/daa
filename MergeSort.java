import java.util.*;
class MS{
    public void Mergepass(int a[],int lb,int ub){
        if(lb!=ub){
         int mid=(lb+ub)/2;
         Mergepass(a,lb,mid);
         Mergepass(a,mid+1,ub);
         Mergepass(a,lb,mid,ub);
       }
    }
    public void Mergesort(int a[],int lb,int mid,int ub){
      int i=lb;
      int j=mid+1;
      int k=lb;
      int[] temp=new int[10];
      while(i<mid && j<=ub){
        if(a[i]<a[j])
          temp[k++]=a[i++];
         else
          temp[k++]=a[j++];
      }
      while(j<=ub)
         temp[k++]=a[j++];
      for(i=lb;i<ub;i++)
       a[i]=temp[i];
     }
  }
  public class Mergesort{
    public static void main(String args[]){
      Scanner Sc=new Scanner (System.in);
      System.out.println("Enter array size");
      int n=Sc.nextInt();
      System.out.println("Enter the array elements");
     int[] a=new int[n];
   for(int i=0;i<n;i++)
    a[i]=Sc.nextInt();
    int lb=0,ub=n-1;
    MS ob=new MS();
    ob.Mergepass(a,lb,ub);
    System.out.println("array elements after sorting");
    for(int i=0;i<n;i++)
       System.out.println(a[i]);
    }
}