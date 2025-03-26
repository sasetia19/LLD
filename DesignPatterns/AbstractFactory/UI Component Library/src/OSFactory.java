public class OSFactory {
    public static IOS getOsFactory(String os){
        switch (os){
            case "windows":
                return new Windows();
            case "macos":
                return new MacOs();
            default:
                return null;
        }
    }
}
