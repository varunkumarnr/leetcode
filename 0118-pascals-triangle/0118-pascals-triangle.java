// class Solution {
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> prev  = new ArrayList<>(); 
//         List<Integer> curr = new ArrayList<>(); 
//         prev.add(1); 
//         result.add(new ArrayList<>(prev)); 
//         for(int i = 2; i<= numRows;i++) {
//             for(int j = 0; j<i;j++) {
//                 int currNum = 0;
//                 if(j==0) {
//                     currNum += prev.get(j);
//                 } else if(j==i-1) {
//                     currNum+=prev.get(j-1); 
//                 }else {
//                     currNum = prev.get(j-1) +prev.get(j);
//                 }
//                 curr.add(currNum);
//             }
//             result.add(new ArrayList<>(curr));
//             prev.clear();
//             prev.addAll(curr);
//             curr.clear();
//         }
//         return result; 
//     }
// }



class Solution{
    public List<List<Integer>> generate(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    temp.add(1);
                else{
                    temp.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(temp);
        }
        return ans; 
    }
}