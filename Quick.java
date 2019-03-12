import java.lang.Math;
public class Quick{
  public static int partition(int[] data,int start, int end){
    int pos=start;
    int x=(int)(Math.random()*data.length%(end-start+1))+start;
    //System.out.println(x);
  //holds index of chosen pivot point
    int temp=data[start];
  //temporary used during switching
    data[start]=data[x];
    data[x]=temp;
  //switch values to make pivot first one
  for (int i=start+1;i<end+1;i++) {
    /*for (int h=0;h<data.length;h++ ) {
      System.out.print(data[h]+" ");
    }
    System.out.println("");*/
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
      end=current;
      current=partition(data,start,current);
    }
    if(current<k){
      start=current;
      current=partition(data,current,data.length-1);
    }
  }
  return data[current];
}
 /*public static void main(String[] args) {

    int[] ary= { 2, 22,33,22,33,22,33,22,33,22,3,33,2,33,2,33,23,33,33,22, 27} ;

    System.out.println(quickselect( ary , 1 ));
    //System.out.println(toString(ary));
    System.out.println("would return 2");
    System.out.println(quickselect( ary , 2 )) ;
    //System.out.println(toString(ary));
    System.out.println("would return 5");
    System.out.println(quickselect( ary , 3 ))  ;
    //System.out.println(toString(ary));
    System.out.println("would return 10");
    System.out.println(quickselect( ary , 4 ));
    //System.out.println(toString(ary));
    System.out.println("would return 15");
    System.out.println(quickselect( ary , 5 ));
    //System.out.println(toString(ary));
    System.out.println("would return 23");
  }*/
}
