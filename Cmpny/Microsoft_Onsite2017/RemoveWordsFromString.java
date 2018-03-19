package MS.Onsite2017;

/**
 * Created by wtnwi on 2/22/2017.
 */
public class RemoveWordsFromString {
    String removeWordsStartingWiethB(char [] a){
        int size=0, r= 0;
        while(r<a.length){
            if(r<a.length&&a[r+1]=='B'&&(r==0||a[r-1]==' ')){
                    while(r<a.length&&a[r]!=' '){r++;}//r:' '
                    r++;//r:next word
            } else{
                a[size++]= a[r++];
            }
        }
        String res = String.valueOf(a);
        return res.substring(0,size);
    }
}
