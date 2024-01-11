package Tree.tree.heap;

public class Minheap {
    void add_min_heap(int T[] , int x){
        int temp ,num;
        num = ++T[0];
        T[num] = x;
        int j=num;
        int i =j/2;
        while(T[i]>T[j] && i>=1){
            temp = T[i];
            T[i] = T[j];
            T[j] = temp;
            j=i;
            i=i/2;
        }
    }

    public int delete_min_heap(int T[]){
        int num = T[0]--;
        int x = T[1];
        T[1]=T[num];
        int i=1,j=0,temp;
        while(true){
            if(T[2*i]==0 || T[2*i+1]==0)
                break;
            if(T[2*i]< T[2*i+1]){
                j=2*i;
            }
            else {
                j=2*i+1;
            }
            if(T[i]<T[j])
                break;

            temp = T[i];
            T[i] = T[j];
            T[j] = temp;
            i=j;
        }
        if(T[2*i]!=0 && T[i]>T[2*i]){
            temp = T[i];
            T[i] = T[j];
            T[j] = temp;
        }
        T[num]=0;
        return x;
    }
}
