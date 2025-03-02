class Untitled {
	public static void main(String[] args) {
		System.out.println(getSmallestString("bbcad"));   // Output: "aabad"
		System.out.println(getSmallestString("hackerrank")); // Output: "gackerrank"
		System.out.println(getSmallestString("aaaaa"));   // Output: "aaaaz"
	}
	
	public static String getSmallestString(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		boolean modified = false;
	
		for (int i = 0; i < n; i++) {
		`	if (arr[i] != 'a') {
				// Start modifying until we encounter 'a' or reach the end
				while (i < n && arr[i] != 'a') {
					arr[i] = (char) (arr[i] - 1);
					i++;
				}
				modified = true;
				break;
			}
		}
	
		// Edge case: If no modification happened (meaning the string was all 'a's), change the last character to 'z'
		if (!modified) {
			arr[n - 1] = 'z';
		}
	
		return new String(arr);
	}
	
}