import java.lang.Math;
public class Quick{
  public static int partition(int[] data,int start, int end){
    boolean rightside=false;
    int pos=start;
    int x=median(data,start,end,((end-start)/2)+start);
    //System.out.println(x);
  //holds index of chosen pivot point
    int temp=data[start];
  //temporary used during switching
    data[start]=data[x];
    data[x]=temp;
  //switch values to make pivot first one
  for (int i=start+1;i<end+1;i++) {
    /*System.out.println("--------------");
    System.out.println(i);
    System.out.println("pos" + pos);
    System.out.println(start);
    System.out.println(end);*/
    /*for (int h=0;h<data.length;h++ ) {
      System.out.print(data[h]+" ");
    }
    System.out.println("");*/
    rightside=!rightside;
    if (data[i]<data[start]){
      pos++;
      temp=data[pos];
      data[pos]=data[i];
      data[i]=temp;
    }
    if(data[i]==data[start]&&Math.random()*100%2==0){
      pos++;
      temp=data[pos];
      data[pos]=data[i];
      data[i]=temp;
    }
  //if the number is less than pivot, increase the position and then switch
}
temp=data[start];
data[start]=data[pos];
data[pos]=temp;
//switch pivot point to the pos
/*for (int h=0;h<data.length ;h++ ) {
  System.out.print(data[h]+" ");
}
System.out.println(" ");*/
//System.out.println("pos"+pos);
return pos;
    }
/*public static String toString(int[] data){
  String s="";
  for (int x=0;x<data.length;x++){
    s+=x+",";
  }
  return s+"\n";
}*/
//return value that is the kth smallest value of the array
public static int median(int data[],int low,int high, int middle){
  if(data[low]>=data[high]&&data[low]<=data[middle]){
    return low;
  }
  else if(data[low]<=data[high]&&data[high]<=data[middle]){
    return high;
  }
  else{
    return middle;
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
public static void quicksort(int[] data,low,high){
  int pivot;
  if(low>=high){
    return;
  }
  else{
    pivot=partition(data[],low,high);
    quicksort(data,low,pivot-1);
    quicksort(data,pivot+1,high);
  }
}
 public static void main(String[] args) {
   //int[] ary= {1} ;
    int[] ary= { 2, 22,33,22,33,7} ;

    //System.out.println(partition( ary ,0,5 ));
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
  }
}
