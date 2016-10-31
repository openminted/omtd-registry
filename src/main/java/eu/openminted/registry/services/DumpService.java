package eu.openminted.registry.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.openminted.registry.core.controllers.Utils;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.domain.ResourceType;
import eu.openminted.registry.core.service.ResourceService;
import eu.openminted.registry.core.service.ResourceTypeService;
import eu.openminted.registry.core.service.ServiceException;


@Service("dumpService")
public class DumpService {


	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ResourceTypeService resourceTypeService;

	
	public File bringAll(){
		
	
		String parentName = "/home/user/tmp/dump-testCase";
		File masterDirectory = new File(parentName);

		try {
			Files.createDirectory(masterDirectory.toPath(), PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		List<ResourceType> resourceTypes = new ArrayList<ResourceType>();
		List<Resource> resources = new ArrayList<Resource>();
		
		resourceTypes = resourceTypeService.getAllResourceType();
		List<File> fileList = new ArrayList<File>();
		for(int i=0; i<resourceTypes.size();i++){
			if(!resourceTypes.get(i).getName().equals("user")){
				resources = resourceService.getResource(resourceTypes.get(i).getName());
				createDirectory(parentName+"/"+resourceTypes.get(i).getName(), resources);
				try {
					File tempFile = new File(parentName+"/"+resourceTypes.get(i).getName()+".json");
					Path filePath = Files.createFile(tempFile.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
					FileWriter file = new FileWriter(filePath.toFile());
					file.write(Utils.objToJson(resourceTypes.get(i)));
					file.flush();
					file.close();
				} catch (IOException e) {
					new ServiceException("Failed to create schema-file for "+ resourceTypes.get(i).getName());
				}
			}
		}
		File tempDir = new File(parentName);
		getAllFiles(tempDir,fileList);
		File masterZip = new File(parentName+"/final.zip");		
		writeZipFile(masterZip, fileList);
		try {
			File tempFile = new File(parentName+"/dump-"+getCurrentDate()+".zip");
			Files.createFile(tempFile.toPath(), PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
			masterZip.renameTo(tempFile);
//			return tempFile;
		} catch (IOException e1) {
			
		}
		return masterZip;
	}
	
	public File bringResourceType(String resourceType){
		
		
		String parentName = "/home/user/tmp/dump-testCase";
		File masterDirectory = new File(parentName);

		try {
			Files.createDirectory(masterDirectory.toPath(), PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ResourceType resourceTypes = new ResourceType();
		List<Resource> resources = new ArrayList<Resource>();
		
		resourceTypes = resourceTypeService.getResourceType(resourceType);
		List<File> fileList = new ArrayList<File>();
		if(resourceTypes!=null){
				resources = resourceService.getResource(resourceTypes.getName());
				createDirectory(parentName+"/"+resourceTypes.getName(), resources);
				try {
					File tempFile = new File(parentName+"/"+resourceTypes.getName()+".json");
					Path filePath = Files.createFile(tempFile.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
					FileWriter file = new FileWriter(filePath.toFile());
					file.write(Utils.objToJson(resourceTypes));
					file.flush();
					file.close();
				} catch (IOException e) {
					new ServiceException("Failed to create schema-file for "+ resourceTypes.getName());
				}
		}
		File tempDir = new File(parentName);
		getAllFiles(tempDir,fileList);
		File masterZip = new File(parentName+"/final.zip");		
		writeZipFile(masterZip, fileList);
		try {
			File tempFile = new File(parentName+"/dump-"+getCurrentDate()+".zip");
			Files.createFile(tempFile.toPath(), PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
			masterZip.renameTo(tempFile);
//			return tempFile;
		} catch (IOException e1) {
			
		}
		return masterZip;
	}
	
	public static void writeZipFile(File directoryToZip, List<File> fileList) {

		try {
			
			Path filePath = Files.createFile(directoryToZip.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
			FileOutputStream fos = new FileOutputStream(filePath.toFile());
			ZipOutputStream zos = new ZipOutputStream(fos);

			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					addToZip(directoryToZip, file, zos);
				}
			}

			zos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getAllFiles(File dir, List<File> fileList) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				fileList.add(file);
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					getAllFiles(file, fileList);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
	IOException {

		FileInputStream fis = new FileInputStream(file);
		
		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		System.out.println("Writing '" + zipFilePath + "' to zip file");
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);
		
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		
		zos.closeEntry();
		fis.close();
		
		
	}
	
	public void createDirectory(String name, List<Resource> resources){
		File parentDirectory = new File(name);
	
		if(!parentDirectory.exists()){
			try {
				Files.createDirectory(parentDirectory.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<resources.size();i++){
			try {
				File openFile = new File(name+"/"+resources.get(i).getId()+".json");
				if(openFile.exists()){
					Path filePath = Files.createFile(openFile.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
					FileWriter file = new FileWriter(filePath.toFile());
					file.write(Utils.objToJson(resources.get(i)));
					file.flush();
					file.close();
				}else{
					Path filePath = Files.createFile(openFile.toPath(),PosixFilePermissions.asFileAttribute(EnumSet.of(PosixFilePermission.OWNER_WRITE,PosixFilePermission.OWNER_READ,PosixFilePermission.OWNER_EXECUTE,PosixFilePermission.GROUP_WRITE,PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_WRITE,PosixFilePermission.OTHERS_EXECUTE)));
					FileWriter file = new FileWriter(filePath.toFile());
					file.write(Utils.objToJson(resources.get(i)));
					file.flush();
					file.close();
				}
			} catch (IOException e) {
//				new ServiceException("Failed to create file(s) for "+ name);
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean deleteDirectory(File directory) {
	    if(directory.exists()){
	        File[] files = directory.listFiles();
	        if(null!=files){
	            for(int i=0; i<files.length; i++) {
	                if(files[i].isDirectory()) {
	                    deleteDirectory(files[i]);
	                }
	                else {
	                    files[i].delete();
	                }
	            }
	        }
	    }
	    return(directory.delete());
	}
	
	public String getCurrentDate(){
		    SimpleDateFormat sdfDate = new SimpleDateFormat("ddMMyyyy");//dd/MM/yyyy
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    return strDate;
	}
}
