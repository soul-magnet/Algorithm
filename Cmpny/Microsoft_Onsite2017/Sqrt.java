package MS.Onsite2017;

/**Implement int sqrt(int x).

 Compute and return the square root of x.

 Have you met this question in a real interview? Yes
 Example
 sqrt(3) = 1

 sqrt(4) = 2

 sqrt(5) = 2

 sqrt(10) = 3
 * Created by K25553 on 9/16/2016.
 */
public class Sqrt {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        long l=1, r=x;
        while(l+1<r){
            long mid= l+(r-l)/2;
            if(mid*mid==x){
                return (int)mid;
            }else
            if(mid*mid>x){
                r=mid;
            }else{
                l=mid;
            }
        }

        if(r*r<=x){
            return (int)r;
        }else {
            return (int)l;
        }
    }

}
