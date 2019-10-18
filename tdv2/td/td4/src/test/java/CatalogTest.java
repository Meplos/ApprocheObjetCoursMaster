import org.junit.Test;

import fr.ubordeaux.ao.CatalogImpl;
import fr.ubordeaux.ao.Price;
import fr.ubordeaux.ao.Reference;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogTest {

    @Test
    public void UpperControlTest(){
        Pattern pattern = Pattern.compile("[a-z]{3,10}");
        

        String failName = "qzfeq";
        CatalogImpl fail = new CatalogImpl(failName);
        Matcher matcher = pattern.matcher(fail.getName());
        assertFalse("name test", matcher.matches());
    }

    @Test
    public void HigherLenthTest() {
        String failName = "qpzoefkqqzefqz";
        CatalogImpl fail = new CatalogImpl(failName);
        assertFalse("Size up than 10", fail.size() < 10 
                        && fail.size() > 3);
    }



}
