public class StringInverter implements StringTransformer{
    public void execute(StringDrink drink){
        StringBuilder text_builder = new StringBuilder();
        text_builder.append(drink.getText());
        text_builder.reverse();
        drink.setText(text_builder.toString());
    }

}
