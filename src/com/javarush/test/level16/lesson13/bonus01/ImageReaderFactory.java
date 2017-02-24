package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Admin on 19.02.2017.
 */
public class ImageReaderFactory
{
  public static ImageReader getReader(ImageTypes iT) {
      ImageReader iR = null;
      if(iT == ImageTypes.BMP) {
          return new BmpReader();
      } else if(iT == ImageTypes.JPG) {
          return new JpgReader();
      } else if(iT == ImageTypes.PNG) {
          return new PngReader();
      } else {
          throw new IllegalArgumentException("Неизвестный тип картинки");
      }
  }
}
