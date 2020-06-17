package main.java.vista.util;

public class ComboBoxItem {
	
    private String valueVisible;
    private String key;

    public ComboBoxItem(String valueVisible, String key){
        this.valueVisible = valueVisible;
        this.key = key;
    }

    @Override
    public String toString(){
        return valueVisible;
    }

    public String getValueVisible(){
        return valueVisible;
    }

    public String getKey(){
        return key;
    }
}
