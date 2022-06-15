
public class Program {

    public static void main(String[] args) {
        
        DictionaryOfManyTranslations dictionary = new DictionaryOfManyTranslations();
        dictionary.add("lie", "maata");
        dictionary.add("lie", "valehdella");

        dictionary.add("bow", "jousi");
        dictionary.add("bow", "kumartaa");

        System.out.println(dictionary.translate("lie"));
        dictionary.remove("bow");
        System.out.println(dictionary.translate("bow"));
        
        System.out.println("-------------");
        DictionaryOfManyTranslations d = new DictionaryOfManyTranslations();
        d.add("monkey", "apina");
        d.add("monkey", "apfe");
        d.add("monkey", "apfe");
        d.add("cheese", "juusto");
        d.add("milk", "maito");
        System.out.println(d.translate("potato"));
        System.out.println(d.translate("monkey"));
        System.out.println("-------------");
    }
}
