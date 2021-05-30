public class main_class {
    public static void main(String[] args) {
        string_operations o =new string_operations();
        String longer = o.better_string("long","short",(s1,s2)-> s1.length()>s2.length() );
        System.out.println(longer);
        String s ="ab";
        if (o.check(s))
            System.out.println("all letters");
        else
            System.out.println("Not all letters");




    }
}
