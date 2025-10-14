class Pair
{
    String word;
    int level;
    Pair(String w,int l)
    {
        word = w;
        level = l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> available = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            available.add(wordList.get(i));
        }
        if(!available.contains(endWord)) return 0; // End word is not there 
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            Pair curr = q.poll();
            String word = curr.word;
            int level = curr.level;

            if(word.equals(endWord)) return level;

            for(int i=0;i<word.length();i++)
            {
                char[] chArr = word.toCharArray();
                for(char ch='a';ch<='z';ch++)
                {
                    chArr[i] = ch;
                    String newWord = new String(chArr);
                    if(available.contains(newWord))
                    {
                        q.offer(new Pair(newWord,level+1));
                        available.remove(newWord);
                    }
                }
            }

        }
        return 0;
    }
}
