package com.java.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBApp {

	public static void main(String[] args) {
		File file=new File("src/employee.xml");
		try(FileInputStream fin=new FileInputStream(file)){
			JAXBContext contextObj=JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshaller=contextObj.createUnmarshaller();
			
			Employee employee=(Employee)unmarshaller.unmarshal(fin);
			System.out.println("Employee Details");
			System.out.println(employee.getId()+":"+employee.getName());
			System.out.print("Contact: ");
			List<Contact> contactList=employee.getContact();
			for(Contact contact:contactList)
				System.out.println(contact.getContactType()+":"+contact.getContactNumber());
			
			System.out.println("UnMarshalled Successfully");
		}
		catch(JAXBException |IOException exception){
			exception.printStackTrace();
		}
	}
}