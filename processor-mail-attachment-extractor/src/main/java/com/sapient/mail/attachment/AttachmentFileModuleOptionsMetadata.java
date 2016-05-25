/**
 * 
 */
package com.sapient.mail.attachment;

import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * @author Amol
 *
 */
public class AttachmentFileModuleOptionsMetadata {

	/**
	 * The FileReadingMode to use for file reading sources. Values are 'ref' -
	 * The File object,'lines' - a message per line ,or 'contents' - the
	 * contents as bytes. Default is 'contents'
	 */
	private String fileReadingmode = "contents";

	/**
	 * Set to true to emit start of file/end of file marker messages
	 * before/after the data. Only valid with FileReadingMode 'lines'.
	 */
	private Boolean withMarkers = null;

	/**
	 * @return the fileReadingmode
	 */
	public String getFileReadingmode() {
		return fileReadingmode;
	}

	/**
	 * @param fileReadingmode
	 *            the fileReadingmode to set
	 */
	@ModuleOption("How File should be read. Valid values ref - 'File Object' , lines - 'A message per line' or contents(Default) - 'Contents as bytes''")
	public void setFileReadingmode(String fileReadingmode) {
		this.fileReadingmode = fileReadingmode;
	}

	/**
	 * @return the withMarkers
	 */
	public Boolean getWithMarkers() {
		return withMarkers;
	}

	/**
	 * @param withMarkers
	 *            the withMarkers to set
	 */
	@ModuleOption("Set to true to emit start of file/end of file marker messages before/after the data - Valid with lines reading mode")
	public void setWithMarkers(Boolean withMarkers) {
		this.withMarkers = withMarkers;
	}

}
