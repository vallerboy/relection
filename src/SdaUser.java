
@JavaUser
public class SdaUser implements JavaObserver {
    @Override
    public void onMessage(String message) {
        System.out.println("Szklanki sa nie pomyte!!!!!!!!");
        System.out.println("I zmywarka nie dziala!!! : " + message);
    }
}
