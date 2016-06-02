/**
 * 
 */
package com.sapient.transformer.csvtojson;

import org.springframework.context.annotation.Configuration;
import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * @author aamol
 *
 */
@Configuration
public class CsvToJsonModuleOptionsMetaData {


	private String fieldNames;


	/**
	 * @return the fieldNames
	 */
	public String getFieldNames() {
		return fieldNames;
	}

	/**
	 * @param fieldNames the fieldNames to set
	 */
	@ModuleOption("Comma Seperated list of field name for mapping to JSON")
	public void setFieldNames(String fieldNames) {
		this.fieldNames = fieldNames;
	}

}
