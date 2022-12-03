import java.util.List;

public class dataStructure {

    public int countOdd(List<Integer>list){
        int count=0;
        for(int num:list){
            if(num%2==1)
                count++;
        }
        return count;
    }

    public void exchange(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public int findMaximum(List<Integer>list,int begin,int end){
        int max=list.get(begin);
        for(int i=begin;i<end;i++){
            if(list.get(i)>max)
                max=list.get(i);
        }
        return max;
    }

}
