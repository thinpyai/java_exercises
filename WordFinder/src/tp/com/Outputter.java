package tp.com;
/**
 * Class to output the result
 * @author thinpyai
 *
 */
public class Outputter {

	public void outputResult(Result result) {
		if (result != null && result.getTotalHit() > 0) {
			System.out.println("Total match count : " + result.getTotalHit());

			System.out.print("Line no : ");
			for (Integer lineNo : result.getLineNoList()) {
				System.out.print(lineNo + " ");
			}
			System.out.println("");
		}

	}

}
