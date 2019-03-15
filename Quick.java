import java.util.Random;
import java.lang.Math;
public class Quick{
  public static int partition(int[] data,int start, int end){
    Random gen=new Random();
    int x=median(data,start,end,((end-start)/2)+start);
    int i=start+1;
    int temp=data[start];
    data[start]=data[x];
    data[x]=temp;
  while (i<=end) {
    if (data[i]>data[start]||(data[i]==data[start]&Math.abs(gen.nextInt())%2==0)){
      temp=data[end];
      data[end]=data[i];
      data[i]=temp;
      end--;
    }
    else{
      i++;
    }
  //if the number is less than pivot, increase the position and then switch
}
  temp=data[start];
  data[start]=data[i-1];
  data[i-1]=temp;
  return i-1;
}
//return value that is the kth smallest value of the array
public static int median(int data[],int low,int high, int middle){
  if((data[low] <= data[high] && data[low] >= data[middle]) || (data[low] >= data[high] && data[low] <= data[middle])){
    return low;
  }
  else if((data[middle] <= data[high] && data[middle] >= data[low]) || (data[middle] >= data[high] && data[middle] <= data[low])){
    return middle;
  }
  else{
    return high;
  }
}
public static int quickselect(int[] data,int k){
  return selecting(data,k,0,data.length-1);
}
public static int selecting(int[] data, int k, int start,int end){
  int current=-1;
  while(current!=k){
    current=partition(data,start,end);
    //System.out.println(start);
    //System.out.println(end);
    //System.out.println("--");
    /*for (int h=0;h<data.length;h++ ) {
      System.out.print(data[h]+" ");
    }
    System.out.println("");
*/
    if(current>k){
      end=current-1;
    }
    if(current<k){
      start=current+1;
    }
  }
  return data[current];
}
public static void quicksortH(int[] data,int low,int high){
  int pivot;
/*for (int h=low;h<high+1 ;h++ ) {
  System.out.print(data[h]+" ");}*/
  if(low<high){

    pivot=partition(data,low,high);
    quicksortH(data,low,pivot-1);
    quicksortH(data,pivot+1,high);
  }
}
public static void quicksort(int[] data){
  quicksortH(data,0,data.length-1);
}
public static void quicksortDutch(int[] data,int low,int high){
  int pivot;
  if(low>=high){
    return;
  }
  else{
    pivot=partitionDutch(data,low,high);
    quicksortDutch(data,low,pivot);
    quicksortDutch(data,pivot,high);
  }
}
public static int partitionDutch(int[] data,int low,int high){
  int lt=low+1;
  int gt=high;
  int x=median(data,low,high,((high-low)/2)+low);
//holds index of chosen pivot point
  int temp=data[low];
//temporary used during switching
  data[low]=data[x];
  data[x]=temp;
//switch values to make pivot first one
for (int i=1;i<gt;i++) {
  /*for (int h=0;h<data.length;h++ ) {
    System.out.print(data[h]+" ");
  //  System.out.print(i+"ii");
  }
  System.out.println("--->"+lt);
  System.out.println(gt+"<---");
  System.out.println(low);
  System.out.println(high);
  System.out.println("");*/
  if (data[i]<data[low]){
    //System.out.println("no");
    temp=data[lt];
    data[lt]=data[i];
    data[i]=temp;
    lt++;
  }
  else if(data[i]>data[low]){
    //System.out.println("yes");
    temp=data[gt];
    data[gt]=data[i];
    data[i]=temp;
    gt--;
    i--;
  }
  else{
    temp=data[lt];
    data[lt]=data[i];
    data[i]=temp;
  }
//if the number is less than pivot, increase the position and then switch
}
temp=data[low];
data[low]=data[lt-1];
data[lt]=temp;
//switch pivot point to the pos
/*for (int h=0;h<data.length ;h++ ) {
System.out.print(data[h]+" ");
}
System.out.println(" ");*/
//System.out.println("pos"+pos);
return lt;
}
 /*public static void main(String[] args) {
   //int[] ary= {1} ;
    int[] ary= { 22, 3,2,12,72,48} ;
    quicksort(ary);
    for (int h=0;h<ary.length ;h++ ) {
    System.out.print(ary[h]+" ");}
    System.out.println("");
    //System.out.println(toString(ary));
    //System.out.println("would return 2");
    //System.out.println(quickselect( ary , 2 )) ;
    //System.out.println(toString(ary));
    //System.out.println("would return 5");
    //System.out.println(quickselect( ary , 3 ))  ;
    //System.out.println(toString(ary));
    //System.out.println("would return 10");
    //System.out.println(quickselect( ary , 0 ));
    //System.out.println(toString(ary));
    /*System.out.println("would return 15");
    System.out.println(quickselect( ary , 5 ));
    //System.out.println(toString(ary));
    System.out.println("would return 23");*/
  }*/
}
