public class Windows implements IOS {

    private IButton button;

    public Windows(){
        button = new WindowsButton();
    }

    @Override
    public void renderUI() {
        button.render();
    }
}
