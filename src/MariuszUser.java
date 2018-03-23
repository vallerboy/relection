@JavaUser
public class MariuszUser implements JavaObserver {
    @Override
    public void onMessage(String message) {
        System.out.println("DUPA: " + message);
    }
}
