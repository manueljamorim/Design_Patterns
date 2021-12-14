public class StringCaseChanger implements StringTransformer{
    public void execute(StringDrink drink){
        String previous = drink.getText();
        StringBuilder text_builder = new StringBuilder();

        for(int i = 0;i<previous.length();i++){
            char c = previous.charAt(i);
            if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
            }else{
                c= Character.toLowerCase(c);
            }
            text_builder.append(c);
        }

        drink.setText(text_builder.toString());
    }
}
