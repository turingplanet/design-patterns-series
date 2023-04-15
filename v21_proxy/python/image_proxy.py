class RemoteImage:
    def __init__(self, url):
        self.url = url

    def display_image(self):
        print("Displaying image from URL:", self.url)
        # Code to load and display the image


class ImageProxy:
    def __init__(self, url):
        self.url = url
        self.image = None

    def display_image(self):
        if self.image is None:
            print("New image from URL:", self.url)
            self.image = RemoteImage(self.url)
        self.image.display_image()


def main():
    image_proxy = ImageProxy("http://example.com/image.jpg")
    image_proxy.display_image()  # Image is loaded from the server
    image_proxy.display_image()  # Image is loaded from the cache


if __name__ == "__main__":
    main()

