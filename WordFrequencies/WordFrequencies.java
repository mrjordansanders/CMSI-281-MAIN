import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WordFrequencies extends java.lang.Object{
    public static HashMap<String, Long> generateFrequencyList() throws java.io.IOException {
        HashMap<String, Long> wordsFrequencyMap = new HashMap<String, Long>();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = removePunctuation(line);
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
                if (!wordsFrequencyMap.containsKey(token.toUpperCase())) {
                    wordsFrequencyMap.put(token.toUpperCase(), 1L);
                } else {
                    long count = wordsFrequencyMap.get(token.toUpperCase());
                    wordsFrequencyMap.put(token.toUpperCase(), count + 1L);
                }
            }
        }
        return wordsFrequencyMap;
    }

    public static HashMap<String, Long> generateFrequencyListLowerCase() throws java.io.IOException {
        HashMap<String, Long> wordsFrequencyMap = new HashMap<String, Long>();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = removePunctuation(line);
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
                if (!wordsFrequencyMap.containsKey(token.toLowerCase())) {
                    wordsFrequencyMap.put(token.toLowerCase(), 1L);
                } else {
                    long count = wordsFrequencyMap.get(token.toLowerCase());
                    wordsFrequencyMap.put(token.toLowerCase(), count + 1L);
                }
            }
        }
        return wordsFrequencyMap;
    }


    public static void main(java.lang.String[] args){
        ArrayList<String> j = new ArrayList<String>(Arrays.asList(args));
        if(j.contains("-c") && j.contains("-s")){
            try {
                HashMap<String, Long> freqMap = generateFrequencyListLowerCase();

                for (String key : freqMap.keySet()) {
                    System.out.println(key);    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(j.contains("-s")){
            try {
                HashMap<String, Long> freqMap = generateFrequencyListLowerCase();

                for (String key : freqMap.keySet()) {
                    System.out.println(key+"\t"+freqMap.get(key));    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(j.contains("-c")){
            try {
                HashMap<String, Long> freqMap = generateFrequencyList();

                for (String key : freqMap.keySet()) {
                    System.out.println(key);    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                HashMap<String, Long> freqMap = generateFrequencyList();

                for (String key : freqMap.keySet()) {
                    System.out.println(key+"\t"+freqMap.get(key));    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String removePunctuation(String line) {
        line = line.replaceAll("-", "");
        line = line.replaceAll("'", "");
        line = line.replaceAll("[^a-zA-Z]", " ");
        return line;
  }
}
