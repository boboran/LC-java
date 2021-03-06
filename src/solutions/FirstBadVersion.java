package solutions;

/**
You are a product manager and currently leading a team to develop a new product. 
Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, 
all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. 
Implement a function to find the first bad version. 
You should minimize the number of calls to the API.

Example:
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l=1, r=n;
        while (l<r) {
            // System.out.println(l+","+r);
            int m = l+(r-l)/2;
            if (isBadVersion(m)) {
                if (m-1>=l && isBadVersion(m-1)) {
                    r = m-1;
                    continue;
                }
                return m;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    
    //test
    boolean isBadVersion(int num) {
    	return num>=4;
    }
    
    public static void main(String[] args) {
    	FirstBadVersion fbv = new FirstBadVersion();
    	int result = fbv.firstBadVersion(25);
    	System.out.println("result is "+result);
	}
}
