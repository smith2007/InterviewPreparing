package binary_search;

public class FirstBadVersion {

	public static void main(String[] args) {

		System.out.println(firstBadVersion(2));
	}


	static int firstBadVersion(int n) {
		if(n==1 && isBadVersion(1)){
			return 1;
		}
		int start = 1;
		int end = n;


		int lastBroken = -1;

		while (start<=end){
			int mid = start+(end-start)/2;

			if(isBadVersion(mid)){
				lastBroken = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		return lastBroken;
	}

	static boolean isBadVersion(int version){
		return version>=2;
	}
}
