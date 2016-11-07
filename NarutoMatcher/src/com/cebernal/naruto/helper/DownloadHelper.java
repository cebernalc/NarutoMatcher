/**
 * DownloadHelper.java
 * 
 * Created on Nov 11, 2016, 4:17:18 PM
 * 
 */
package com.cebernal.naruto.helper;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;

/**
 * {Insert class description here}
 *
 * @author Carlos Bernal
 * @since Nov 11, 2016
 */
public class DownloadHelper {

	public static void main(String[] args) {
		String rootUrl = "http://cdnnarutoen-gmt.oasgames.com/EN_NarutoAlpha1.00Build300/assets/battle/role/head_176_68/";
		String output = "/Users/charlyb07/git/NarutoMatcher/NarutoMatcher/src/com/cebernal/naruto/resources/images";
		// for (Entry<String, Ninja> ninja :
		// DatabaseParser.getInstance().getNinjas().entrySet()) {
		// try {
		// downloadImage(rootUrl, ninja.getKey(),
		// output);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		// Crop images
		cropImages(output);

	}

	/**
	 * @param output
	 * @return
	 */
	private static BufferedImage cropImages(String output) {

		File folder = new File(output);

		for (File filePath : folder.listFiles()) {
			System.out.println(filePath.getName());
			if (filePath.getName().endsWith(".png")) {
				try {
					BufferedImage originalImgage = ImageIO.read(filePath);

					BufferedImage subImgage = originalImgage.getSubimage(0, 0, 100, originalImgage.getHeight());
					ImageIO.write(subImgage, "png", filePath);
				} catch (IOException e) {
					return null;
				}
			}
		}
		return null;
	}

	public static void downloadImage(String sourceUrl, String id, String targetDirectory)
			throws MalformedURLException, IOException, FileNotFoundException {
		URL imageUrl = new URL(sourceUrl + id + ".png");
		try (InputStream imageReader = new BufferedInputStream(imageUrl.openStream());
				OutputStream imageWriter = new BufferedOutputStream(
						new FileOutputStream(targetDirectory + File.separator + id + ".png"));) {
			int readByte;

			while ((readByte = imageReader.read()) != -1) {
				imageWriter.write(readByte);
			}
		}
	}
}
