package v21_proxy.java;

class  RemoteImage {
    private String url;

    public RemoteImage(String url) {
        this.url = url;
    }

    public void displayImage() {
        System.out.println("Displaying image from URL: " + url);
        // Code to load and display the image
    }
}

public class ImageProxy {
    private String url;
    private RemoteImage image;

    public ImageProxy(String url) {
        this.url = url;
        this.image = null;
    }

    public void displayImage() {
        if (image == null) {
            System.out.println("New image from URL: " + url);
            image = new RemoteImage(url);
        }
        image.displayImage();
    }

    public static void main(String[] args) {
        ImageProxy imageProxy = new ImageProxy("http://example.com/image.jpg");
        imageProxy.displayImage(); // Image is loaded from the server
        imageProxy.displayImage(); // Image is loaded from the cache
    }
}
