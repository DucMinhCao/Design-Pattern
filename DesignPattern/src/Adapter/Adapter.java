package Adapter;

class VietnameseClient {
	
}

interface VietnameseTarget {
	public void send(String words);
}

class TranslatorAdapter implements VietnameseTarget {

	EnglishAdaptee EnglishAdaptee;
	
	public TranslatorAdapter(EnglishAdaptee englishAdaptee) {
		super();
		EnglishAdaptee = englishAdaptee;
	}

	@Override
	public void send(String words) {
		String translatedWords = this.translate(words);
		EnglishAdaptee.receive(translatedWords);
	}
	
	public String translate(String vietnameseWords) {
		System.out.println("Translated");
		return "Hello everyone";
	}
	
}

class EnglishAdaptee {
	public void receive(String words) {
		System.out.println("Receiving words from adapter...");
		System.out.println(words);
	}
}

public class Adapter {
	public static void main(String[] args) {
		VietnameseTarget client = new TranslatorAdapter(new EnglishAdaptee());
		client.send("Xin chao");
	}
}
