import java.io.*;
import java.text.Collator;
import java.util.*;

  public class Alphabetizer {
	  
	public static List<String> convertStringInAlphabaticOrder(ArrayList<String> listOfWords) {  
	  List<String> list = new ArrayList<String>();

	  // This is removing all the non alphabetic characters from the list of words and adding the words containing only alphabets in a new arraylist
		  
      for (int i = 0; i < listOfWords.size(); i++) {
		String wordContainingOnlyAlphabeticCharacters  = listOfWords.get(i);
		wordContainingOnlyAlphabeticCharacters = wordContainingOnlyAlphabeticCharacters.replaceAll("[^A-za-z ]", "");
		wordContainingOnlyAlphabeticCharacters = wordContainingOnlyAlphabeticCharacters.replaceAll("\\s", "");
		list.add(wordContainingOnlyAlphabeticCharacters);
	  }
      
      List<String> result = new ArrayList<String>();
      
      Collator col = Collator.getInstance(new Locale("en", "EN"));
      
      // This will sort the words in alphabetic order in the list in a case insensitive manner
      for(int i = 0; i < list.size(); i++) { 
        String sortedWord = list.get(i);
        String[] s1= sortedWord.split("");
        Arrays.sort(s1, col);
        String sortedString = "";
        for (int j = 0; j < s1.length; j++) {
          sortedString += s1[j];
        }
        result.add(sortedString);    
      }
     
	  return result;      
    }  

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the number of words in the list: ");
	  int numberOfWords = input.nextInt();
	  System.out.println();
	  input.nextLine();
	  System.out.println("Please enter the actual words in the list: ");
	  ArrayList<String> listOfWords = new ArrayList<String>();
	  for (int i = 0; i < numberOfWords; i++) {
	    listOfWords.add(input.nextLine());
	  }	
	
	  List<String> result = new ArrayList<String>();
	  result = convertStringInAlphabaticOrder(listOfWords);
	  System.out.println();
	  System.out.print("The strings with the characters in alphabetical order are as follows: " + result);
	  input.close();
	}
  }
