/**
 *
 */
package MS.Onsite2017;

/**
 * Given a set of n nuts of different sizes and n bolts of different sizes.
 * There is a one-one mapping between nuts and bolts. Comparison of a nut to
 * another nut or a bolt to another bolt is not allowed. It means nut can only
 * be compared with bolt and bolt can only be compared with nut to see which one
 * is bigger/smaller.
 *
 * We will give you a compare function to compare nut with bolt.
 * Example
 * Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].
 *
 * Your code should find the matching bolts and nuts.
 *
 * one of the possible return:
 *
 * nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].
 *
 * we will tell you the match compare function. If we give you another compare
 * function.
 *
 * the possible return is the following:
 *
 * nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].
 *
 * So you must use the compare function that we give to do the sorting.
 *
 * The order of the nuts or bolts does not matter. You just need to find the
 * matching bolt for each nut.
 *
 * @author K25553
 *         analysis: quick sort, partition index = nut[left] with bolts[], then
 *         partition bolt[index] with nut[];
 *
 *
 */
public class NutsAndBoltsProblem {

	class NBComparator  {



		public int cmp(String string, String pivot) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	/**
	 * public class NBCompare {
	 * public int cmp(String a, String b);
	 * }
	 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
	 * if "a" is bigger than "b", it will return 1, else if they are equal,
	 * it will return 0, else if "a" is smaller than "b", it will return -1.
	 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is
	 * not valid.
	 */
	/**
	 * @param nuts
	 *            : an array of integers
	 * @param bolts
	 *            : an array of integers
	 * @param compare
	 *            : a instance of Comparator
	 * @return: nothing
	 */
	public void sortNutsAndBolts(String[] nuts, String[] bolts,
								 NBComparator compare) {
		if (nuts == null || bolts == null||nuts.length != bolts.length) {
			return;
		}
		qsort(nuts, bolts, compare, 0, nuts.length - 1);
	}

	public void qsort(String[] nuts, String[] bolts, NBComparator compare,
					  int l, int r) {
		if (l >= r) {
			return;
		}
		String pN = bolts[l]; int pos = patition (nuts,l, r,pN, compare);
		patition (bolts,l, r, nuts[pos], compare);//partion root, then sub tree
		qsort(nuts, bolts, compare, pos+1, r);
		qsort(nuts, bolts, compare, l, pos - 1);
	}

	private int patition(String[] dic, int l0, int r0, String p, NBComparator compare) {
		for(int i= 0; i<dic.length;i++ ){
			if(compare.cmp(dic[i], p)==0||compare.cmp(p,dic[i])==0){
				String tmp = dic[i];
				dic[i]= dic[l0];
				dic[l0]= tmp;
				break;
			}
		}
		String p0= dic[l0]; int l = l0, r=r0;
		while(l<r){
			while(l<r&&(compare.cmp(dic[r], p)==-1||compare.cmp(p,dic[r])==1)){
				r--;
			}
			dic[l] = dic[r];
			while(l<r&&(compare.cmp(dic[l], p)==1||compare.cmp(p,dic[l])==-1)){
				l++;
			}
			dic[r] = dic[l];
		}
		dic[l] = p0;
		return l;
	}
}
