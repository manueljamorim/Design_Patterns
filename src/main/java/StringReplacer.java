public class StringReplacer implements StringTransformer{
    private char c1, c2;

    public StringReplacer(char c1,char c2){
        this.c1 = c1;
        this.c2 = c2;
    }
    public void execute(StringDrink drink){
        String previous = drink.getText();
        StringBuilder text_builder = new StringBuilder();

        for(int i = 0;i<previous.length();i++){
            char c = previous.charAt(i);
            if(c==c1){
                c = c2;
            }
            text_builder.append(c);
        }
        drink.setText(text_builder.toString());

    }

}
