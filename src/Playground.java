import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import htmlparser.HTMLtoText;
import textprocessing.BoyerMoore;
import textprocessing.BruteForceMatch;
import textprocessing.In;
import textprocessing.KMP;
import textprocessing.Queue;
import textprocessing.StdOut;
import textprocessing.TST;

/**
 * 
 * @author Jobanpreet Singh Student id: 110024321 Assignment 4
 *
 */

public class Playground {

	static File[] dir_Listing;
	static File dir;
	static String txt_name;

	/*
	 * BruteForceMatch, BoyerMoore and KMP provided in the source code. Found all
	 * occurrences of patterns “hard”, “disk”, “hard disk”, “hard drive”, “hard
	 * dist” and “xltpru”, and showing its offsets. Repeating 100 times and
	 * recording the average CPU time for each case
	 */
	void task1() {

		String str1 = "hard";
		String str2 = "disk";
		String str3 = "hard disk";
		String str4 = "hard drive";
		String str5 = "hard dist";
		String str6 = "xltpru";
		String txt = null;
		In input = new In("Hard disk.txt");

		while (!input.isEmpty()) {
			txt = input.readAll();

		}
		List<Integer> BruFpositions = new ArrayList<>();
		StdOut.println("For the Algorithm BruteForceMatch \n");
		BruFpositions = BruteForceMatchAll(str1, txt);


		StdOut.print("Pattern1: ");
		StdOut.print(" ");
		StdOut.println(str1 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));
		BruFpositions = BruteForceMatchAll(str2, txt);


