package tp.com;

import java.util.ArrayList;

/**
 * Searched result
 * @author thinpyai
 *
 */
public class Result {

	int totalHit;
	ArrayList<Integer> lineNoList;

	/**
	 * @return the totalHit
	 */
	public int getTotalHit() {
		return totalHit;
	}

	/**
	 * @param totalHit
	 *            the totalHit to set
	 */
	public void setTotalHit(int totalHit) {
		this.totalHit = totalHit;
	}

	/**
	 * @return the lineNoList
	 */
	public ArrayList<Integer> getLineNoList() {
		return lineNoList;
	}

	/**
	 * @param lineNoList
	 *            the lineNoList to set
	 */
	public void setLineNoList(ArrayList<Integer> lineNoList) {
		this.lineNoList = lineNoList;
	}

}
