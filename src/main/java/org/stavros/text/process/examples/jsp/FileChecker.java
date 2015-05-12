package org.stavros.text.process.examples.jsp;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector.SelectorParseException;
import org.stavros.text.process.module.AbstractFileXmlProcessor;
import org.stavros.text.process.module.Finding;

public class FileChecker extends AbstractFileXmlProcessor {
	
	private String tagName;
	private String idAttr;
	private String checkAttr;
	
	public FileChecker(String tagName, String idAttr, String checkAttr) {
		this.tagName = tagName;
		this.idAttr = idAttr;
		this.checkAttr = checkAttr;
	}
	
	private List<Finding> processElements(Elements elements) {
		for (Element element:elements) {
			String idAttrValue = element.attr(idAttr);
			String checkAttrValue = element.attr(checkAttr);
			
			StringBuilder sb = new StringBuilder();
			sb.append("IdAttr: ").append(idAttr).append("\n")
				.append("IdAttrValue: ").append(idAttrValue).append("\n")
				.append("CheckAttr: ").append(checkAttr).append("\n")
				.append("CSS selector: ");
			try {
				sb.append(element.cssSelector());
			}
			catch(SelectorParseException spe) {
				sb.append("N/A");
			}
			sb.append("\n");
			
			if (checkAttrValue == null || "".equals(checkAttrValue)) {
				sb.append("=================MISSING");
			}
			else {
				sb.append("CheckTagValue: ").append(checkAttrValue);
			}
			
			System.out.println(sb.toString());
		}
		return new ArrayList<>();
	}

	@Override
	protected List<Finding> processDocument(Document doc) {
		Elements elements = doc.getElementsByTag(tagName);
		System.out.println("Processing xml file relevant elements: " + elements.size());
		return processElements(elements);
	}

}