		StdOut.print("\n\nPattern2: ");
		StdOut.print(" ");
		StdOut.println(str2 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));

		BruFpositions = BruteForceMatchAll(str3, txt);


		StdOut.print("\n\nPattern3: ");
		StdOut.print(" ");
		StdOut.println(str3 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));
		BruFpositions = BruteForceMatchAll(str4, txt);


		StdOut.print("\n\nPattern4: ");
		StdOut.print(" ");
		StdOut.println(str4 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));
		BruFpositions = BruteForceMatchAll(str5, txt);


		StdOut.print("\n\nPattern5: ");
		StdOut.print(" ");
		StdOut.println(str5 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));

		BruFpositions = BruteForceMatchAll(str6, txt);

		StdOut.print("\n\nPattern6: ");
		StdOut.print(" ");
		StdOut.println(str6 + " is found at positions ");
		for (int i = 0; i < BruFpositions.size() - 1; i++) {
			System.out.print(BruFpositions.get(i) + ",");
		}
		System.out.print(BruFpositions.get(BruFpositions.size() - 1));

		List<Integer> BM_positions = new ArrayList<>();
		// BoyerMoore search offsets
		StdOut.println("\n\nUsing Algorithm BoyerMoore  \n");
		BM_positions = BoyerMooreAll(str2, txt);

		StdOut.print("Pattern1: ");
		StdOut.print(" ");
		StdOut.println(str1 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));
		BM_positions = BoyerMooreAll(str2, txt);

		StdOut.print("\n\nPattern2: ");
		StdOut.print(" ");
		StdOut.println(str2 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));

		BM_positions = BoyerMooreAll(str3, txt);

		StdOut.print("\n\nPattern3: ");
		StdOut.print(" ");
		StdOut.println(str3 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));

		BM_positions = BoyerMooreAll(str4, txt);


		StdOut.print("\n\nPattern4: ");
		StdOut.print(" ");
		StdOut.println(str4 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));

		BM_positions = BoyerMooreAll(str5, txt);


		StdOut.print("\n\nPattern5: ");
		StdOut.print(" ");
		StdOut.println(str5 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));
		BM_positions = BoyerMooreAll(str6, txt);


		StdOut.print("\n\nPattern6: ");
		StdOut.print(" ");
		StdOut.println(str6 + " is found at positions ");
		for (int i = 0; i < BM_positions.size() - 1; i++) {
			System.out.print(BM_positions.get(i) + ",");
		}
		System.out.print(BM_positions.get(BM_positions.size() - 1));

		List<Integer> KMP_positions = new ArrayList<>();
		// KMP search offsets
		StdOut.println("\n\nFor the Algorithm KMP \n");
		KMP_positions = KMPAll(str2, txt);

		StdOut.print("Pattern1: ");
		StdOut.print(" ");
		StdOut.println(str1 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));
		KMP_positions = KMPAll(str2, txt);

		StdOut.print("\n\nPattern2: ");
		StdOut.print(" ");
		StdOut.println(str2 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));

		KMP_positions = KMPAll(str3, txt);

		StdOut.print("\n\nPattern3: ");
		StdOut.print(" ");
		StdOut.println(str3 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));

		KMP_positions = KMPAll(str4, txt);


		StdOut.print("\n\nPattern4: ");
		StdOut.print(" ");
		StdOut.println(str4 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));

		KMP_positions = KMPAll(str5, txt);

		StdOut.print("\n\nPattern5: ");
		StdOut.print(" ");
		StdOut.println(str5 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));

		KMP_positions = KMPAll(str6, txt);

		StdOut.print("\n\nPattern6: ");
		StdOut.print(" ");
		StdOut.println(str6 + " is found at positions ");
		for (int i = 0; i < KMP_positions.size() - 1; i++) {
			System.out.print(KMP_positions.get(i) + ",");
		}
		System.out.print(KMP_positions.get(KMP_positions.size() - 1));

		float start = 0, end = 0;
		StdOut.println("\n\n The Average CPU Time taken for the three algorithms repeated for 100 times\n");
		int cntr = 100;
		start = System.nanoTime();
		while (cntr > 0) {
			BruFpositions = BruteForceMatchAll(str1, txt);
			BruFpositions = BruteForceMatchAll(str2, txt);
			BruFpositions = BruteForceMatchAll(str3, txt);
			BruFpositions = BruteForceMatchAll(str4, txt);
			BruFpositions = BruteForceMatchAll(str5, txt);
			BruFpositions = BruteForceMatchAll(str6, txt);

			cntr--;

		}
		end = System.nanoTime();
		StdOut.println("Average CPU Time for BruteForceMatch: " + (end - start) / 100 + "ns");
		cntr = 100;
		start = System.nanoTime();
		while (cntr > 0) {
			BM_positions = BoyerMooreAll(str1, txt);
			BM_positions = BoyerMooreAll(str2, txt);
			BM_positions = BoyerMooreAll(str3, txt);
			BM_positions = BoyerMooreAll(str4, txt);
			BM_positions = BoyerMooreAll(str5, txt);
			BM_positions = BoyerMooreAll(str6, txt);

			cntr--;

		}
		end = System.nanoTime();
		StdOut.println("Average CPU Time for Boyermoore: " + (end - start) / 100 + "ns");
		cntr = 100;
		start = System.nanoTime();
		while (cntr > 0) {
			KMP_positions = KMPAll(str1, txt);
			KMP_positions = KMPAll(str2, txt);
			KMP_positions = KMPAll(str3, txt);
			KMP_positions = KMPAll(str4, txt);
			KMP_positions = KMPAll(str5, txt);
			KMP_positions = KMPAll(str6, txt);
			cntr--;
		}
		end = System.nanoTime();
		StdOut.println("Average CPU Time for KMP: " + (end - start) / 100 + "ns");

	}

	/*
	 * extracting words from the file and also doing several searches of keys such
	 * as “protein”, “complex”, “PPI”, “prediction” and finding their occurences.
	 */
	void task2() {
		String s = null;
		System.out.println("File Reading.. Protein.txt ");
		In input = new In("Protein.txt");
		while (!input.isEmpty()) {
			s = input.readAll();
		}
		TST<Queue<Integer>> tst = new TST<Queue<Integer>>();
		StringTokenizer strt = new StringTokenizer(s, " ", false);
		Queue<Integer> index;
		int index_pos = 0;
		List<Integer> word_pos;
		System.out.println("TRIE creation started...");
		while (strt.hasMoreTokens()) {
			String key = strt.nextToken().toString();
			word_pos = BruteForceMatchAll(key, s);
			index = new Queue<Integer>();
			index.enqueue(index_pos);
			for (int i : word_pos) {
				index.enqueue(i);
			}
			tst.put(key, index);
			index_pos++;
		}
		System.out.println("Trie created successfully..");
		searchTrie("protein", tst);
		searchTrie("complex", tst);
		searchTrie("PPI", tst);
		searchTrie("prediction", tst);
	}

	/*
	 * 3. Using Jsoup and converting 100 HTML files into Text files and saving them
	 * in a separate folder
	 */
	void task3() {
		dir = new File(absolutePath(File_name()));
		dir_Listing = dir.listFiles();
		if (dir_Listing != null) {
			System.out.println("Converting the files from HTML to TXT");
			for (File specificFile : dir_Listing) {
				writeTotxt(specificFile);
			}
			System.out.println("\nConversion completed");
			System.out.println("\nRefresh the \"Text\" Folder to see the newly created files");
		} else {
			System.out.println("Directory is empty");
		}
	}

	/*
	 * Using Java Regex, we find phone numbers and email addresses in the text files
	 * obtained in the previous task and then writing them into separate text files.
	 */
	void task4() {
		try {
			find_Email();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			find_PhoneNo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Using Java Regex, program that finds Web links (URLs) in a Web file.
	 */
	void task5() {
		try {
			LinkDomain_a();

			linkfolder();

			linkreferences();

			linkdomain_d();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Playground playground = new Playground();
		playground.task1();
	}

	// get brute force matches
	public static List<Integer> BruteForceMatchAll(String pattern, String text) {
		List<Integer> patt_pos = new ArrayList<Integer>();
		int offset_Pos = 0, search_Pos = 0;
		int patt_Length = pattern.length();
		String sub_String;
		while ((offset_Pos <= (text.length() - patt_Length + 1))) {
			sub_String = text.substring(offset_Pos);
			search_Pos = BruteForceMatch.search1(pattern, sub_String);
			if (search_Pos == sub_String.length())
				break;
			patt_pos.add(offset_Pos + search_Pos);
			offset_Pos = offset_Pos + search_Pos + patt_Length;
		}
		if (patt_pos.size() != 0)
			return patt_pos;
		else
			patt_pos.add(search_Pos);
		return patt_pos;
	}

	// Get Boyer Moore Matches
	public static List<Integer> BoyerMooreAll(String pattern, String text) {
		List<Integer> patt_pos = new ArrayList<Integer>();
		int offset_Pos = 0, search_Pos = 0;
		int patt_Length = pattern.length();
		String sub_String;
		BoyerMoore bm = new BoyerMoore(pattern);
		while ((offset_Pos <= (text.length() + patt_Length - 1))) {
			sub_String = text.substring(offset_Pos);
			search_Pos = bm.search(sub_String);
			if (search_Pos == sub_String.length())
				break;
			patt_pos.add(offset_Pos + search_Pos);
			offset_Pos = offset_Pos + search_Pos + patt_Length;
		}
		if (patt_pos.size() != 0)
			return patt_pos;
		else
			patt_pos.add(search_Pos);
		return patt_pos;
	}

	// Get KMP matches
	public static List<Integer> KMPAll(String pattern, String text) {
		List<Integer> patt_pos = new ArrayList<Integer>();
		int offset_Pos = 0, search_Pos = 0;
		int patt_Length = pattern.length();
		String sub_String;
		KMP kmp = new KMP(pattern);
		while ((offset_Pos <= (text.length() - patt_Length + 1))) {
			sub_String = text.substring(offset_Pos);
			search_Pos = kmp.search(sub_String);
			if (search_Pos == sub_String.length())
				break;
			patt_pos.add(offset_Pos + search_Pos);
			offset_Pos = offset_Pos + search_Pos + patt_Length;
		}
		if (patt_pos.size() != 0)
			return patt_pos;
		else
			patt_pos.add(search_Pos);
		return patt_pos;
	}

	// Search Trien in file
	private static void searchTrie(String string, TST<Queue<Integer>> tst) {
		Queue<Integer> q = tst.get(string);
		System.out.println("\nPattern: " + string);
		if (q == null) {
			System.out.println("The Pattern was not found in the file");
		} else {
			System.out.print("IndexNo: " + q.dequeue());
			System.out.println("Occurences: " + q.size());
			System.out.print("\nOffsets: ");
			for (@SuppressWarnings("unused") int i : q) {
				System.out.print(q.dequeue() + "  ");
			}
		}
		System.out.println("\n");
	}

	// writing text to file
	private static void writeTotxt(File filename) {
		txt_name = absolutePath(txtFile()) + fileSeparator() + makeTxtName(filename);
		try {
			FileReader input = new FileReader(filename);
			HTMLtoText parser = new HTMLtoText();
			parser.parse(input);
			input.close();
			String textHTML = parser.getText();
			// Write the text to a file
			BufferedWriter writerTxt = new BufferedWriter(new FileWriter(txt_name));
			writerTxt.write(textHTML);
			writerTxt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get absolute path of a file
	public static String absolutePath(String name) {

		File f = new File(name);
		String absolutePath = f.getAbsolutePath();
		return absolutePath;
	}

	// get File name
	public static String File_name() {
		final String FILE_NAME = "W3C Web Pages";
		return FILE_NAME;
	}

	// get Converted Files path
	public static String txtFile() {
		final String TEXT_FILE = "ConvertedFiles";
		return TEXT_FILE;
	}

	// get File Separator
	public final static String fileSeparator() {
		return File.separator;
	}

	// get name of file
	public static String makeTxtName(File filename) {
		String name = filename.getName();
		String[] temp = name.split("htm");
		return temp[0] + "txt";
	}

	// write searches in file
	public static void writeSearchFiles(String string, String filename) throws IOException {

		String newFileName = absolutePath("Searches") + fileSeparator() + filename;
		// Write the text to a file
		BufferedWriter writerTxt = new BufferedWriter(new FileWriter(newFileName));
		writerTxt.write(string);
		writerTxt.close();

	}

	// finding emails from a file
	private static void find_Email() throws IOException {
		String patt = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,4}\\b";
		// Create a Pattern object
		Pattern p = Pattern.compile(patt, Pattern.CASE_INSENSITIVE);
		HTMLtoText parser = new HTMLtoText();
		String text_HTML = "";
		String s = "";
		File dir = new File(absolutePath(txtFile()));
		File[] dirList = dir.listFiles();
		if (dirList != null) {
			int counter = 1;
			for (File child : dirList) {
				FileReader input = new FileReader(child);
				parser.parse(input);
				input.close();
				text_HTML = parser.getText();
				// Now create matcher object.
				Matcher m = p.matcher(text_HTML);
				while (m.find()) {
					s += "\t " + counter++ + ".) Found email: " + m.group(0) + "\n \t\tFile name: " + child.getName()
							+ "\n";
				}
			}
			writeSearchFiles(s, "emailaddresses.txt");
			System.out.println("The email addresses found were written to "
					+ absolutePath("Searches" + fileSeparator() + "emailaddresses.txt"));
		} else {
			System.out.println("Empty  directory.");
		}
	}

	// finding phone number from file
	private static void find_PhoneNo() throws IOException {
		String patt = "(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}";
		Pattern e = Pattern.compile(patt);
		HTMLtoText parser = new HTMLtoText();
		String text_HTML = "";
		String k = "";
		File dir = new File(absolutePath(txtFile()));
		File[] dirListing = dir.listFiles();
		if (dirListing != null) {
			int counter = 1;
			for (File child : dirListing) {
				FileReader in = new FileReader(child);
				parser.parse(in);
				in.close();
				text_HTML = parser.getText();
				// Now create matcher object.
				Matcher m = e.matcher(text_HTML);
				while (m.find()) {
					k += "\t " + counter++ + ".) Found phone number: " + m.group(0) + "\n\t\t File name: "
							+ child.getName() + "\n";
				}

			}
			writeSearchFiles(k, "phonenumber.txt");
			System.out.println("The Phone numbers found were written to "
					+ absolutePath("Searches" + fileSeparator() + "phonenumber.txt"));
		} else {
			System.out.println("Empty directory.");
		}

	}

	// Link pattern domain
	private static void LinkDomain_a() throws IOException {
		// pattern for finding w3.org
		String patt = "(w3.org)";
		// Create a Pattern object
		Pattern p = Pattern.compile(patt);
		// Parsing the HTML File and searching for the pattern supplied above.
		HTMLtoText parser = new HTMLtoText();
		String text_HTML = "";
		String v = "";
		File dir_file = new File(absolutePath(File_name()));
		File[] dirList = dir_file.listFiles();
		System.out.println("A)\n Links with domain \"w3.org\":\n");
		if (dirList != null) {
			int counterId = 1;
			for (File child : dirList) {
				FileReader input = new FileReader(child);
				parser.parse(input);
				input.close();
				text_HTML = parser.getText();
				// Now create matcher object.
				Matcher mat = p.matcher(text_HTML);
				while (mat.find()) {
					v += "\t " + counterId++ + ". domain: " + mat.group(0) + "\n\t\t File name: " + child.getName()
							+ "\n";
				}

			}
			writeSearchFiles(v, "Task_5a.txt");
			System.out
					.println("File Location: " + absolutePath("SearchFiles" + fileSeparator() + "Task_5a.txt") + "\n");
		} else {
			System.out.println("Empty Directory .");
		}

	}

	// linking folder
	private static void linkfolder() throws IOException {

		String patt = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|](/){1}[-a-zA-Z0-9+&@#/%?=~_|!:,.;]";
		// Create a Pattern object
		Pattern p = Pattern.compile(patt);
		HTMLtoText parser = new HTMLtoText();
		String text_HTML = "";
		String s = "";
		File dir_file = new File(absolutePath(File_name()));
		File[] dirList = dir_file.listFiles();
		System.out.println(" B)\n List of links that contain folders:\n");
		if (dirList != null) {
			int counter = 1;
			for (File child : dirList) {
				FileReader in = new FileReader(child);
				parser.parse(in);
				in.close();
				text_HTML = parser.getText();
				// Now create matcher object.
				Matcher m = p.matcher(text_HTML);
				while (m.find()) {
					s += "\t " + counter++ + ". Link: " + m.group(0) + "\n\t\t File name: " + child.getName() + "\n";
				}
			}
			writeSearchFiles(s, "Task_5b.txt");
			System.out
					.println("File Location: " + absolutePath("SearchFiles" + fileSeparator() + "Task_5b.txt") + "\n");
		} else {
			System.out.println("Empty directory.");
		}

	}

	// Linking references
	private static void linkreferences() throws IOException {

		String pattern = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|](/){1}[#]{1}[-a-zA-Z0-9+&@#/%?=~_|!:,.;]+";
		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		HTMLtoText parser = new HTMLtoText();
		String textHTML = "";
		String t = "";
		File dir = new File(absolutePath(File_name()));
		File[] directoryListing = dir.listFiles();
		System.out.println(" C)\n Links that contain references:\n");
		if (directoryListing != null) {
			int counter = 1;
			for (File child : directoryListing) {
				FileReader in = new FileReader(child);
				parser.parse(in);
				in.close();
				textHTML = parser.getText();
				// Now create matcher object.
				Matcher m = r.matcher(textHTML);
				while (m.find()) {
					t += "\t " + counter++ + ".) Link: " + m.group(0) + "\n\t\t File name: " + child.getName() + "\n";
				}
			}
			writeSearchFiles(t, "Task_5c.txt");
			System.out
					.println("File Location: " + absolutePath("SearchFiles" + fileSeparator() + "Task_5c.txt") + "\n");
		} else {
			System.out.println("Directory is empty.");
		}

	}

	// Linking domains
	private static void linkdomain_d() throws IOException {

		String pattern = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*(org|com|net){1}";

		// Create a Pattern object
		Pattern p = Pattern.compile(pattern);

		String s = "";
		HTMLtoText parser = new HTMLtoText();
		String text_HTML = "";
		File dir = new File(absolutePath(File_name()));
		File[] dirListing = dir.listFiles();
		System.out.println(" D)\n Domain with .net, .com, .org:\n");
		if (dirListing != null) {

			int count = 1;
			for (File child : dirListing) {
				FileReader input = new FileReader(child);
				parser.parse(input);
				input.close();
				text_HTML = parser.getText();
				// Now create matcher object.
				Matcher mat = p.matcher(text_HTML);
				while (mat.find()) {
					s += "\t " + count++ + ".) domain: " + mat.group(0) + "\n\t\t File name: " + child.getName() + "\n";
				}
			}

			writeSearchFiles(s, "Task_5d.txt");
			System.out
					.println("File Location : " + absolutePath("SearchFiles" + fileSeparator() + "Task_5d.txt") + "\n");

		} else {
			System.out.println("empty directory.");
		}

	}

}
