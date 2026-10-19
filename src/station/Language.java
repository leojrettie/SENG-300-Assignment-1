package station;


public enum Language {
    EN("English"),  //English  
    FR("Français"), //French
    ES("Español"),  //Spanish
    ZH("中文"),     //Chinese Simplified
    AR("الةعربي"), //Arabic
    DE("Deutsch"),  //German
    HI("हिंदी"),     //Hindi
    JA("日本語"),   //Japanese
    RU("Русский"); //Russian

private final String displayName;


Language(String displayName){
    this.displayName = displayName;
}

public String getDisplayName() {return displayName;}

}
