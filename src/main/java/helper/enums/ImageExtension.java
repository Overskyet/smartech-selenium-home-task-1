package helper.enums;

public enum ImageExtension {
    PNG (".png"),
    JPG (".jpg");

    private final String name;

    ImageExtension(String ext) {
        name = ext;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
