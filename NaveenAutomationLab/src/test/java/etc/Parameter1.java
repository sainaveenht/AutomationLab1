package etc;

import org.apache.xmlbeans.impl.repackage.Repackage;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Parameter1 
{

	@Test
	public void testA(XmlTest xmltest1)
	{
	xmltest1.getParameter("city");
	Reporter.log("c", true);
	}
}
