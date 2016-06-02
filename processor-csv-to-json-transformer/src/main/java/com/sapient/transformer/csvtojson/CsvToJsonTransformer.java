/**
 * 
 */
package com.sapient.transformer.csvtojson;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.springframework.integration.annotation.Transformer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * @author aamol
 *
 */
public class CsvToJsonTransformer {

	String fieldNames;

	public CsvToJsonTransformer(String fieldNames) {
		this.fieldNames = fieldNames;
	}

	@Transformer
	public Object transform(Object payload) throws IOException {
		Object obj;

		if (payload instanceof byte[]) {
			File csv = new File(System.getProperty("java.io.tmpdir")+"/"+System.currentTimeMillis()+".log");
			csv.deleteOnExit();
			FileUtils.writeByteArrayToFile(csv, (byte[]) payload);
			obj = readObjectsFromCsv(csv);
		} else {
			Map<String, String> map = new HashMap<String, String>();
			List<String> fields = Arrays.asList(fieldNames.split(","));
			Scanner scanner = new Scanner(payload.toString());
			scanner.useDelimiter(",");

			for (String fieldName : fields) {
				map.put(fieldName, scanner.next());
			}
			scanner.close();
			obj = map;
		}

		return obj;

	}

	public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
		CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

		return mappingIterator.readAll();
	}

}
