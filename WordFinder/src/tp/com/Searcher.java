package tp.com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Search the word in the file by using keyword
 * @author thinpyai
 *
 */
public class Searcher {

	public void search(String fileName, Scanner scanner) {
		File file = new File(fileName);
		String keyword;
		String status;
		Outputter outputter = new Outputter();

		if (file.exists()) {

			System.out.println("Would you like to search with keyword, Y or N");
			status = scanner.next();
			while ("y".equals(status.toLowerCase())) {
				System.out.println("Ender keyword to search.");
				keyword = scanner.next();
				if (keyword != null && keyword.trim().length() > 0) {
					Result result = searchWord(file, keyword);
					outputter.outputResult(result);
				} else {
					System.err.println("Please type the keyword");
				}
				System.out.println("Would you like to search again, Y or N");
				status = scanner.next();
			}

		} else {
			System.err.println("File is not existed.");
		}
	}

	/**
	 * search word in file by using keyword
	 * @param file filename
	 * @param keyword keyword
	 * @return searched result
	 */
	private Result searchWord(File file, String keyword) {
		Result result = new Result();
		int matchCount = 0;
		ArrayList<Integer> lineNoList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			int lineNo = 1;
			Pattern pattern = Pattern.compile(keyword);
			Matcher matcher;
			boolean matchFlag = false;

			while (line != null) {
				// get the match count in a line
				matcher = pattern.matcher(line);
				while (matcher.find()) {
					matchCount++;
					matchFlag = true;
				}
				if (matchFlag) {
					matchFlag = false;
					lineNoList.add(lineNo);
				}
				line = reader.readLine();
				lineNo++;
			}
			result.setTotalHit(matchCount);
			result.setLineNoList(lineNoList);

		} catch (FileNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return result;
	}

}
