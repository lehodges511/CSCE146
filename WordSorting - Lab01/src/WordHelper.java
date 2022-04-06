public class WordHelper {
    public static String vowels = "aeiouy";

    public static String[] sortByVowels(String[] words){
        Integer[] nVowels = new Integer[words.length];
        String [] a = new String[words.length];
        for(int i=0; i<words.length;i++){
            a[i] = words [i];
            int count = 0;
            for(int j=0; j<words[i].length();j++){
                String temp = Character.toString(words[i].charAt(j));
                temp.toLowerCase();
                if(vowels.contains(temp)){
                    count++;
                }
            }
            nVowels[i]=count;
        }
        for(int i=0; i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(nVowels[j]>nVowels[j+1]){
                    String temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        return a;

    }
}
