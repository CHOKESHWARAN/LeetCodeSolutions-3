class Solution {
    public int sumOfSquares(int[] n) {
        int k=0;
        for(int i=0;i<n.length;i++){
          if(n.length%(i+1)==0){
            k+=n[i]*n[i];
          }

        }
        return k;
    
    }
}