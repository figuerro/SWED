// Strategie 3: Text Content

public class TextContentStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        String oldText = removeHtmlTags(oldContent);
        String newText = removeHtmlTags(newContent);
        return !oldText.equals(newText);
    }

    private String removeHtmlTags(String content) {
        return content.replaceAll("<[^>]*>", "").trim();
    }
}