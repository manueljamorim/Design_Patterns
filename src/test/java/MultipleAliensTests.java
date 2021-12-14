import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MultipleAliensTests {
    private StringRecipe getRecipe() {
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        List<StringTransformer> transformers = new ArrayList<>();
        transformers.add(si);
        transformers.add(cc);
        transformers.add(sr);
        StringRecipe recipe = new StringRecipe(transformers);
        return recipe;
    }

    @Test
    public void ferengiAlreadyOpened() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        FerengiAlien client = new FerengiAlien();
        // Recipe is ordered immediately
        stringBar.startHappyHour();
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void ferengiStartClosed() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        FerengiAlien client = new FerengiAlien();
        stringBar.addObserver(client); // this is important!
        client.wants(drink, recipe, stringBar);
        assertEquals("AbCd-aBcD", drink.getText());
        // Recipe is only ordered here
        stringBar.startHappyHour();
        assertEquals("dCbX-DcBa", drink.getText());
    }

    @Test
    public void romulan() {
        StringBar stringBar = new StringBar();
        StringDrink drink = new StringDrink("AbCd-aBcD");
        StringRecipe recipe = getRecipe();
        RomulanAlien client = new RomulanAlien();
        // Recipe is ordered immediately
        client.wants(drink, recipe, stringBar);
        assertEquals("dCbX-DcBa", drink.getText());
    }

}
