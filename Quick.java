import java.lang.Math;
public class Quick{
  public static int partition(int[] data,int start, int end){
    int pos=start;
    int x=(int)(Math.random()*100%(end-start+1))+start;
    System.out.println(x);
  //holds index of chosen pivot point
    int temp=data[start];
  //temporary used during switching
    data[start]=data[x];
    data[x]=temp;
  //switch values to make pivot first one
  for (int i=start+1;i<end+1;i++) {
    for (int h=0;h<data.length;h++ ) {
      System.out.print(data[h]+" ");
    }
    System.out.println("");
    if (data[i]<data[start]){
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
for (int h=0;h<data.length ;h++ ) {
  System.out.print(data[h]+" ");
}
System.out.println(" ");
return pos;
    }
public static String toString(int[] data){
  String s="";
  for (int x=0;x<data.length;x++){
    s+=x+",";
  }
  return s+"\n";
}
//return value that is the kth smallest value of the array
public static int quickselect(int[] data,int k){
  return selecting(data,k,0,data.length-1,0);
}
public static int selecting(int[] data, int k, int start,int end,int current){
  current=partition(data,start,end);

  if(current>k){
    return selecting(data,k,0,current,current);
  }
  if(current<k){
    return selecting(data,k,current,data.length-1,current);
  }
  return data[current];
}
 public static void main(String[] args) {

    int[] ary= { 2, 10, 15, 23, 0,  5} ;
    System.out.println(partition(ary,3,5));
    /*System.out.println(ary);
    quickselect( ary , 0 );
    System.out.println(toString(ary));
    System.out.println("would return 0");
    quickselect( ary , 1 );
    System.out.println(toString(ary));
    System.out.println("would return 2");
    quickselect( ary , 2 ) ;
    System.out.println(toString(ary));
    System.out.println("would return 5");
    quickselect( ary , 3 )  ;
    System.out.println(toString(ary));
    System.out.println("would return 10");
    quickselect( ary , 4 )  ;
    System.out.println(toString(ary));
    System.out.println("would return 15");
    quickselect( ary , 5 )  ;
    System.out.println(toString(ary));
    System.out.println("would return 23");*/
  }
}
