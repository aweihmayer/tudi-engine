package core.objects.components.shape.graphics.sprite;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class SpriteList {
	protected HashMap<String, SpriteSheet> spriteSheets = new HashMap<String, SpriteSheet>();

// Sprite sheet

	public void add(String name, SpriteSheet sheet) {
		this.spriteSheets.put(name, sheet);
	}

	public SpriteSheet get(String name) {
		return spriteSheets.get(name);
	}

// Load from file

	public void load(String p) {
		NodeList spriteSheetNodes;
		Element spriteSheetNode;
		SpriteSheet spriteSheet;
		NodeList animationNodes;

		spriteSheetNodes = extractSpriteSheetElements(p);
		for(int i = 0; i < spriteSheetNodes.getLength(); i++) {
			spriteSheetNode = (Element) spriteSheetNodes.item(i);
			spriteSheet = makeSpriteSheetFromNode(spriteSheetNode);

			animationNodes = ((Element) spriteSheetNode.getElementsByTagName("animations").item(0)).getElementsByTagName("animation");
			for(int y = 0; y < animationNodes.getLength(); y++) {
				spriteSheet.addAnimation(
					makeAnimationFromNode((Element) animationNodes.item(y)));
			}

			this.add(spriteSheet.getName(), spriteSheet);
		}
	}

	private static SpriteSheet makeSpriteSheetFromNode(Element el) {
		return new SpriteSheet(
				el.getAttribute("name"),
				fetchOneElementContentByName(el, "source"),
				Integer.parseInt(fetchOneElementContentByName(el, "frameWidth")),
				Integer.parseInt(fetchOneElementContentByName(el, "frameHeight")));
	}

	private static SpriteAnimation makeAnimationFromNode(Element el) {
		int[] startValues = extractPairValuesFromElement(el, "start");
		int[] endValues = extractPairValuesFromElement(el, "end");

		return new SpriteAnimation(
				el.getAttribute("name"),
				startValues[0],
				startValues[1],
				endValues[0],
				endValues[1],
				Integer.parseInt(fetchOneElementContentByName(el, "speed")),
				Boolean.parseBoolean(fetchOneElementContentByName(el, "repeat")));
	}

	private static NodeList extractSpriteSheetElements(String configFilePath) {
		//InputStream stream;
		File file;
		DocumentBuilderFactory documentBuilderFactory;
		DocumentBuilder documentBuilder;
		Document document;

		NodeList spriteSheetNodes;

		try {
			//stream = AssetRegistry.class.getResourceAsStream(configFilePath);
			file = new File("./" + configFilePath);
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file); // stream
			spriteSheetNodes = document.getElementsByTagName("sheet");

			return spriteSheetNodes;
		} catch (Exception ex) {
			return null;
		}
	}

	private static int[] extractPairValuesFromElement(Element el, String n) {
		String content;
		String[] rawValues;
		int[] values;

		content = fetchOneElementContentByName(el, n);
		rawValues = content.split(",");
		values = new int[]{
				Integer.parseInt(rawValues[0].trim()),
				Integer.parseInt(rawValues[1].trim())};

		return values;
	}

	private static String fetchOneElementContentByName(Element el, String n) {
		return el.getElementsByTagName(n).item(0).getTextContent();
	}
}
