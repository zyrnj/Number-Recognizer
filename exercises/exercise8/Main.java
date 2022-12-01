public class Main {
    public static void main(String[] args) throws Exception {
        parse p=new parse();
        p.parseXml();
        p.parseJson();
        p.addJsonElement();
        p.parseJson();
        p.addXmlElement();
        p.parseXml();
    }
}
