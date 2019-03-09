package tp.com;

import java.util.Scanner;

/**
 * Main of this app
 * @author thinpyai
 *
 */
public class WordFinder {

	/**
	 * main method
	 * @param args file name
	 */
	public static void main(String args[]) {
		Searcher searcher = new Searcher();

		Scanner scanner = new Scanner(System.in);

		// to be able to handle if file is more than one
		if (args.length > 0) {
			for (int index = 0; index < args.length; index++) {
				String fileName = args[index];
				searcher.search(fileName, scanner);
			}
		} else {
			System.err.println("Please input a file.");
		}
		scanner.close();

	}

}
