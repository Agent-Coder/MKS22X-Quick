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
  int[] pivot;
  if(low<high){
    pivot=partitionDutch(data,low,high);
    quicksortDutch(data,low,pivot[0]);
    quicksortDutch(data,pivot[1],high);
  }
}
public static int[] partitionDutch(int[] data,int low,int high){
  int lt=low+1;
  int gt=high;
  int x=median(data,low,high,((high-low)/2)+low);
  int temp=data[low];
  data[low]=data[x];
  data[x]=temp;
for (int i=lt;i<=gt;i++) {

  if (data[i]<data[low]){
    temp=data[lt];
    data[lt]=data[i];
    data[i]=temp;
    lt++;
  }
  else if(data[i]>data[low]){
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
}
if(low==lt-1){
  low++;
}
temp=data[low];
data[low]=data[lt-1];
data[lt-1]=temp;
int[] answer={lt-2,gt};
return answer;
}
/*public static void main(String[] args) {
   //int[] ary= {1} ;
    int[] ary= {2,3,2,3,2,6,4,8} ;
    quicksortDutch(ary,0,7);
    for (int h=0;h<ary.length ;h++ ) {
    System.out.print(ary[h]+" ");}
    System.out.println("---");
    //System.out.ln(toString(ary));
  }*/
}
