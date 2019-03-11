import java.lang.Math;
public class Quick{
  public static int partition(int[] data,int start, int end){
    int pos=start;
    int x=(int)(Math.random()*100%(end-start+1))+start;
    //System.out.println(x);
    //holds index of chosen pivot point
    int temp=data[start];
    //temporary used during switching
    data[start]=data[x];
    data[x]=temp;
    //switch values to make pivot first one
    for (int i=start+1;i<end+1;i++ ) {
      /*for (int h=0;h<data.length ;h++ ) {
        System.out.print(data[h]+" ");
      }
      System.out.println(" ");*/
      if (data[i]<data[start]){
        pos++;
        temp=data[pos];
        data[pos]=data[i];
        data[i]=temp;
    }
    //if the number is less than pivot, increase the position and then switch
  }
  /*for (int h=0;h<data.length ;h++ ) {
    System.out.print(data[h]+" ");
  }
  System.out.println(" ");*/
  temp=data[start];
  data[start]=data[pos];
  data[pos]=temp;
  //switch pivot point to the pos
  /*for (int h=0;h<data.length ;h++ ) {
    System.out.print(data[h]+" ");
  }
  System.out.println(" ");*/
  return pos;
}
//return value that is the kth smallest value of the array
public static int quickselect(int[] data,int k){
  int temp=-1;
  while(temp!=data.length-k){
    if(temp>k){
      temp=partition(data, temp,data.length-1);
    }
    if(temp<k){
      temp=partition(data, 0,temp);
    }
  }
  return data[temp];
}
  public static void main(String[] args) {
    int[] ary= { 2, 10, 15, 23, 0,  5} ;
    quickselect( ary , 0 );
    System.out.println("would return 0");
    quickselect( ary , 1 );
    System.out.println("would return 2");
    quickselect( ary , 2 ) ; 
    System.out.println("would return 5");
    quickselect( ary , 3 )  ;
    System.out.println("would return 10");
    quickselect( ary , 4 )  ;
    System.out.println("would return 15");
    quickselect( ary , 5 )  ;
    System.out.println("would return 23");
  }
}
