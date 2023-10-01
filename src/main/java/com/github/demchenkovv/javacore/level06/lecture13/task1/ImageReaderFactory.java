package com.github.demchenkovv.javacore.level06.lecture13.task1;

import com.github.demchenkovv.javacore.level06.lecture13.task1.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) {
        ImageReader reader;
        if (imageTypes == ImageTypes.JPG) {
            reader = new JpgReader();
        } else if (imageTypes == ImageTypes.PNG) {
            reader = new PngReader();
        } else if (imageTypes == ImageTypes.BMP) {
            reader = new BmpReader();
        } else
            throw new IllegalArgumentException("Неизвестный тип картинки");

        return reader;
    }
}
