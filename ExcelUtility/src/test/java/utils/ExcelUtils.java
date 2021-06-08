package utils;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	 static String val;
	
	public static void main(String[] args) throws IOException {
	
		getCellData(1, 0); //Sheet 2 cell A values. This can be changed for different columns
		
		
	}

public static void getCellData(int rowNum, int colNum) throws IOException {
		
		String excelPath = "./data/SimpleTask.xlsx";
		XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
		XSSFSheet sheet = workbook.getSheet("Sheet2"); //The sheet number is specified here
	
	
			FileWriter myWriter = new FileWriter("result2.txt");
			try {
			try {
				int noOfRows = sheet.getLastRowNum();
				for (int i =1; i<=noOfRows; i++) {
					DataFormatter formatter = new DataFormatter();
					Object val = formatter.formatCellValue(sheet.getRow(i).getCell(colNum));
					
				      myWriter.write("@prefix fhir: <http://hl7.org/fhir/> .\n");
				      myWriter.write("@prefix loinc: <http://loinc.org/rdf#> .\n");
				      myWriter.write("@prefix owl: <http://www.w3.org/2002/07/owl#> .\n");
				      myWriter.write("@prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .\n");
				      myWriter.write("@prefix xsd: <http://www.w3.org/2001/XMLSchema#> .\n");
				      myWriter.write("# - resource -------------------------------------------------------------------\n");
				      myWriter.write(" <http://hl7.org/fhir/Observation/"+val+"> a fhir:Observation;\n");
				      myWriter.write(" fhir:nodeRole fhir:treeRoot;\n");
				      myWriter.write(" fhir:Resource.id [ fhir:value "+val+"];\n");
				      myWriter.write("fhir:DomainResource.text [\n");
				      myWriter.write("fhir:Narrative.status [ fhir:value generated ];\n");
				      myWriter.write("fhir:Narrative.div No HTML content ];\n");
				      myWriter.write("fhir:Observation.identifier [\n");
				      myWriter.write("fhir:index 0;\n");
				      myWriter.write("fhir:Identifier.use [ fhir:value official ];\n");
				      myWriter.write("fhir:Identifier.system [ fhir:value http://www.bmc.nl/zorgportal/identifiers/observations ];\n");
				      myWriter.write("fhir:Identifier.value [ fhir:value 6323 ]\n");
				      myWriter.write("]\n");
				      myWriter.write("fhir:Observation.status [ fhir:value final];\n");
				      myWriter.write("fhir:Observation.code \n");
				      myWriter.write("fhir:CodeableConcept.coding [\n");
				      myWriter.write("fhir:index 0;\n");
				      myWriter.write("a loinc:Sheet1.Definition.Code;\n");
				      myWriter.write("fhir:Coding.system [ fhir:value http://loinc.org ];\n");
				      myWriter.write("fhir:Coding.code [ fhir:value "+sheet+".Definition.Code ];\n");
				      myWriter.write("fhir:Coding.display [ fhir:value "+sheet+".Definition from LOINC ]\n");
				      myWriter.write(" ]\n");
				      myWriter.write("];\n");
				      myWriter.write("fhir:Observation.subject [\n");
				      myWriter.write("fhir:link <http://hl7.org/fhir/Patient/"+val+">;\n");
				      myWriter.write("fhir:Reference.reference [ fhir:value Patient/"+val+" ];\n");
				      myWriter.write("fhir:Reference.display [ fhir:value "+val+"_Anonymized ]\n");
				      myWriter.write("];\n");   
				      myWriter.write("fhir:Observation.code [\n");
				      myWriter.write("fhir:String.value [ fhir:value "+sheet+".Variable_name_label^^xsd:String ]\n");
				      myWriter.write("];\n");
				      myWriter.write("fhir:Observation.valueString [\n");
				      myWriter.write("fhir:String.value [ fhir:value "+sheet+".Variable_Description^^xsd:String ]\n");
				      myWriter.write("];\n");
				      myWriter.write("fhir:Observation.valueQuantity [\n");
				      myWriter.write("fhir:Quantity.value [ fhir:value "+val+"^^xsd:sheet.Type ];\n");
				      myWriter.write("fhir:Quantity.unit [ fhir:value "+sheet+".Unit/Item Value ]\n");
				      myWriter.write("].\n");
				      myWriter.write("<http://hl7.org/fhir/Patient/"+val+"> a fhir:Patient .\n");
				      myWriter.write("<http://hl7.org/fhir/Practitioner/fxxx> a fhir:Practitioner .\n");
				      myWriter.write("# - ontology header ------------------------------------------------------------\n");
				      myWriter.write("<http://hl7.org/fhir/Observation/"+val+".ttl> a owl:Ontology;\n");
				      myWriter.write("owl:imports fhir:fhir.ttl;\n");
				      myWriter.write("owl:versionIRI <http://build.fhir.org/Observation/"+val+".ttl> .\n");
				      myWriter.write(" # -------------------------------------------------------------------------------------\n\n\n\n\n");
					
				      myWriter.flush();
				}
			}finally {
				myWriter.close();
			}
			} catch (IOException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Successfully written to the file");
		
		

		}
		
		
		
	}




		
	

