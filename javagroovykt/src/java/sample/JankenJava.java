import jp.gr.java_conf.org.nsgeorge.janken.*;

public class JankenJava {
    public static void main(String[] v) {
        Player user = JankenUtility.INSTANCE.createUser("test", Gender.Male, Hand.Choki, 20);
        Player npc = JankenUtility.INSTANCE.createNpc();
        JankenMachine machine = new JankenMachine(user, npc);
        machine.run();
    }
}