public class SmartStrategy implements OrderingStrategy{
    StringDrink backupdrink;
    StringRecipe backuprecipe;
    StringBar backupbar;
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) { recipe.mix(drink); }
        else {
            backupdrink = drink;
            backuprecipe = recipe;
            backupbar = bar;

        }
    }
    public void happyHourStarted(StringBar bar) {
        if (backupbar == bar)
            wants(backupdrink,backuprecipe,backupbar);
    }
    public void happyHourEnded(StringBar bar) {
    }

}
