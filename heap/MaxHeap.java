package Tree.tree.heap;
import java.util.Scanner;
public class MaxHeap {
    int T[];
    int size=0;

    public MaxHeap(int capacity) {
        T = new int[capacity];
        T[0]=0;
    }

    void add_max_heap(int x){
            int temp ,num;
            num = ++T[0];
            T[num] = x;
            int j=num;
            int i =j/2;
            while(T[i]<T[j] && i>=1){
                temp = T[i];
                T[i] = T[j];
                T[j] = temp;
                j=i;
                i=i/2;
            }
            size++;
        }

        public int delete_max_heap(){
            int num = T[0]--;
            int x = T[1];
            T[1]=T[num];
            int i=1,j=0,temp;
            while(true){
                if(T[2*i]==0 || T[2*i+1]==0)
                    break;
                if(T[2*i]> T[2*i+1]){
                    j=2*i;
                }
                else {
                    j=2*i+1;
                }
                if(T[i]>T[j])
                    break;

                temp = T[i];
                T[i] = T[j];
                T[j] = temp;
                i=j;
                }
            if(T[2*i]!=0 && T[i]<T[2*i]){
                temp = T[i];
                T[i] = T[j];
                T[j] = temp;
            }
            T[num]=0;
            return x;
        }

        public int minimumE(){

            int minimumElement = T[1];

            for(int i=1 ; i<size;i++){
                if(minimumElement>T[i]){
                    minimumElement=T[i];
                }
            }
            return minimumElement;
        }

        public void printMaxHeap(){
            for (int params:T) {
                System.out.print(params +"  " );
            }
        }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        maxHeap.add_max_heap(12);
        maxHeap.add_max_heap(10);
        maxHeap.add_max_heap(11);
        maxHeap.add_max_heap(111);
        maxHeap.add_max_heap(132);
        maxHeap.add_max_heap(24);
        maxHeap.add_max_heap(13);
        System.out.println(maxHeap.delete_max_heap());
        System.out.println(maxHeap.minimumE());


    }
}
