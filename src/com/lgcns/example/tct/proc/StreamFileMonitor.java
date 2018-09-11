package com.lgcns.example.tct.proc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamFileMonitor {

	public static void main(String[] args) {
		List<FileMonitorInfo> monitorInfoList = Arrays.asList(new FileMonitorInfo("aaa.txt", "SIZE>20"),
				new FileMonitorInfo("bbb.txt", "SIZE>12"),
				new FileMonitorInfo("ccc.txt", "SIZE>4"));
		System.out.printf("dirFileList: %s\n", monitorInfoList);

		File[] dirFileList = new File("resource").listFiles();
		System.out.printf("dirFileList: %s\n", Arrays.toString(dirFileList));
		
		List<FileMonitorInfo> listNotExist = new ArrayList<FileMonitorInfo>();
        for (FileMonitorInfo fileMonitorInfo : monitorInfoList) {
			Arrays.asList(dirFileList).stream()
			.filter(fileInfo -> StreamFileMonitor.containsName(fileMonitorInfo, fileInfo))
			.findFirst();
// 			.orElse(fileMonitorInfo -> listNotExist.add(fileMonitorInfo));
			
/*		
			Arrays.asList(dirFileList).stream()
			.filter(fileInfo -> StreamFileMonitor.containsName(fileMonitorInfo, fileInfo))
			.findFirst()
			.ifPresent(fileInfo -> printFileInfo(fileMonitorInfo));
*/			
		}
	}
	
	public static boolean containsName(FileMonitorInfo fileMonitorInfo, File file){
		return fileMonitorInfo.getName().equals(file.getName());
	}
	
	public static void printFileInfo(FileMonitorInfo fileMonitorInfo){
		System.out.printf("printFileInfo[name: %s, size: %s]\n", fileMonitorInfo.getName(), fileMonitorInfo.getSizeExpr());
	}

}

class FileMonitorInfo {

	private String name;
	private String sizeExpr;

	public FileMonitorInfo(String name, String sizeExpr) {
		super();
		this.name = name;
		this.sizeExpr = sizeExpr;
	}

	public boolean checkSize(int size) {
		String[] split = null; 
		if(sizeExpr.indexOf(">") > -1) {
			split = sizeExpr.split(">");
			if(size > Integer.parseInt(split[1])) {
				return true;
			}
		} else if(sizeExpr.indexOf("<") > -1) {
			split = sizeExpr.split("<");
			if(size < Integer.parseInt(split[1])) {
				return true;
			}
		}
		return false;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSizeExpr() {
		return sizeExpr;
	}

	public void setSizeExpr(String sizeExpr) {
		this.sizeExpr = sizeExpr;
	}

	@Override
	public String toString() {
		return "FileInfo [" + (name != null ? "name=" + name + ", " : "")
				+ (sizeExpr != null ? "sizeExpr=" + sizeExpr : "") + "]";
	}

}