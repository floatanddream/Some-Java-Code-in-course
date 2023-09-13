package Translation;
import java.util.*;
public class Translate {
    String Chinese;
    String English;
    Translate(String Chs,String Eng)
    {
        this.Chinese=Chs;
        this.English=Eng;
    }

    public String Translation()
 {
     return String.format(English+"的中文意思为:"+Chinese);
 }
}
