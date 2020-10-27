package com.zensar.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class ImageOperationsUtility {

	public static String uploadImage(MultipartFile image) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String imageLocationPath = null;
		
		if (isImageExtensionValid(image)) {
			try {
				
				//
				//Original Path
				
				//E:\Zensar_Training\Java_Spring_WorkSpace\Auction_Web_Service\src\main\resources\images
				//
				String path2=timeStamp +new Random().nextInt(1000)+ image.getOriginalFilename();
				String path="E:\\Zensar_Training\\Jars for auction\\frontend\\Auction Fron End\\src\\assets\\img\\images\\";
				File imageFile = new File(path+path2);
				System.out.println("New File Path...testing....."+imageFile);
				imageFile.createNewFile();
				FileOutputStream fout = new FileOutputStream(imageFile);
				fout.write(image.getBytes());
				fout.close();
				System.out.println("Image location path :- " + path2);
				return path2;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "Extension of image is not correct";
	}

	/* Method to delete the image if product is not kept for sell */
	public static boolean deleteImage(String imagePath) {

		File file = new File(imagePath);
		if (file.delete()) {
			System.out.println("File deleted successfully");
			return true;
		} else {
			System.out.println("Failed to delete the file");
			return false;
		}
	}

	/* Method to check whether file extension is correct or not */
	public static boolean isImageExtensionValid(MultipartFile image) {
		String extension = "";
		String imageName = image.getOriginalFilename();
		int imagePathLastIndex = imageName.length() - 1;
		int imagePathFourthLastIndex = imageName.length() - 5;
		int check = 0;
		for (int i = imagePathFourthLastIndex; i <= imagePathLastIndex; i++) {
			if (imageName.charAt(i) == '.') {
				check = 1;
			}
			if (check == 1) {
				extension = extension.concat(imageName.substring(i, i + 1));
			}
		}
		if (extension.equals(".jpeg") || extension.equals(".png") || extension.equals(".jpg"))
			return true;
		return false;
	}
}