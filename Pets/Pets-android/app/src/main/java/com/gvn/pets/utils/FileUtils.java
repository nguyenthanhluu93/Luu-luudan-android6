package com.gvn.pets.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

public class FileUtils {
	/**
	 * @param output
	 * @param filename
	 * @param append
	 */
	public static void writeFile(byte[] output, String filename, boolean append) {
		try {
			FileOutputStream out = new FileOutputStream(filename, append);
			out.write(output);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String getMimeType(String filePathOrUrl) {
		if (StringUtils.isEmptyOrNull(filePathOrUrl)) return "";
		filePathOrUrl = filePathOrUrl.toLowerCase();
		int idx = filePathOrUrl.lastIndexOf(".");
		if ((idx > 0) && (idx < filePathOrUrl.length() - 1)) {
			String str = filePathOrUrl.substring(idx + 1);
			if (str.equalsIgnoreCase("ai")) return "application/postscript";
			if (str.equalsIgnoreCase("amr")) return "audio/amr";
			if (str.equalsIgnoreCase("apk")) return "application/vnd.android.package-archive";
			if (str.equalsIgnoreCase("aif")) return "audio/x-aiff";
			if (str.equalsIgnoreCase("aiff")) return "audio/x-aiff";
			if (str.equalsIgnoreCase("aifc")) return "audio/x-aiff";
			if (str.equalsIgnoreCase("avi")) return "video/x-msvideo";
			if (str.equalsIgnoreCase("au")) return "audio/basic";
			if (str.equalsIgnoreCase("bcpio")) return "application/x-bcpio";
			if (str.equalsIgnoreCase("cpio")) return "application/x-cpio";
			if (str.equalsIgnoreCase("csh")) return "application/x-csh";
			if (str.equalsIgnoreCase("cpt")) return "application/mac-compactpro";
			if (str.equalsIgnoreCase("cgi")) return "application/x-httpd-cgi";
			if (str.equalsIgnoreCase("cdf")) return "application/x-netcdf";
			if (str.equalsIgnoreCase("cat")) return "text/xml";
			if (str.equalsIgnoreCase("css")) return "text/css";
			if (str.equalsIgnoreCase("doc")) return "application/msword";
			if (str.equalsIgnoreCase("dcr")) return "application/x-director";
			if (str.equalsIgnoreCase("dir")) return "application/x-director";
			if (str.equalsIgnoreCase("dxr")) return "application/x-director";
			if (str.equalsIgnoreCase("dvi")) return "application/x-dvi";
			if (str.equalsIgnoreCase("dtd")) return "text/dtd";
			if (str.equalsIgnoreCase("eps")) return "application/postscript";
			if (str.equalsIgnoreCase("etx")) return "text/x-setext";
			if (str.equalsIgnoreCase("ent")) return "text/xml";
			if (str.equalsIgnoreCase("ief")) return "image/ief";
			if (str.equalsIgnoreCase("ice")) return "x-conference/x-cooltalk";
			if (str.equalsIgnoreCase("gif")) return "image/gif";
			if (str.equalsIgnoreCase("gtar")) return "application/x-gtar";
			if (str.equalsIgnoreCase("gz")) return "application/x-gzip";
			if (str.equalsIgnoreCase("hdf")) return "application/x-hdf";
			if (str.equalsIgnoreCase("jad")) return "text/vnd.sun.j2me.app-descriptor";
			if (str.equalsIgnoreCase("jar")) return "application/java-archive";
			if (str.equalsIgnoreCase("jpeg")) return "image/jpeg";
			if (str.equalsIgnoreCase("jpg")) return "image/jpeg";
			if (str.equalsIgnoreCase("jpe")) return "image/jpeg";
			if (str.equalsIgnoreCase("jnlp")) return "application/x-java-jnlp-file";
			if (str.equalsIgnoreCase("jsp")) return "application/jsp";
			if (str.equalsIgnoreCase("latex")) return "application/x-latex";
			if (str.equalsIgnoreCase("mif")) return "application/x-mif";
			if (str.equalsIgnoreCase("mid")) return "audio/midi";
			if (str.equalsIgnoreCase("mmf")) return "application/vnd.smaf";
			if (str.equalsIgnoreCase("man")) return "application/x-troff-man";
			if (str.equalsIgnoreCase("me")) return "application/x-troff-me";
			if (str.equalsIgnoreCase("ms")) return "application/x-troff-ms";
			if (str.equalsIgnoreCase("nc")) return "application/x-netcdf";
			if (str.equalsIgnoreCase("hqx")) return "application/mac-binhex40";
			if (str.equalsIgnoreCase("html")) return "text/html";
			if (str.equalsIgnoreCase("htm")) return "text/html";
			if (str.equalsIgnoreCase("oda")) return "application/oda";
			if (str.equalsIgnoreCase("pdf")) return "application/pdf";
			if (str.equalsIgnoreCase("ps")) return "application/postscript";
			if (str.equalsIgnoreCase("ppt")) return "application/powerpoint";
			if (str.equalsIgnoreCase("pdb")) return "chemical/x-pdb";
			if (str.equalsIgnoreCase("png")) return "image/png";
			if (str.equalsIgnoreCase("pnm")) return "image/x-portable-anymap";
			if (str.equalsIgnoreCase("pbm")) return "image/x-portable-bitmap";
			if (str.equalsIgnoreCase("pgm")) return "image/x-portable-graymap";
			if (str.equalsIgnoreCase("ppm")) return "image/x-portable-pixmap";
			if (str.equalsIgnoreCase("qcp")) return "audio/vnd.qcelp";
			if (str.equalsIgnoreCase("qt")) return "video/quicktime";
			if (str.equalsIgnoreCase("rtf")) return "application/rtf";
			if (str.equalsIgnoreCase("roff")) return "application/x-troff";
			if (str.equalsIgnoreCase("ram")) return "audio/x-pn-realaudio";
			if (str.equalsIgnoreCase("rpm")) return "audio/x-pn-realaudio-plugin";
			if (str.equalsIgnoreCase("ras")) return "image/x-cmu-raster";
			if (str.equalsIgnoreCase("ra")) return "audio/x-realaudio";
			if (str.equalsIgnoreCase("rgb")) return "image/x-rgb";
			if (str.equalsIgnoreCase("rtx")) return "text/richtext";
			if (str.equalsIgnoreCase("vcd")) return "application/x-cdlink";
			if (str.equalsIgnoreCase("vrml")) return "x-world/x-vrml";
			if (str.equalsIgnoreCase("Z")) return "application/x-compress";
			if (str.equalsIgnoreCase("skp")) return "application/x-koan";
			if (str.equalsIgnoreCase("skd")) return "application/x-koan";
			if (str.equalsIgnoreCase("skt")) return "application/x-koan";
			if (str.equalsIgnoreCase("skm")) return "application/x-koan";
			if (str.equalsIgnoreCase("sh")) return "application/x-sh";
			if (str.equalsIgnoreCase("shar")) return "application/x-shar";
			if (str.equalsIgnoreCase("sit")) return "application/x-stuffit";
			if (str.equalsIgnoreCase("sv4cpio")) return "application/x-sv4cpio";
			if (str.equalsIgnoreCase("sv4crc")) return "application/x-sv4crc";
			if (str.equalsIgnoreCase("snd")) return "audio/basic";
			if (str.equalsIgnoreCase("sgml")) return "text/x-sgml";
			if (str.equalsIgnoreCase("sgm")) return "text/x-sgml";
			if (str.equalsIgnoreCase("src")) return "application/x-wais-source";
			if (str.equalsIgnoreCase("sty")) return "text/xml";
			if (str.equalsIgnoreCase("tar")) return "application/x-tar";
			if (str.equalsIgnoreCase("tcl")) return "application/x-tcl";
			if (str.equalsIgnoreCase("tex")) return "application/x-tex";
			if (str.equalsIgnoreCase("textinfo")) return "application/x-texinfo";
			if (str.equalsIgnoreCase("texi")) return "application/x-texinfo";
			if (str.equalsIgnoreCase("t")) return "application/x-troff";
			if (str.equalsIgnoreCase("tr")) return "application/x-troff";
			if (str.equalsIgnoreCase("tiff")) return "image/tiff";
			if (str.equalsIgnoreCase("tif")) return "image/tiff";
			if (str.equalsIgnoreCase("txt")) return "text/plain";
			if (str.equalsIgnoreCase("tsv")) return "text/tab-separated-values";
			if (str.equalsIgnoreCase("ustar")) return "application/x-ustar";
			if (str.equalsIgnoreCase("mpga")) return "audio/mpeg";
			if (str.equalsIgnoreCase("mp2")) return "audio/mpeg";
			if (str.equalsIgnoreCase("mp3")) return "audio/mpeg";
			if (str.equalsIgnoreCase("mp4")) return "video/mp4";
			if (str.equalsIgnoreCase("mpeg")) return "video/mpeg";
			if (str.equalsIgnoreCase("mpg")) return "video/mpeg";
			if (str.equalsIgnoreCase("mpe")) return "video/mpeg";
			if (str.equalsIgnoreCase("mov")) return "video/quicktime";
			if (str.equalsIgnoreCase("movie")) return "video/x-sgi-movie";
			if (str.equalsIgnoreCase("xaml")) return "application/xaml+xml";
			if (str.equalsIgnoreCase("xbm")) return "image/x-xbitmap";
			if (str.equalsIgnoreCase("xpm")) return "image/x-xpixmap";
			if (str.equalsIgnoreCase("xwd")) return "image/x-xwindowdump";
			if (str.equalsIgnoreCase("xml")) return "text/xml";
			if (str.equalsIgnoreCase("xsl")) return "text/xsl";
			if (str.equalsIgnoreCase("xyz")) return "chemical/x-pdb";
			if (str.equalsIgnoreCase("zip")) return "application/zip";
			if (str.equalsIgnoreCase("wav")) return "audio/x-wav";
			if (str.equalsIgnoreCase("wrl")) return "x-world/x-vrml";
			if (str.equalsIgnoreCase("war")) return "application/java-archive";
			if (str.equalsIgnoreCase("wml")) return "text/vnd.wap.wml";
			if (str.equalsIgnoreCase("wmlc")) return "application/vnd.wap.wmlc";
			if (str.equalsIgnoreCase("wmls")) return "text/vnd.wap.wmlscript";
			if (str.equalsIgnoreCase("wmlsc")) return "application/vnd.wap.wmlscriptc";
			if (str.equalsIgnoreCase("wbmp")) return "image/vnd.wap.wbmp";
			if (str.equalsIgnoreCase("3gp")) return "video/3gp";
			if (str.equalsIgnoreCase("3gpp")) return "audio/3gpp";
			if (str.equalsIgnoreCase("3g2")) return "video/3gpp2";
			//if (str.equalsIgnoreCase("ipa")) return "application/octet-stream";
		}
		return "application/octet-stream";
	}
	
	public static String getExtentionFile(String paramString) {
		int i = paramString.lastIndexOf(".");
		if ((i > 0) && (i < paramString.length() - 1)) {
			return paramString.substring(i + 1);
		}
		return null;
	}
	
	/**
	 * @param location
	 * @param fileExt
	 * @return a vector of <code>File</code> objects
	 */
	public static Vector getAllFiles(File location, String fileExt) {
		Vector v = new Vector();
		File[] list = location.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].toString().endsWith(fileExt)) {
				v.addElement(list[i]);
			}
			/* also list file in subfolders */
			// if ((list[i]).isDirectory()) {
			// getAllFiles(list[i]);
			// }
		}
		return v;
	}

	public static ArrayList<File> getAllFileInFolder(String folderPath) {
		if (StringUtils.isEmptyOrNull(folderPath)) return null;
		File mydir = new File(folderPath);
    	if (mydir != null && mydir.exists()) {
    		return getAllFileInFolder(mydir);
    	}
    	return null;
	}
	
    public static ArrayList<File> getAllFileInFolder(File mydir) {
    	ArrayList<File> mFileInFolder = new ArrayList<File>();
    	if (mydir == null || !mydir.exists()) return mFileInFolder;
		// check for directory
		if (mydir.isDirectory()) {
			// getting list of file paths
			File[] listFiles = mydir.listFiles();
			if (listFiles != null && listFiles.length > 0) {
				// loop through all files or directory
				for (File file :listFiles) {
					if (file.exists() && file.isFile()) {
						mFileInFolder.add(file);
						Log.e("GetAllFileInFolder", "AddFile:" + file.getAbsolutePath());
					} else if (file.isDirectory()) {
						// recursive get sub folder size
						mFileInFolder.addAll(getAllFileInFolder(file));
					}
				}
			}
		} else  if (mydir.exists() && mydir.isFile()) {
			mFileInFolder.add(mydir);
		}
		return mFileInFolder;
    }
    
	/**
	 * @param source_name
	 * @param dest_name
	 * @throws IOException
	 */
	public static void copy(String source_name, String dest_name)
			throws IOException {
		File source_file = new File(source_name);
		File dest_file = new File(dest_name);
		copy(source_file, dest_file);
	}

	/**
	 * @param source_file
	 * @param dest_file
	 * @throws IOException
	 */
	public static void copy(File source_file, File dest_file) throws IOException {
		FileInputStream source = null;
		FileOutputStream destination = null;

		byte[] buffer;
		int bytes_read;

		// First make sure the specified source file
		// exists, is a file, and is readable.
		if (!source_file.exists() || !source_file.isFile())
			throw new FileCopyException("FileCopy: no such source file: "
					+ source_file.getPath());
		if (!source_file.canRead())
			throw new FileCopyException("FileCopy: source file is unreadable: "
					+ source_file.getPath());
		// If we've gotten this far, then everything is okay;
		// we can copy the file.
		source = new FileInputStream(source_file);
		destination = new FileOutputStream(dest_file);
		buffer = new byte[1024];
		while ((bytes_read = source.read(buffer)) != -1) {
			destination.write(buffer, 0, bytes_read);
		}
		// No matter what happens, always close any streams we've opened.
		try {
			if (source != null)
				source.close();
			if (destination != null)
				destination.close();
		} catch (IOException e) {
		}
	}

	/**
	 * @param source_name
	 * @param dest_name
	 * @throws IOException
	 */
	public static void move(String source_name, String dest_name)
			throws IOException {
		File source_file = new File(source_name);
		File dest_file = new File(dest_name);

		copy(source_file, dest_file);
		source_file.delete();
	}

	/**
	 * @param source_file
	 * @param dest_file
	 * @throws IOException
	 */
	public static void move(File source_file, File dest_file)
			throws IOException {
		copy(source_file, dest_file);
		source_file.delete();
	}

	/**
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFile(String filename) throws IOException {
		byte[] buffer = null;
		File f = new File(filename);
		if (!f.exists())
			f.createNewFile();
		FileInputStream fin = new FileInputStream(f);
		buffer = new byte[fin.available()];
		fin.read(buffer);
		return buffer;
	}

	/**
	 * @param output
	 * @param filename
	 * @param append
	 */
	public static void writeToFile(byte[] output, String filename, boolean append) {
		try {
			FileOutputStream out = new FileOutputStream(filename, append);
			out.write(output);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param output
	 * @param filename
	 * @return
	 */
	public static boolean writeFile(byte[] output, String filePathName) {
		boolean result = true;
		try {
			File f = new File(filePathName);
			if (!f.exists()) f.createNewFile();
			FileOutputStream out = new FileOutputStream(f, false);
			out.write(output);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = false;
			return result;

		}
		return result;

	}

	/**
	 * @param output
	 * @param file
	 * @return
	 */
	public static boolean writeFile(byte[] output, File file) {
		boolean result = true;
		try {
			FileOutputStream out = new FileOutputStream(file, false);
			out.write(output);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = false;
			return result;
		}
		return result;

	}
	
	 /**
	 * @author DucHM 
     * Returns the length of String's UTF8 encoding.
     */
	public static int getUTF8Length(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch <= 0x7f) {
                count++;
            } else if (ch <= 0x7ff) {
                count += 2;
            } else {
                count += 3;
            }
        }
        return count;
    }

    /**
     * @author DucHM
     * Returns an array of bytes representing the UTF8 encoding
     * of the specified String.
     */
    public static byte[] getUTF8Bytes(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        // Count the number of encoded bytes...
        int count = 0;
        for (int i = 0; i < len; i++) {
            int ch = c[i];
            if (ch <= 0x7f) {
                count++;
            } else if (ch <= 0x7ff) {
                count += 2;
            } else {
                count += 3;
            }
        }
        // Now return the encoded bytes...
        byte[] b = new byte[count];
        int off = 0;
        for (int i = 0; i < len; i++) {
            int ch = c[i];
            if (ch <= 0x7f) {
                b[off++] = (byte)ch;
            } else if (ch <= 0x7ff) {
                b[off++] = (byte)((ch >> 6) | 0xc0);
                b[off++] = (byte)((ch & 0x3f) | 0x80);
            } else {
                b[off++] = (byte)((ch >> 12) | 0xe0);
                b[off++] = (byte)(((ch >> 6) & 0x3f) | 0x80);
                b[off++] = (byte)((ch & 0x3f) | 0x80);
            }
        }
        return b;
    }
    
	public static void cloneZipFile(InputStream source, File newFile, String fileAddName, String content) {
	    try {
	      System.out.println("New File: " + newFile.getName());

	      ZipInputStream zin = new ZipInputStream(source);
	      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(newFile));
	      
	      ZipEntry zeNew = new ZipEntry(fileAddName);
	      out.putNextEntry(zeNew);
	      out.write(content.getBytes("UTF-8"));
	      out.closeEntry();

	      byte[] buffer = new byte[1024];
	      for (ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry()) {
	        if (!ze.getName().equalsIgnoreCase(zeNew.getName())) {
	          out.putNextEntry(ze);
	          
	          for (int read = zin.read(buffer); read > -1; read = zin.read(buffer)) {
	            out.write(buffer, 0, read);
	          }
	          out.closeEntry();
	        }
	      }
	      out.close();
	      zin.closeEntry();
	      zin.close();
	      System.out.println("Update file: " + newFile.getName() + "\n---Content:\n" + content);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	public static boolean zipFile(InputStream source, File newFile, String fileAddName, String content) {
	    try {
	      System.out.println("New File: " + newFile.getName());

	      ZipInputStream zin = new ZipInputStream(source);
	      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(newFile));
	      
	      ZipEntry zeNew = new ZipEntry(fileAddName);
	      out.putNextEntry(zeNew);
	      out.write(content.getBytes("UTF-8"));
	      out.closeEntry();

	      byte[] buffer = new byte[1024];
	      for (ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry()) {
	        if (!ze.getName().equalsIgnoreCase(zeNew.getName())) {
	          out.putNextEntry(ze);
	          for (int read = zin.read(buffer); read > -1; read = zin.read(buffer)) {
	            out.write(buffer, 0, read);
	          }
	          out.closeEntry();
	        }
	      }
	      out.close();
	      zin.closeEntry();
	      zin.close();
	      System.out.println("Update file: " + newFile.getName() + "\n---Content:\n" + content);
	      return true;
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    return false;
	}
	
	public static void cloneZipFile(File source, File newFile, String fileAddName, String content) {
	    try {
	      System.out.println("New File: " + newFile.getName());
	
	      ZipInputStream zin = new ZipInputStream(new FileInputStream(source));
	      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(newFile));
	      ZipEntry zeNew = new ZipEntry(fileAddName);
	      out.putNextEntry(zeNew);
	      out.write(content.getBytes("UTF-8"));
	      out.closeEntry();
	
	      byte[] buffer = new byte[1024];
	      for (ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry()) {
	        if (!ze.getName().equalsIgnoreCase(zeNew.getName())) {
	          out.putNextEntry(ze);
	          for (int read = zin.read(buffer); read > -1; read = zin.read(buffer)) {
	            out.write(buffer, 0, read);
	          }
	          out.closeEntry();
	        }
	      }
	      out.close();
	      zin.closeEntry();
	      zin.close();
	      System.out.println("Update file: " + source.getName() + "\n---Content:\n" + content);
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	/**
	 * @author DucHM 
	 * @param output
	 * @param filename
	 */
	public static void updateToFile(byte[] output, String filename) {
		try {
			File f = new File(filename);
			if (!f.exists()) {
				f.createNewFile();
			} else {
				f.delete();
				f.createNewFile();
			}
			FileOutputStream out = new FileOutputStream(f, true);
			out.write(output);
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static File newFile(String filePathName) {
		try {
			//int lastIdx = filePathName.lastIndexOf(File.separator);
			int lastIdx = filePathName.lastIndexOf("\\");
			if (lastIdx == -1) lastIdx = filePathName.lastIndexOf("/");
			String parentDir = filePathName.substring(0, lastIdx);
			File f = new File(parentDir);
			if (!f.exists()) f.mkdirs();
			f = new File(filePathName);
			if (!f.exists()) f.createNewFile();
			return f;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	/**
	 * @author DucHM create a Zip file with one element.
	 * @throws IOException if problems writing file out.zip
	 */
    public static void ZipFileWithOneElement(String zipFilename, String elementName) throws IOException {
		// create a zip file with one element
		// specify the name of the zip file.
		//final String zipFilename = "out.zip";
		// get the element file we are going to add, using slashes in name.
		// Open the Zip
		final FileOutputStream fos = new FileOutputStream(zipFilename);
		final ZipOutputStream zip = new ZipOutputStream(fos);
		zip.setLevel(9);
		zip.setMethod(ZipOutputStream.DEFLATED);
		// external file
		final File elementFile = new File(elementName);
		// create the entry
		final ZipEntry entry = new ZipEntry(elementName);
		entry.setTime(elementFile.lastModified());
		// read contents of file external file we are going to put in the zip
		final int fileLength = (int) elementFile.length();
		final FileInputStream fis = new FileInputStream(elementFile);
		final byte[] wholeFile = new byte[fileLength];
		final int bytesRead = fis.read(wholeFile, 0/* offset */, fileLength);
		// checking bytesRead to ensure all read not shown.
		System.out.println(bytesRead + " bytes read from " + elementName);
		fis.close();
		// no need to setCRC, or setSize as they are computed automatically.
		zip.putNextEntry(entry);
		// write the contents directly into the zip just after the zip element
		zip.write(wholeFile, 0, fileLength);
		zip.closeEntry();
		// close the entire zip
		zip.close();
	}
	
    /**
     * @author DucHM
     * read the elements of a Zip file sequentially.
     * @throws IOException if problems writing file a.zip
     */
    public static void readElementsOfAZipFileSequentially(String zipFileName, String targetdir) throws IOException {
		// specify the name of the zip we are going to read
		// -------final String zipFileName = "in.zip";
		// specify the name of the directory where extracted data will go.
		// -------final String targetdir = "targetdir";
		final FileInputStream fis = new FileInputStream(zipFileName);
		final ZipInputStream zip = new ZipInputStream(fis);
		// loop for each entry
		while (true) {
			final ZipEntry entry = zip.getNextEntry();
			if (entry == null) break;
			// relative name with slashes to separate dirnames.
			final String elementName = entry.getName();
			final int fileLength = (int) entry.getSize();
			final byte[] wholeFile = new byte[fileLength];
			// read directly from ZIP after the zip entry.
			final int bytesRead = zip.read(wholeFile, 0, fileLength);
			// checking bytesRead, and repeating if you don't get item all is not shown.
			System.out.println(bytesRead + " bytes read from " + elementName);
			// were we will write the element as an external file
			final File elementFile = new File(targetdir, elementName);
			// make sure dirs exist to hold the external file noinspection ResultOfMethodCallIgnored
			elementFile.getParentFile().mkdirs();
			final FileOutputStream fos = new FileOutputStream(elementFile);
			fos.write(wholeFile, 0, fileLength);
			fos.close();
			// noinspection ResultOfMethodCallIgnored
			elementFile.setLastModified(entry.getTime());
			zip.closeEntry();
		}
		zip.close();
	}
    /**
     * @author DucHM 
     * @param file
     */
    public static void deleteDir(File file) {
    	try {
    		if (file.isDirectory()) {
    			// directory is empty, then delete it
    			if (file.list().length == 0) {
    				file.delete();
    				System.out.println("Directory is deleted : " + file.getAbsolutePath());
    			} else {
    				// list all the directory contents
    				String files[] = file.list();
    				for (String temp : files) {
    					// construct the file structure
    					File fileDelete = new File(file, temp);
    					// recursive delete
    					deleteDir(fileDelete);
    				}
    				// check the directory again, if empty then delete it
    				if (file.list().length == 0) {
    					file.delete();
    					System.out.println("Directory is deleted : " + file.getAbsolutePath());
    				}
    			}
    		} else {
    			// if file, then delete it
    			file.delete();
    			System.out.println("File is deleted : " + file.getAbsolutePath());
    		}
		} catch (Exception e) {
		}
	}
    
	/**
	   * check that all contents of the jar are also in the ZIP and up to date.
	   * @author DucHM
	   * @param jar jar file containing class files
	   * @param zip zip file containing class and other files to distribute
	   */
	public static void checkAllJarInZip(File jar, File zip) {
		try {
			if (!jar.exists()) {
				System.out.println("Warning: missing jar " + jar.toString());
				return;
			}
			if (!zip.exists()) {
				System.out.println("Warning: missing zip " + zip.toString());
				return;
			}
			ZipFile j = new ZipFile(jar);
			ZipFile z = new ZipFile(zip);

			// loop for each jar entry
			for (Enumeration<? extends ZipEntry> e = j.entries(); e.hasMoreElements();) {
				final ZipEntry jarEntry = e.nextElement();

				final String elementName = jarEntry.getName();
				// zip won't have matching manifest
				if (!elementName.startsWith("META-INF/")) {
					final ZipEntry zipEntry = z.getEntry(elementName);
					if (zipEntry == null) {
						System.out.println("Warning: " + zip.toString() + "/" + elementName + " missing");
					} else if (zipEntry.getSize() != jarEntry.getSize()) {
						System.out.println("Warning: " + zip.toString() + "/" + elementName + " size mismatch " + (zipEntry.getSize() - jarEntry.getSize()));
					}
					// we can't do anything with timestamps since zip matches
					// the corresponding element,
					// where jar is the time the element was added to the jar,
					// i.e. jar create time.
				} else {
					System.out.println("jarEntry=" + jarEntry.toString());
					System.out.println("======================");
					
					Manifest manifest = new Manifest(Thread.currentThread().getContextClassLoader().getResourceAsStream(elementName));
					Attributes attributes = manifest.getMainAttributes();
			        String impVersion = attributes.getValue("Implementation-Version");
			        System.out.println(impVersion);
			        //String mCroEditConf = manifest.getAttributes("MicroEdition-Configuration").toString();
			        //System.out.println(mCroEditConf);
			        
			        Properties prop = new Properties();
			        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(elementName));
			        System.out.println("All attributes:" + prop.propertyNames());
				}
			}// end for
			j.close();
			z.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("jar or zip i/o problem");
		}
	}
	
	/**
	 *@author DucHM  
	 * @param jar
	 */
	public static void getManifestInJar(File jar) {
		try {
			if (!jar.exists()) {
				System.out.println("Warning: missing jar " + jar.toString());
				return;
			}
			JarFile jarf = new JarFile(jar);
			// loop for each jar entry
			for (Enumeration<? extends ZipEntry> e = jarf.entries(); e.hasMoreElements();) {
				final ZipEntry jarEntry = e.nextElement();

				final String elementName = jarEntry.getName();
				// zip won't have matching manifest
				if (elementName.startsWith("META-INF/")) {
					final Manifest manifest = jarf.getManifest();
					Attributes attributes = manifest.getMainAttributes();
					System.out.println("---------------Manifest attributes values----------------------");
					for (Object a : attributes.keySet()) {
		                System.out.println("\t " + a + ": " + attributes.getValue((Name)a));
		            }
				}
			}// end for
			jarf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("jar or zip i/o problem");
		}
	}
	
	/**
	 * @author DucHM 
	 * @param jar
	 */
	public static void getMIDletInJar(File jar) {
		try {
			if (!jar.exists()) {
				System.out.println("Warning: missing jar " + jar.toString());
				return;
			}
			JarFile jarf = new JarFile(jar);
			// loop for each jar entry
			for (Enumeration<? extends ZipEntry> e = jarf.entries(); e.hasMoreElements();) {
				final ZipEntry jarEntry = e.nextElement();

				final String elementName = jarEntry.getName();
				// zip won't have matching manifest
				if (!elementName.startsWith("META-INF/")) {
					System.out.println("\t/" + elementName + " size:" + jarEntry.getSize());
				}
			}// end for
			jarf.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("jar or zip i/o problem");
		}
	}
    
	/**
	 * @author DucHM 
	 * @param jar
	 * @param newJadFilePathName
	 * @return
	 */
	public static boolean makeJadFromJar(File jar, String newJadFilePathName) {
		try {
			//FileInputStream fStream = new FileInputStream(newJadFilePathName);
			if (!jar.isFile() || !jar.exists()) {
				System.out.println("Warning: missing jar " + jar.getAbsolutePath());
				return false;
			}
			String sJad = "";
			JarFile jarf = new JarFile(jar);
			// loop for each jar entry
			for (Enumeration<? extends ZipEntry> e = jarf.entries(); e.hasMoreElements();) {
				final ZipEntry jarEntry = e.nextElement();

				final String elementName = jarEntry.getName();
				// zip won't have matching manifest
				if (elementName.startsWith("META-INF/")) {
					final Manifest manifest = jarf.getManifest();
					Attributes attributes = manifest.getMainAttributes();
					for (Object a : attributes.keySet()) {
		                sJad += (a + ": " + attributes.getValue((Name)a)) + "\n";
		            }
				}
			}// end for
			if (StringUtils.isEmptyOrNull(sJad)) {
				System.out.println("Can't make jad from Jar. Error process read META-INF/MANIFEST.MF file!");
				return false;
			}
			if (!sJad.toLowerCase().contains("midlet-jar-size:")) sJad += "MIDlet-Jar-Size: " + jar.length() + "\n";
			if (!sJad.toLowerCase().contains("midlet-jar-url:")) sJad += "MIDlet-Jar-URL: " + jar.getName() + "\n";
			sJad = sJad.replaceAll("\n\n", "\n");
			System.out.println("----------------Make Jad file -----------------");
			System.out.print(sJad);
			jarf.close();
			if (StringUtils.isEmptyOrNull(newJadFilePathName)) newJadFilePathName = jar.getAbsolutePath().replaceFirst(".jar", ".jad");
			boolean result = writeFile(sJad.getBytes("UTF-8"), newJadFilePathName);
			System.out.println("------------------result=" + result + "---------------------------");
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("jar or zip i/o problem!");
		}
		return false;
	}
	
	public static boolean writeFileFromInputStream(InputStream inputStream, File destFile) {
		boolean result = true;
		try {
			System.out.println("destFile.getAbsoluteFile()=" + destFile.getAbsoluteFile());
			System.out.println("destFile.getAbsolutePath()=" + destFile.getAbsolutePath());
			System.out.println("destFile.getName()=" + destFile.getName());
			
			FileOutputStream out = new FileOutputStream(destFile, false);
			int read = 0;
			byte[] bytes = new byte[1024];
		 
			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			inputStream.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("writeFileFromInputStream=" + e.getMessage());
			result = false;
			return result;
		}
		return result;
	}
	
	public static String convertInputStreamToString(InputStream in) {
		try {
			InputStreamReader is = new InputStreamReader(in, "UTF-8");
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(is);
			String read = br.readLine();
			while(read != null) {
			    sb.append(read).append("\n");
			    read = br.readLine();
			}
			return sb.toString();
		} catch (Exception e) {
			System.out.println("convertInputStreamToString.Exception=" + e.getMessage());
		}
		return null;
	}
	
	public static boolean makeJadFromJarPathSrc(String jarFilePathName, String newJadFilePathName) {
		try {
			File jar = new File(jarFilePathName);
			return (makeJadFromJar(jar, newJadFilePathName));
		} catch (Exception e) {
		}
		return false;
	}
	
	
    public static String convertStreamToString(InputStream is) throws Exception {
        try {
        	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
        return "";
    }

    public static String getStringFromFile(File file) throws Exception {
        try {
        	FileInputStream fin = new FileInputStream(file);
            String ret = convertStreamToString(fin);
            //Make sure you close all streams.
            fin.close();
            return ret;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
    }

    public static InputStream getInputStreamFromFile(File file) throws Exception {
        try {
        	InputStream inputStream = new FileInputStream(file);
        	return inputStream;
		} catch (Exception e) {
			// TODO: handle exception
		}
        return null;
    }

	public static void copyDirectoryOneLocationToAnotherLocation(
			File sourceLocation, File targetLocation) throws IOException {

		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < sourceLocation.listFiles().length; i++) {

				copyDirectoryOneLocationToAnotherLocation(new File(
						sourceLocation, children[i]), new File(targetLocation,
						children[i]));
			}
		} else {

			InputStream in = new FileInputStream(sourceLocation);

			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}

	}
    
    public static Uri getUriVideoFromFile(Context context, File videoFile) {
        Uri uri = null;
        try {
        	String thumbPath = context.getExternalCacheDir().getPath() + "/" + videoFile.getName() + "_" + videoFile.length() + "_" + videoFile.lastModified();
            Log.i("getUriVideoFromFile", "thumbPath=" + thumbPath);
        	File thumbFile = new File(thumbPath);
            if (thumbFile != null && thumbFile.exists()) {
                uri = Uri.fromFile(thumbFile);
            } else {
                try {
                    thumbFile.createNewFile();
                    Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoFile.getAbsolutePath(), MediaStore.Video.Thumbnails.MINI_KIND);
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 0, bytes);
                    FileOutputStream fo = new FileOutputStream(thumbFile);
                    fo.write(bytes.toByteArray());
                    fo.close();
                    uri = Uri.fromFile(thumbFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return uri;
    }
    
    public static String getThumbPathVideoFromFile(Context context, File videoFile) {
        try {
        	String thumbPath = context.getExternalCacheDir().getPath() + "/" + videoFile.getName() + "_" + videoFile.length() + "_" + videoFile.lastModified();
            Log.i("getUriVideoFromFile", "thumbPath=" + thumbPath);
        	File thumbFile = new File(thumbPath);
            if (thumbFile != null && thumbFile.exists()) {
                return thumbFile.getAbsolutePath();//thumbFile.getPath();//
            }
            try {
                thumbFile.createNewFile();
                Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoFile.getAbsolutePath(), MediaStore.Video.Thumbnails.MINI_KIND);
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, bytes);
                FileOutputStream fo = new FileOutputStream(thumbFile);
                fo.write(bytes.toByteArray());
                fo.close();
                return thumbFile.getAbsolutePath();//thumbFile.getPath();//
            } catch (IOException e) {
                e.printStackTrace();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "";
    }

	
    public static void CopyStream(InputStream is, OutputStream os) {
        final int buffer_size=1024;
        try
        {
            byte[] bytes=new byte[buffer_size];
            for(;;)
            {
              int count=is.read(bytes, 0, buffer_size);
              if(count==-1)
                  break;
              os.write(bytes, 0, count);
            }
        }
        catch(Exception ex){}
    }
    
    public static void main(String[] args) {
		
	}
}

/**
 * ****************************************************
 * @author DucHM
 *
 */
class FileCopyException extends IOException {
	public FileCopyException(String msg) {
		super(msg);
	}
}
