package Server;
//Bgoo
//作者:陶冶
//功能：实现了随机选取英文单词和随机选取中文单词两种handler
//
import java.io.*;
import java.net.*;
import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.*;

public class HiWord {
	public String Geten(String enword) throws IOException {
		// 建立指向WordNet词典目录的URL。
		String wnhome = System.getenv("WNHOME");
		String path = wnhome + File.separator + "dict";
		URL url = new URL("file", null, path);

		// 建立词典对象并打开它。
		IDictionary dict = new Dictionary(url);
		dict.open();
		String gloss = "";
		// String tmp="";
		boolean you = true;
		// 查询money这个词的第一种意思。POS后面的参数表示要选的哪种词性的含义
		IIndexWord idxWord = dict.getIndexWord(enword, POS.ADJECTIVE);
		// IWordID wordID ="WID-00238420-A-??-beautiful";

		String part1 = "";
		try {
			@SuppressWarnings("unused")
			IWordID wordID1 = (IWordID) idxWord.getWordIDs().get(0);

		} catch (NullPointerException e) {
			you = false;
		}
		if (you == true) {
			part1 = part1 + "\n" + ("形容词====================================");
			IWordID wordID = (IWordID) idxWord.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);

			part1 = part1 + "\n" + ("Gloss = " + word.getSynset().getGloss());

			for (int i = 1; i < idxWord.getWordIDs().size(); i++) {

				IWordID wordID2 = (IWordID) idxWord.getWordIDs().get(i);
				IWord word2 = dict.getWord(wordID2);

				gloss = gloss + "\n" + (i) + "." + word2.getSynset().getGloss();
			}
			part1 = part1 + "\n" + (gloss);
		}

		you = true;
		
		IIndexWord idxWord1 = dict.getIndexWord(enword, POS.ADVERB);
		try {
			@SuppressWarnings("unused")
			IWordID wordID1 = (IWordID) idxWord1.getWordIDs().get(0);

		} catch (NullPointerException e) {
			you = false;
		}
		if (you == true) {
			part1 = part1 + "\n" + ("副词====================================");
			IWordID wordID = (IWordID) idxWord1.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);

			part1 = part1 + "\n" + ("Gloss = " + word.getSynset().getGloss());

			for (int i = 1; i < idxWord1.getWordIDs().size(); i++) {

				IWordID wordID2 = (IWordID) idxWord1.getWordIDs().get(i);
				IWord word2 = dict.getWord(wordID2);
				part1 = part1 + "\n"
						+ ((i + 1) + "." + word2.getSynset().getGloss());
			}
		} else {

		}
		you = true;
		
		IIndexWord idxWord2 = dict.getIndexWord(enword, POS.NOUN);
		try {
			@SuppressWarnings("unused")
			IWordID wordID1 = (IWordID) idxWord2.getWordIDs().get(0);

		} catch (NullPointerException e) {
			you = false;
		}
		if (you == true) {
			part1 = part1 + "\n" + ("名词====================================");
			IWordID wordID = (IWordID) idxWord2.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);

			part1 = part1 + "\n" + ("Gloss = " + word.getSynset().getGloss());

			for (int i = 1; i < idxWord2.getWordIDs().size(); i++) {

				IWordID wordID2 = (IWordID) idxWord2.getWordIDs().get(i);
				IWord word2 = dict.getWord(wordID2);
				part1 = part1 + "\n"
						+ ((i + 1) + "." + word2.getSynset().getGloss());
			}
		} else {

		}
		you = true;
		
		IIndexWord idxWord3 = dict.getIndexWord(enword, POS.VERB);
		try {
			@SuppressWarnings("unused")
			IWordID wordID1 = (IWordID) idxWord3.getWordIDs().get(0);

		} catch (NullPointerException e) {
			you = false;
		}
		if (you == true) {
			part1 = part1 + "\n" + ("动词====================================");
			IWordID wordID = (IWordID) idxWord3.getWordIDs().get(0);
			IWord word = dict.getWord(wordID);

			part1 = part1 + "\n" + ("Gloss = " + word.getSynset().getGloss());

			for (int i = 1; i < idxWord3.getWordIDs().size(); i++) {

				IWordID wordID2 = (IWordID) idxWord3.getWordIDs().get(i);
				IWord word2 = dict.getWord(wordID2);
				part1 = part1 + "\n"
						+ ((i + 1) + "." + word2.getSynset().getGloss());
			}
		} else {

		}
		return (part1);
	}
}
