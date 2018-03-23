
@JavaUser
public class GajewskiUser implements JavaObserver {
    @Override
    public void onMessage(String message) {
        System.out.println("Co my to robimy? " + message);
    }
}
