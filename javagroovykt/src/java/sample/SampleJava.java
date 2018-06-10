import sample.VoKotlin;

public class SampleJava {
    public static void main(String[] v) {
        VoKotlin vo = new VoKotlin("nao", 10);
        System.out.println(vo.getName());
        System.out.println(vo.getAge());
    }
}