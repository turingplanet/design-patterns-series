class RemoteImage:
    def __init__(self, url):
        self.url = url

    def display_image(self):
        print("Displaying image from URL:", self.url)
        # Code to load and display the image


def main():
    image = RemoteImage("http://example.com/image.jpg")
    image.display_image()


if __name__ == "__main__":
    main()

