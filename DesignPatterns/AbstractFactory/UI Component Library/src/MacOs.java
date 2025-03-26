public class MacOs implements IOS{
    private IButton button;

    public MacOs(){
        button = new MacButton();
    }

    @Override
    public void renderUI() {
        button.render();
    }
}
