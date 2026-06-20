/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while(true){
            int i=rand7();
            int j=rand7();

            int indx = (i-1)*7+j; // it will generate the possible upto 49 so it will be not sutable for rand10() generation 
            /// we are considering 40
            /// i - row & j - col that makes 7*7 matrix filling them from 1 - 49 considering it.
            if(indx<=40){
                return (indx-1)%10+1;
            }
        }
    }
}
/// TC 
/// SC

