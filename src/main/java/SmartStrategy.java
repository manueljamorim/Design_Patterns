import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    List<StringDrink> backupdrink = new ArrayList<>();
    List<StringRecipe> backuprecipe = new ArrayList<>();
    List<StringBar> backupbar = new ArrayList<>();


    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) { recipe.mix(drink); }
        else {
            backupdrink.add(drink);
            backuprecipe.add(recipe);
            backupbar.add(bar);

        }
    }
    public void happyHourStarted(StringBar bar) {
        for(int i=0; i<backupbar.size();i++){
            if(backupbar.isEmpty()) break;

            if(backupbar.get(i)==bar){
                wants(backupdrink.get(i), backuprecipe.get(i), backupbar.get(i));
                backupdrink.remove(i);
                backuprecipe.remove(i);
                backupbar.remove(i);
                i--;
            }
        }
    }
    public void happyHourEnded(StringBar bar) {
    }

}
