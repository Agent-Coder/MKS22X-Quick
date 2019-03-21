import java.util.Random;
import java.lang.Math;
import java.util.Arrays;
public class Quick{
  public static int partition(int[] data,int start, int end){
    Random gen=new Random();
    int x=median(data,start,end,((end-start)/2)+start);
    int i=start+1;
    int temp=data[start];
    data[start]=data[x];
    data[x]=temp;
  while (i<=end) {
    if (data[i]>data[start]||(data[i]==data[start]&&Math.abs(gen.nextInt())%2==0)){
      temp=data[end];
      data[end]=data[i];
      data[i]=temp;
      end--;
    }
    else{
      i++;
    }
}
  temp=data[start];
  data[start]=data[i-1];
  data[i-1]=temp;
  return i-1;
}
public static int median(int data[],int low,int high, int middle){
  if((data[low] <= data[high] && data[low] >= data[middle]) || (data[low] >= data[high] && data[low] <= data[middle])){
    return low;
  }
  else if((data[middle] <= data[high] && data[high] <= data[low]) || (data[middle] >= data[high] && data[high] >= data[low])){
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
  if(low<high){
    pivot=partition(data,low,high);
    quicksortH(data,low,pivot-1);
    quicksortH(data,pivot+1,high);
  }
}
public static void quicksort(int[] data){
  quicksortDutch(data,0,data.length-1);
}
public static void quicksortDutch(int[] data,int low,int high){
  //System.out.println(Arrays.toString(data));
  if(low<high&&high-low<=43){
    insertionSort(data,low,high);
    return;
  }
  int[] pivot;
  if(low<high){
    pivot=partitionDutch(data,low,high);
    quicksortDutch(data,low,pivot[0]-1);
    quicksortDutch(data,pivot[1]+1,high);
  }
}

public static int[] partitionDutch(int[] data,int low,int high){
  int lt=low;
  int gt=high;
  int i=low;
  int temp;
  int index=median(data,low,high,((high-low)/2)+low);
  int p=data[index];
  data[index]=data[low];
  data[low]=p;
while (i<=gt) {
  //System.out.println(Arrays.toString(data));
  if (data[i]<p){
    temp=data[lt];
    data[lt]=data[i];
    data[i]=temp;
    lt++;
    i++;
  }
  else if(data[i]>p){
    temp=data[gt];
    data[gt]=data[i];
    data[i]=temp;
    gt--;
  }
  else{
    i++;
  }
}
int[] answer={lt,gt};
return answer;
}

public static void insertionSort(int[] data,int low, int high){
int store;
//stores number that is being placed
int i;
//keeps track of current index being examined
for (int x=low+1;x<high+1;x++){
    store=data[x];
    i=x;
    //store the value at the index we are examining
    while (i>=low+1&&store<data[i-1]){
      //loop backwards to find number where it is greater than stored
      data[i]=data[i-1];
      //start shifting if the stored number is less than current
      i--;
      //increment i, examines from right to left
    }
    data[i]=store;
    //set number at the place
 }
}
/*public static void main(String[] args) {
    int[] ary={1,13,313,222,23323,3274,33,353,7,3,10,20,30};
    int[] x=new int[ary.length];
    quicksort(ary);
    System.out.println(Arrays.toString(ary));
  }*/


}
