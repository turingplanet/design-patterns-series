package v21_proxy.java;

public class RemoteImage {
    private String url;

    public RemoteImage(String url) {
        this.url = url;
    }

    public void displayImage() {
        System.out.println("Displaying image from URL: " + url);
        // Code to load and display the image
    }

    public static void main(String[] args) {
        RemoteImage image = new RemoteImage("http://example.com/image.jpg");
        image.displayImage();
    }
}
